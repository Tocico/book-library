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

    public void goToHistory(ActionEvent actionEvent) {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHistory"));
    }

    public void goToSearch(ActionEvent actionEvent) {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorSearch"));
    }

    public void searchAction(ActionEvent actionEvent) {
    }

    public void goToLogOut(ActionEvent actionEvent) {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToVisitorTop(ActionEvent actionEvent) {
        visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
    }
}
