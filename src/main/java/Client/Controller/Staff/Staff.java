package Client.Controller.Staff;

import Client.Controller.ControllerUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-29
 * Time: 17:21
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class Staff {
    public AnchorPane loggedInStaff;
    public Button staffeTop;
    public Button history;
    Class<?> currentClass = getClass();


    public void goToStaffTop(ActionEvent actionEvent) {
    }

    public void goToHistory(ActionEvent actionEvent) {
    }

    public void goToBookManage(ActionEvent actionEvent) {
    }

    public void goTouserManage(ActionEvent actionEvent) {
    }

    public void goToRegisterBooks(ActionEvent actionEvent) {
    }



    public void goToLogIn(ActionEvent actionEvent) {
        AnchorPane pane = ControllerUtil.loadFMXLFiles(currentClass, "logIn");
        loggedInStaff.getChildren().setAll(pane);
    }

    public void goToSearch(ActionEvent actionEvent) {
    }
}
