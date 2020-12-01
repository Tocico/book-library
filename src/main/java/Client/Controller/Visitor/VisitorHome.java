package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import Model.User;
import Model.UserTest;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-29
 * Time: 17:21
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorHome {
    public AnchorPane loggedInVisitor;
    public static UserTest currentLoggedInUser;

    public void goToVisitorTop(ActionEvent actionEvent) {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }

    public void goToHistory(ActionEvent actionEvent) {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToSearch(ActionEvent actionEvent) {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }

    public void goToLogOut(ActionEvent actionEvent) {
        loggedInVisitor.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }
}
