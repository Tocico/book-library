package Client.Controller.Visitor;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.History;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 16:44
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorHistory implements Initializable {
    public AnchorPane visitorHistoryPane;
    public TableColumn<History, String> isbn;
    public TableColumn<History, String> title;
    public TableColumn<History, String> lendDate;
    public TableColumn<History, String> returnDate;
    public TableView historyView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        historyView.getItems().clear();
        try {
            BookUtil.printOutLendingHistory(historyView,  title,  isbn, returnDate, lendDate);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void goToLogOut() {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToVisitorTop() {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }

    public void goToHistory() {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToVisitorSearch() {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }
}
