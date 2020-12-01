package Client.Controller;

import Client.Controller.Staff.StaffHome;
import Client.Controller.Visitor.VisitorHome;
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
import java.util.ArrayList;
import java.util.ResourceBundle;


public class LogIn implements Initializable {
    public AnchorPane loginPane;
    public TextField socialId;
    public PasswordField psw;
    public Button logInBtn;
    public Text message;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Disable login knappen om man inte skriver personnummer eller löseord
        logInBtn.disableProperty().bind(socialId.textProperty().isEmpty().or(psw.textProperty().isEmpty()));
    }


    public void logIn(ActionEvent actionEvent) {
        /*------------------------TEST----------------------------------*/
        ArrayList<UserTest> userList = new ArrayList<>();
        UserTest u1 = new UserTest("Toshiko", "8811072886", "1111", false);
        UserTest u2 = new UserTest("Miwa", "0000000000", "2222", false);
        UserTest u3 = new UserTest("Maxim", "1111111111", "3333", false);
        UserTest u4 = new UserTest("Yohannes", "2222222222", "4444", false);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);

        /*----------------------------------------------------------------*/

        UserTest tempUser = userList.stream()
                .filter(user -> user.getSsn().equalsIgnoreCase(socialId.getText())
                        && user.getPasswd().equals(psw.getText()))
                .findFirst()
                .orElse(null);

        if (tempUser != null) {
            if (tempUser.isStaff()) {
                StaffHome.currentLoggedInUser = tempUser;
                loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "staff/staffHome"));
            } else {
                VisitorHome.currentLoggedInUser = tempUser;
                loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
            }

        } else {
            message.setText("Vi hittar inte dig i systemet.  Försök logga in igen.");
            socialId.setText("");
            psw.setText("");
        }


    }

    public void goToTop(ActionEvent actionEvent) {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "home"));
    }

    public void goToSearch(ActionEvent actionEvent) {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "search"));
    }

    public void goToLogIn(ActionEvent actionEvent) {
        loginPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    //Ta bort felmeddelande så fort användare skriver något
    public void onChangeText(KeyEvent inputMethodEvent) {
        message.setText("");
    }
}
