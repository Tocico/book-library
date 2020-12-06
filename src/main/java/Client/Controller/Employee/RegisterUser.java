package Client.Controller.Employee;

import Client.Controller.ControllerUtil;
import Client.Controller.SuccessModal;
import Client.UserUtil;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Miwa Guhrés
 * Date: 2020-12-05
 * Time: 10:18
 * Project: Bibliotek
 * Copyright: MIT
 */
public class RegisterUser implements Initializable {
    public AnchorPane registerUserPane;
    public ToggleGroup userCat;
    public TextField firstNameT;
    public TextField lastNameT;
    public TextField ssnT;
    public TextField passwdT;
    public TextField telT;
    public TextField addressT;
    public TextField emailT;
    public Text message;
    public Button regiBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Disable login knappen om man inte skriver namn, personnummer eller löseord
        regiBtn.disableProperty().bind(firstNameT.textProperty().isEmpty()
                 .or(lastNameT.textProperty().isEmpty())
                .or(ssnT.textProperty().isEmpty())
                .or(passwdT.textProperty().isEmpty()));
    }

    public void goToLogOut() {
        registerUserPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));

    }

    public void goToEmployeeTop() {
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
        RadioButton userCategoryChoice = (RadioButton) userCat.getSelectedToggle();
        System.out.println(userCategoryChoice.getText());
        System.out.println(firstNameT.getText());

        try {
            //TODO hämta inmatning värde och kontrollera dem. t.ex Personnummer(ÅÅMMDDXXXX), email osv

            if (firstNameT.getText() != null &&
                    lastNameT.getText() != null &&
                    ssnT.getText().matches("[0-9]{10}") && // number from 0 to 9, length 10
                    passwdT.getText() != null&&
                    telT.getText()!=null&&
                    addressT.getText()!=null&&
                    emailT.getText()!=null&&
                    userCategoryChoice.getText()!=null
            )


                UserUtil.registerUser(
                        firstNameT.getText(),
                        lastNameT.getText(),
                        ssnT.getText(),
                        passwdT.getText(),
                        telT.getText(),
                        addressT.getText(),
                        emailT.getText()),
                        userCategoryChoice.getText()
            );

                SuccessModal.message = "You've successfully created user data";
                SuccessModal.displaySuccessDisplay(getClass());

                firstNameT.setText("");
                lastNameT.setText("");
                ssnT.setText("");
                passwdT.setText("");
                telT.setText("");
                addressT.setText("");
                emailT.setText("");

            } catch(Exception e){
                e.printStackTrace();
                message.setText("Det gick något fel. Försök igen");
            }

    }

    public void goTolendOut() {
        registerUserPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/lendOutBook"));
    }

    public void goToreturned(ActionEvent actionEvent) {
    }
}
