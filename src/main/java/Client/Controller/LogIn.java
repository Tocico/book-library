package Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class LogIn {
    public AnchorPane loginPane;
    public Button top;

    Class<?> currentClass = getClass();


    public void logIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/loggedInVisitor");
        loginPane.getChildren().setAll(pane);
    }

    public void goToTop(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "home");
        loginPane.getChildren().setAll(pane);
    }

    public void goToSearch(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "search");
        loginPane.getChildren().setAll(pane);
    }

    public void goToLogIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        loginPane.getChildren().setAll(pane);
    }
}
