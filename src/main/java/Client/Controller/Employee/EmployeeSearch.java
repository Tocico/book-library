package Client.Controller.Employee;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-05
 * Time: 23:58
 * Project: Bibliotek
 * Copyright: MIT
 */
public class EmployeeSearch implements Initializable {

    public AnchorPane employeeSearchPane;
    public TextField searchT;
    public Button searchBtn;
    public Text message;
    public TableView searchView;
    public TableColumn<Book, String> title;
    public TableColumn<Book, String> author;
    public TableColumn<Book, String> language;
    public TableColumn<Book, String> category;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
        searchView.setVisible(false);
        //Sätt disable på sök knappen om man inte skriver något
        searchBtn.disableProperty().bind(searchT.textProperty().isEmpty());
    }

    public void goToLogOut() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToEmployeeTop() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
    }

    public void goToBookManage() {
        searchView.getItems().clear();

    }

    public void goToUserManage() {
        searchView.getItems().clear();

    }

    public void goToRegisterBooks() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToRegisterUser() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerUser"));
    }

    public void goToSearch() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeSearch"));
    }

    public void goToLendOut() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/lendOutBook"));
    }

    public void goToReturned() {
        searchView.getItems().clear();
        employeeSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/returnedBook"));
    }

    public void searchAction(){
        String searchWord = searchT.getText();
        BookUtil.printOutSearchResult(searchWord, searchView, title, author, language, category, message, getClass());
    }

    public void onChangeText() {
        searchView.getItems().clear();
    }
}
