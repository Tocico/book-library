package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-30
 * Time: 16:44
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class VisitorHistory {
    public AnchorPane visitorHistoryPane;
    Class<?> currentClass = getClass();

    public void goToLogOut(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        visitorHistoryPane.getChildren().setAll(pane);
    }

    public void goToVisitorTop(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/loggedInVisitor");
        visitorHistoryPane.getChildren().setAll(pane);
    }

    public void goToHistory(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/visitorHistory");
        visitorHistoryPane.getChildren().setAll(pane);
    }

    public void goToVisitorSearch(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "visitor/visitorSearch");
        visitorHistoryPane.getChildren().setAll(pane);
    }
}
