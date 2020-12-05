package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
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
