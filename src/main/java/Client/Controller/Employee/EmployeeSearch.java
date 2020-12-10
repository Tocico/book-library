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
public class EmployeeSearch extends ControllerUtil implements Initializable {

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

    public void searchAction(){
        String searchWord = searchT.getText();
        BookUtil.printOutSearchResult(searchWord, searchView, title, author, language, category, message, getClass());
    }

}
