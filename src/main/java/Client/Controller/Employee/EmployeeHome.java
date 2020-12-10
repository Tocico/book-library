package Client.Controller.Employee;

import Client.Controller.ControllerUtil;
import Client.Controller.LogIn;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-11-29
 * Time: 17:21
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class EmployeeHome extends ControllerUtil implements Initializable {
    public AnchorPane loggedInEmployee;
    public Button employeeTop;
    public Text userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(LogIn.currentLoggedInUser.getFirstName());
    }



}
