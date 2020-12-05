package Client.Controller;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class Home {
    public AnchorPane homePane;
    public Button search;
    public Button top;
    public Button log;


    public void goToTop() {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "home"));
    }

    public void goToSearch() {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "search"));
    }

    public void goToLogIn() {
        homePane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

}
