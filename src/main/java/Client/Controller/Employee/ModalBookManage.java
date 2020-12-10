package Client.Controller.Employee;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.Book;
import Model.Category;
import Model.Language;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-07
 * Time: 14:50
 * Project: Bibliotek
 * Copyright: MIT
 */
public class ModalBookManage implements Initializable {
    private static Stage stage;
    public TextField id;
    public Button updateBtn;
    public Button removeBtn;
    private Book book;
    public TextField title;
    public TextField isbn;
    public TextField author;
    public ComboBox category;
    public ComboBox language;
    public TextArea description;
    public TextField publisher;
    public TextField edition;
    public DatePicker releaseDate;
    public TextField numberOfPages;


    public static void displayBookManage(Class<?> currentClass) {
        Scene scene = ControllerUtil.loadModalScene(currentClass, "/view/employee/modalBookManage.fxml");
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeModal() {
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*-------------Category-------------------*/
        //Hämta alla category enum
        Category[] categoryArr = Category.values();
        //Sätta alla category namn i dropdown menu
        for (Category categoryItem : categoryArr) {
            category.getItems().add(categoryItem.getCategory());
        }

        /*-------------Languages-------------------*/
        //Hämta alla language enum
        Language[] languageArr = Language.values();
        //Sätta alla language namn i dropdown menu
        for (Language languageItem : languageArr) {
            language.getItems().add(languageItem);
        }

        book = BookUtil.selectedBook;
        //Sätta alla bok info i textfield
        id.setText(book.getId());
        title.setText(book.getTitle());
        isbn.setText(book.getIsbn());
        author.setText(book.getAuthor());
        category.setValue(book.getCategory().getCategory());
        language.setValue(book.getLanguage().name());
        description.setText(book.getDescription());
        publisher.setText(book.getPublisher());
        edition.setText(book.getEdition());
        releaseDate.setValue(book.getReleaseDate());
        numberOfPages.setText(book.getNumberOfPages());

        if(book.getIsCheckOut()) {
            removeBtn.setVisible(false);
        }
    }

    public void actionUpdate(ActionEvent actionEvent) {
    }

    public void actionRemove(ActionEvent actionEvent) {
    }
}
