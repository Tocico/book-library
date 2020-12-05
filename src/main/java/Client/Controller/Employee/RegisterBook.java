package Client.Controller.Employee;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Client.Controller.SuccessModal;
import Model.Category;
import Model.Language;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-04
 * Time: 13:34
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class RegisterBook implements Initializable {
    public AnchorPane registerBook;
    public ComboBox category;
    public ComboBox language;
    public DatePicker releaseDate;
    public TextField titleT;
    public TextField isbnT;
    public TextField authorT;
    public TextField editionT;
    public TextField numberOfPagesT;
    public TextArea descriptionT;
    public TextField publisherT;
    public Text message;
    public Button regiBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*-------------Category-------------------*/
        //Hämta alla category enum
        Category[] categoryArr = Category.values();
        //Sätta alla category namn i dropdown menu
        for(Category categoryItem: categoryArr) {
            category.getItems().add(categoryItem.getCategory());
        }

        /*-------------Languages-------------------*/
        //Hämta alla language enum
        Language[] languageArr = Language.values();
        //Sätta alla language namn i dropdown menu
        for(Language languageItem: languageArr) {
            language.getItems().add(languageItem);
        }

        //Disable login knappen om man inte skriver title eller ISBN
        regiBtn.disableProperty().bind(titleT.textProperty().isEmpty().or(isbnT.textProperty().isEmpty()));

    }

    public void goToLogOut() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToEmployeeTop() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
    }

    public void goToHistory() {
    }

    public void goToBookManage() {
    }

    public void goToUserManage() {
    }

    public void goToRegisterBooks() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToSearch() {
    }

    public void goToRegisterUser() {
    }

    public void actionRegister() {
        LocalDate releaseDay = releaseDate.getValue();
        try{

            if(category.getValue() != null )
            BookUtil.registerBook(
                    titleT.getText(),
                    isbnT.getText(),
                    authorT.getText(),
                    editionT.getText(),
                    numberOfPagesT.getText(),
                    descriptionT.getText(),
                    publisherT.getText(),
                    category.getValue() != null ? category.getValue().toString() : "",
                    language.getValue() != null? language.getValue().toString() : "",
                    releaseDay);

            SuccessModal.message = "You've successfully created book data";
            SuccessModal.displaySuccessDisplay(getClass());

            titleT.setText("");
            isbnT.setText("");
            authorT.setText("");
            editionT.setText("");
            numberOfPagesT.setText("");
            descriptionT.setText("");
            publisherT.setText("");
            category.getSelectionModel().clearSelection();
            language.getSelectionModel().clearSelection();
            releaseDate.setValue(null);


        }catch (Exception e) {
            e.printStackTrace();
            message.setText("Det gick något fel. Försök igen");
        }

    }
}
