package Client.Controller;

import Model.User;
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


    public void goToTop(ActionEvent actionEvent) {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "home"));
    }

    public void goToSearch(ActionEvent actionEvent) {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "search"));
    }

    public void goToLogIn(ActionEvent actionEvent) {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }
}
