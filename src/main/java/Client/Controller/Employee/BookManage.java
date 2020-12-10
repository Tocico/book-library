package Client.Controller.Employee;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.Book;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-07
 * Time: 14:42
 * Project: Bibliotek
 * Copyright: MIT
 */
public class BookManage extends ControllerUtil implements Initializable {
    public Button LogOut;
    public Button employeeTop;
    public Button lendOut;
    public Button returned;
    public Button bookManage;
    public Button userManage;
    public Button registerBooks;
    public Button registerUser;
    public Button search;
    public TextField searchT;
    public Button searchBtn;
    public Text message;
    public TableView searchView;
    public TableColumn<Book, String> id;
    public TableColumn<Book, String> isbn;
    public TableColumn<Book, String> title;
    public TableColumn<Book, String> author;
    ControllerUtil c = new ControllerUtil();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
        //Sätt disable på sök knappen om man inte skriver något
        searchBtn.disableProperty().bind(searchT.textProperty().isEmpty());
        try {
            String searchWord = searchT.getText();
            BookUtil.printOutBookManage(searchWord, searchView,  id,  isbn, title, author, message, getClass());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchAction() throws IOException, ClassNotFoundException {
        String searchWord = searchT.getText();
        BookUtil.printOutBookManage(searchWord, searchView,  id,  isbn, title, author, message, getClass());
    }

}
