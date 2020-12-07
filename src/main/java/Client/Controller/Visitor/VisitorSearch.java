package Client.Controller.Visitor;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.Book;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 16:42
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorSearch implements Initializable {
    public AnchorPane visitorSearchPane;
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

    public void goToHistory() {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToSearch() {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }

    public void goToLogOut() {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToVisitorTop() {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }

    public void searchAction() throws IOException, ClassNotFoundException {
        String searchWord = searchT.getText();
        BookUtil.printOutSearchResult(searchWord, searchView, title, author, language, category, message, getClass());
    }

}
