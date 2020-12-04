package Client.Controller.Employee;

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


public class EmployeeHome {
    public AnchorPane loggedInEmployee;
    public Button employeeTop;
    public Button history;


    public void goToEmployeeTop() {
        loggedInEmployee.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
    }

    public void goToHistory() {
    }

    public void goToBookManage() {
    }

    public void goToUserManage() {
    }

    public void goToRegisterBooks() {
        loggedInEmployee.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToLogOut() {
        loggedInEmployee.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToSearch() {
    }

    public void goToRegisterUser(ActionEvent actionEvent) {
    }
}
