package Client.Controller.Employee;

import Client.Controller.ControllerUtil;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-05
 * Time: 10:18
 * Project: Bibliotek
 * Copyright: MIT
 */
public class RegisterUser {
    public AnchorPane registerUserPane;
    public ToggleGroup userCat;

    public void goToLogOut() {
        registerUserPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));

    }

    public void goToEmployeeTop() {
    }

    public void goToHistory() {
    }

    public void goToBookManage() {
    }

    public void goToUserManage() {
    }

    public void goToRegisterBooks() {
        registerUserPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToRegisterUser() {
        registerUserPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerUser"));
    }

    public void goToSearch() {
    }

    public void actionRegister() {
        System.out.println(userCat.getSelectedToggle().getUserData().toString());

    }
}
