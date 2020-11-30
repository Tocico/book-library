package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 16:42
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorSearch {
    public AnchorPane visitorSearchPane;
    Class<?> currentClass = getClass();

    public void goToVisitorTop(MouseEvent mouseEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/loggedInVisitor");
        visitorSearchPane.getChildren().setAll(pane);
    }

    public void goToHistory(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/visitorHistory");
        visitorSearchPane.getChildren().setAll(pane);
    }

    public void goToSearch(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/visitorSearch");
        visitorSearchPane.getChildren().setAll(pane);
    }

    public void searchAction(ActionEvent actionEvent) {
    }

    public void goToLogOut(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        visitorSearchPane.getChildren().setAll(pane);
    }

}
