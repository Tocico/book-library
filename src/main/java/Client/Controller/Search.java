package Client.Controller;

import Client.BookUtil;
import Model.Book;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public TextField searchT;
    public AnchorPane searchPane;
    public Button searchBtn;
    public Text message;
    public TableView searchView;
    public TableColumn<Book, String> title;
    public TableColumn<Book, String> author;
    public TableColumn<Book, String> language;
    public TableColumn<Book, String> category;
    public Button top;
    public Button search;
    public Button LogIn;
    ControllerUtil c = new ControllerUtil();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
        searchView.setVisible(false);
        searchView.getItems().clear();
        //Sätt disable på sök knappen om man inte skriver något
        searchBtn.disableProperty().bind(searchT.textProperty().isEmpty());
    }

    public void goToLogIn() throws IOException {
        searchView.getItems().clear();
        c.loadNewScreen("logIn", LogIn);
    }

    public void goToSearch() throws IOException {
        searchView.getItems().clear();
        c.loadNewScreen("search", search);
    }

    public void goToTop() throws IOException {
        searchView.getItems().clear();
        c.loadNewScreen("home", top);
    }

    public void searchAction() {
        String searchWord = searchT.getText();
        BookUtil.printOutSearchResult(searchWord, searchView, title, author, language, category, message, getClass());
    }

    public void onChangeText() {
        searchView.getItems().clear();
    }
}
