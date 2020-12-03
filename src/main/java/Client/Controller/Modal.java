package Client.Controller;

import Client.BookUtil;
import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-02
 * Time: 14:13
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class Modal implements Initializable {

    private static Stage stage;
    private static Book book;
    public TextField title;
    public TextField isbn;
    public TextField author;
    public TextField category;
    public TextField language;
    public TextField description;
    public TextField publisher;
    public TextField edition;
    public TextField releaseDate;
    public TextField numberOfPages;
    public TextField available;
    public TextField location;


    public static void displayBook(Class<?> currentClass) {
        Scene scene = ControllerUtil.loadModalScene(currentClass, "/view/modal.fxml");
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeModal() {
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        book = BookUtil.selectedBook;
        //Sätta alla bok info i textfield
        title.setText(book.getTitle());
        isbn.setText(book.getIsbn());
        author.setText(book.getAuthor());
        category.setText(book.getCategory().getCategory());
        language.setText(book.getLanguage().name());
        description.setText(book.getDescription());
        publisher.setText(book.getPublisher());
        edition.setText(book.getEdition());
        releaseDate.setText(String.valueOf(book.getReleaseDate()));
        numberOfPages.setText(book.getNumberOfPages());
        available.setText(String.valueOf(book.getNumberOfBooks()));
        //location.setText(book.getLocation().getLibraryName());
    }
}
