package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import Client.Controller.LogIn;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-29
 * Time: 17:21
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorHome implements Initializable {
    public AnchorPane loggedInVisitor;
    public Text userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(LogIn.currentLoggedInUser.getName());
    }

    public void goToVisitorTop() {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }

    public void goToHistory() {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToSearch() {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }

    public void goToLogOut() {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }
}
