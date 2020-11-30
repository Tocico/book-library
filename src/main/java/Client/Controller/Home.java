package Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Home {
    public AnchorPane homePane;
    public Button search;
    public Button top;
    public Button log;

    Class<?> currentClass = getClass();


    public void goToTop(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "home");
        homePane.getChildren().setAll(pane);
    }

    public void goToSearch(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "search");
        homePane.getChildren().setAll(pane);
    }

    public void goToLogIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        homePane.getChildren().setAll(pane);
    }
}
