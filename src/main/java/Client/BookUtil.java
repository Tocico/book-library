package Client;

import Client.Controller.LogIn;
import Client.Controller.Modal;
import DAO.BookDao;
import DAO.HistoryDao;
import Model.*;
import Model.UserEntities.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-01
 * Time: 13:36
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class BookUtil {
    public static Book selectedBook;
    public static BookDao bookDao = new BookDao();
    public static HistoryDao historyDao = new HistoryDao();


    //Skriv ut sökresultat
    public static void printOutSearchResult(String searchWord, TableView searchView,
                                            TableColumn<Book, String> title, TableColumn<Book, String> author,
                                            TableColumn<Book, String> language, TableColumn<Book, String> category,
                                            Text message, Class<?> currentClass) {

        ObservableList<Book> bookData = searchView.getItems();

        try {
            searchView.setVisible(false);
            List<Book> books = bookDao.searchBook(searchWord);
            if (books.size() == 0 || books.equals(null)) {
                message.setText("Din sökning gav inga träffar. Försök igen.");
            } else {
                message.setText("");
                searchView.setVisible(true);

                //Skriv ut sökresultat
                for (Book book : books) {
                    title.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTitle()));
                    author.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getAuthor()));
                    language.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getLanguage().toString()));
                    category.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getCategory().getCategory()));
                    bookData.add(book);
                }
                searchView.setItems(bookData);
                //Open modal window
                searchView.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) ->
                {
                    selectedBook = bookDao.getById(newVal.toString());
                    Modal.displayBook(currentClass);
                });
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    //Skriv ut utlåningshistorik
    public static void printOutLendingHistory(TableView historyView, TableColumn<History, String> title, TableColumn<History, String> isbn,
                                              TableColumn<History, String> returnDate, TableColumn<History, String> lendOutDate) {

        ObservableList<History> historyData = historyView.getItems();
        List<History> histories = historyDao.getHistoryList(LogIn.currentLoggedInUser.getsSN());

        if (histories != null) {
            for (History history : histories) {
                title.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getBook().getTitle()));
                isbn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getBook().getIsbn()));
                lendOutDate.setCellValueFactory(cellData -> new SimpleObjectProperty(String.valueOf(cellData.getValue().getLendOutDate())));
                if (history.getReturnDate() == null)
                    returnDate.setCellValueFactory(cellData -> new SimpleObjectProperty(""));
                else
                    returnDate.setCellValueFactory(cellData -> new SimpleObjectProperty(String.valueOf(cellData.getValue().getReturnDate())));
                historyData.add(history);
            }
            historyView.setItems(historyData);
        }
    }

    //Registrera bok
    public static void registerBook(String title, String isbn, String author, String edition,
                                    String numberOfPages, String description,
                                    String publisher, String category,
                                    String language, LocalDate releaseDate, int numberOfBooks) throws IOException {

        //Instansera Bok objekt beroende på antal bok
        for (int i = 0; i < numberOfBooks; i++) {

            Book registerBook = new Book()
                    .setTitle(title)
                    .setIsbn(isbn)
                    .setAuthor(author)
                    .setEdition(edition)
                    .setNumberOfPages(numberOfPages)
                    .setDescription(description)
                    .setPublisher(publisher)
                    .setReleaseDate(releaseDate);

            if (category.length() != 0) {
                registerBook.setCategory(Category.getByStringCategoryName(category));
            }
            if (language.length() != 0) {
                registerBook.setLanguage(Language.valueOf(language));
            }

            bookDao.save(registerBook);

        }
    }

    public static History registerLendOutBook(String ssn, String isbn) throws IOException {
        User user = UserUtil.userDao.getById(ssn);
        Book book = bookDao.getByIsbn(isbn);

        //Sätt true på isCheckOut och updatera
        book.setIsCheckOut(true);
        bookDao.update(book);

        //Skapa history objekt
        History history = new History()
                .setUser(user)
                .setBook(book)
                .setLendOutDate(LocalDate.now());

        //Add new history
        historyDao.save(history);

        return history;
    }

    public static History registerReturnedBook(String ssn, String isbn) throws IOException {
        History history = historyDao.getByIdAndIsbn(ssn, isbn);
        history.setReturnDate(LocalDate.now());

        //Sätt false på isCheckOut och updatera
        Book returnedBook = bookDao.getById(history.getBook().getId());
        returnedBook.setIsCheckOut(false);
        bookDao.update(returnedBook);

        historyDao.update(history);

        return history;
    }
}
