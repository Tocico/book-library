package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-29
 * Time: 17:21
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class Visitor {

    public AnchorPane loggedInVisitor;
    Class<?> currentClass = getClass();

    public void goToStaffTop(ActionEvent actionEvent) {
    }

    public void goToHistory(ActionEvent actionEvent) {
    }

    public void goToSearch(ActionEvent actionEvent) {
    }

    public void goToLogIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        loggedInVisitor.getChildren().setAll(pane);
    }
}
