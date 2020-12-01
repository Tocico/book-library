package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import Client.Main;
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

    public void goToLogOut(ActionEvent actionEvent) {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToVisitorTop(ActionEvent actionEvent) {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }

    public void goToHistory(ActionEvent actionEvent) {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToVisitorSearch(ActionEvent actionEvent) {
        visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }
}
