package Client.Controller.Employee;

import Client.Controller.ControllerUtil;
import Model.Category;
import Model.Language;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-04
 * Time: 13:34
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class RegisterBook implements Initializable {
    public AnchorPane registerBook;
    public ComboBox category;
    public ComboBox language;
    public DatePicker releaseDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*-------------Category-------------------*/
        //Hämta alla category enum
        Category[] categoryArr = Category.values();
        //Sätta alla category namn i dropdown menu
        for(Category categoryItem: categoryArr) {
            category.getItems().add(categoryItem);
        }

        /*-------------Languages-------------------*/
        //Hämta alla language enum
        Language[] languageArr = Language.values();
        //Sätta alla language namn i dropdown menu
        for(Language languageItem: languageArr) {
            language.getItems().add(languageItem);
        }

    }

    public void goToLogOut() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToEmployeeTop() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
    }

    public void goToHistory() {
    }

    public void goToBookManage() {
    }

    public void goToUserManage() {
    }

    public void goToRegisterBooks() {
        registerBook.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToSearch() {
    }

    public void goToRegisterUser() {
    }

    public void actionRegister() {
        System.out.println(category.getValue());
        System.out.println(language.getValue());
        LocalDate releaseDay = releaseDate.getValue();
        System.out.println(releaseDay);
    }
}
