package Client.Controller;

import Client.BookUtil;
import Model.BookTest;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public TextField searchT;
    public AnchorPane searchPane;
    public Button searchBtn;
    public Text message;
    public TableView searchView;
    public TableColumn<BookTest, String> title;
    public TableColumn<BookTest, String> author;
    public TableColumn<BookTest, String> language;
    public TableColumn<BookTest, String> category;
    ObservableList<BookTest> data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
        searchView.setVisible(false);
        data = FXCollections.observableArrayList();
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

    public void searchAction() {
        String searchWord = searchT.getText();
        searchView.getItems().clear();
        searchView.setVisible(false);
        List<BookTest> books = BookUtil.searchBook(searchWord);
        if (books.size() == 0) {
            message.setText("Din sökning gav inga träffar. Försök igen.");
        } else {
            message.setText("");
            searchView.setVisible(true);

            //Skriv ut sökresultat
            for (BookTest book : books) {
                title.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getTitle()));
                author.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAuthor()));
                language.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLanguage()));
                category.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
                data.add(book);
            }
            searchView.setItems(data);

        }

        searchView.getSelectionModel().selectedItemProperty().addListener((observable, oldVal, newVal) ->
        {
            System.out.println(newVal.toString());
        });

    }
}
