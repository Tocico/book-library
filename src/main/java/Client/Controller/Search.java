package Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public TextField searchT;
    public AnchorPane searchPane;
    Class<?> currentClass = getClass();

    public void goToLogIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        searchPane.getChildren().setAll(pane);
    }

    public void goToSearch(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "search");
        searchPane.getChildren().setAll(pane);
    }

    public void goToTop(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "home");
        searchPane.getChildren().setAll(pane);
    }

    public void searchAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchT.setPromptText("Skriv sök ord här ....");
    }
}
