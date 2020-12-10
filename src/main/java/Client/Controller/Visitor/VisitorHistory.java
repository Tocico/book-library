package Client.Controller.Visitor;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Model.History;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class VisitorHistory extends ControllerUtil implements Initializable {
    public AnchorPane visitorHistoryPane;
    public TableColumn<History, String> isbn;
    public TableColumn<History, String> title;
    public TableColumn<History, String> lendDate;
    public TableColumn<History, String> returnDate;
    public TableView historyView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BookUtil.printOutLendingHistory(historyView,  title,  isbn, returnDate, lendDate);
    }
}
