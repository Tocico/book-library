package Client.Controller.Staff;

import Client.Controller.ControllerUtil;
import Model.User;
import Model.UserTest;
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


public class StaffHome {
    public AnchorPane loggedInStaff;
    public Button staffeTop;
    public Button history;
    public static UserTest currentLoggedInUser;


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

    public void goToLogOut(ActionEvent actionEvent) {
        loggedInStaff.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToSearch(ActionEvent actionEvent) {
    }
}
