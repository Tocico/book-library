package Client;

import Client.Controller.LogIn;
import Client.Controller.Modal;
import DAO.BookDao;
import DAO.HistoryDao;
import Model.Book;
import Model.Category;
import Model.History;
import Model.Language;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-01
 * Time: 13:36
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class BookUtil {
    private static ObservableList<Book> bookData = FXCollections.observableArrayList();
    private static ObservableList<History> historyData = FXCollections.observableArrayList();
    public static Book selectedBook;
    public static BookDao bookDao = new BookDao();

    //Hämta ut alla boklista
    public static List<Book> getAllBookList() {
        return bookDao.getAll();
    }

    /**
     * Ta bort white space
     *
     * @param text t.ex Harry Potter
     * @return harrypotter
     */
    public static String removeWhiteSpace(String text) {
        String[] split = text.split(" ");
        text = "";
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0)
                text = text.concat(split[i]).toLowerCase();
        }
        return text;
    }

    //Boksök funktion
    public static List<Book> searchBook(String searchWord) {

        List<Book> bookList = getAllBookList();
        List<Book> hitSearchBookList = new ArrayList<>();
        searchWord = removeWhiteSpace(searchWord);

        for (Book book : bookList) {
            String title = removeWhiteSpace(book.getTitle());
            String isbn = book.getIsbn();
            String category = book.getCategory().toString().toLowerCase();
            String author = removeWhiteSpace(book.getAuthor());
            if (title.contains(searchWord) || isbn.contains(searchWord) ||
                    category.contains(searchWord) || author.contains(searchWord)) {
                hitSearchBookList.add(book);
            }
        }
        return hitSearchBookList;
    }

    //Skriv ut sökresultat
    public static void printOutSearchResult(String searchWord, TableView searchView,
                                            TableColumn<Book, String> title, TableColumn<Book, String> author,
                                            TableColumn<Book, String> language, TableColumn<Book, String> category,
                                            Text message, Class<?> currentClass) {

        searchView.getItems().clear();
        searchView.setVisible(false);
        List<Book> books = BookUtil.searchBook(searchWord);
        if (books.size() == 0) {
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
        }

        //Open modal window
        searchView.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) ->
        {
            selectedBook = getBook(newVal.toString());
            Modal.displayBook(currentClass);
        });

    }

    //Skriv ut utlåningshistorik
    public static void printOutLendingHistory(TableView historyView, TableColumn<History, String> title, TableColumn<History, String> isbn,
                                              TableColumn<History, String> returnDate, TableColumn<History, String> lendOutDate) {

        //TODO:: Fixa bugg att ta bort föregående historik

       List<History> histories = UserUtil.getLoggedInUserHistory(LogIn.currentLoggedInUser);

        if (histories != null) {
            for (History history : histories) {
                title.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getBook().getTitle()));
                isbn.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getBook().getIsbn()));
                returnDate.setCellValueFactory(cellData -> new SimpleObjectProperty(String.valueOf(cellData.getValue().getReturnDate())));
                lendOutDate.setCellValueFactory(cellData -> new SimpleObjectProperty(String.valueOf(cellData.getValue().getLendOutDate())));
                historyData.add(history);
            }
            historyView.setItems(historyData);

        }

    }

    //Hämta ut en bok
    public static Book getBook(String isbn) {

        List<Book> bookList = getAllBookList();
        Book tempBook = new Book();
        for (Book book : bookList) {
            if (book.getIsbn().equals(isbn))
                tempBook = book;
        }
        return tempBook;
    }

    public static void registerBook(String title, String isbn, String author, String edition,
                                    String numberOfPages, String description,
                                    String publisher, String category,
                                    String language, LocalDate releaseDate) {

        Book registerBook = new Book()
                .setTitle(title)
                .setIsbn(isbn)
                .setAuthor(author)
                .setEdition(edition)
                .setNumberOfPages(numberOfPages)
                .setDescription(description)
                .setPublisher(publisher)
                .setReleaseDate(releaseDate);

        if(category.length() != 0) {
            registerBook.setCategory(Category.getByStringCategoryName(category));
        } if(language.length() != 0) {
            registerBook.setLanguage(Language.valueOf(language));
        }

        bookDao.save(registerBook);
    }
}
