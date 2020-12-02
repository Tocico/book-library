package Client.Controller;

import Client.BookUtil;
import Model.Book;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
        searchView.setVisible(false);
        //Sätt disable på sök knappen om man inte skriver något
        searchBtn.disableProperty().bind(searchT.textProperty().isEmpty());

    }

    public void goToLogIn() {
        searchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToSearch() {
        searchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "search"));
    }

    public void goToTop() {
        searchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "home"));
    }

    public void searchAction(){
        String searchWord = searchT.getText();
        BookUtil.printOutSearchResult(searchWord, searchView, title, author, language, category, message);
    }

}
