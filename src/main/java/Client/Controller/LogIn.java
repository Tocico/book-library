package Client.Controller;

import Client.BookUtil;
import Client.Controller.Employee.EmployeeHome;
import Client.Controller.Visitor.VisitorHome;
import Client.UserUtil;
import Model.History;
import Model.UserTest;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class LogIn implements Initializable {
    public AnchorPane loginPane;
    public TextField socialId;
    public PasswordField psw;
    public Button logInBtn;
    public Text message;
    public static UserTest currentLoggedInUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Disable login knappen om man inte skriver personnummer eller löseord
        logInBtn.disableProperty().bind(socialId.textProperty().isEmpty().or(psw.textProperty().isEmpty()));
    }


    public void logIn() {
        //Hämta user list
        List<UserTest> userList = UserUtil.getUserList();

        UserTest tempUser = userList.stream()
                .filter(user -> user.getSsn().equalsIgnoreCase(socialId.getText())
                        && user.getPasswd().equals(psw.getText()))
                .findFirst()
                .orElse(null);

        if (tempUser != null) {
            if (tempUser.isStaff()) {
                loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
            } else {
                loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
            }
            currentLoggedInUser = tempUser;

        } else {
            message.setText("Vi hittar inte dig i systemet.  Försök logga in igen.");
            socialId.setText("");
            psw.setText("");
        }


    }

    public void goToTop() {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "home"));
    }

    public void goToSearch() {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "search"));
    }

    public void goToLogIn() {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    //Ta bort felmeddelande så fort användare skriver något
    public void onChangeText() {
        message.setText("");
    }
}
