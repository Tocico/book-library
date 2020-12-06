package Client.Controller.Employee;

import Client.BookUtil;
import Client.Controller.ControllerUtil;
import Client.Controller.SuccessModal;
import Client.UserUtil;
import Model.History;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-06
 * Time: 15:39
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class LendOutBook implements Initializable {

    public AnchorPane lendOutBookPane;
    public TextField ssn;
    public TextField isbn;
    public Button regiBtn;
    public Text message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Disable login knappen om man inte skriver personnummer eller ISBN
        regiBtn.disableProperty().bind(ssn.textProperty().isEmpty().or(isbn.textProperty().isEmpty()));
    }

    public void goToEmployeeTop() {
        lendOutBookPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/employeeHome"));
    }

    public void goToLogOut() {
        lendOutBookPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
    }

    public void goToBookManage() {
    }

    public void goToReturned() {
    }

    public void goToLendOut() {
        lendOutBookPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/lendOutBook"));
    }

    public void goToUserManage() {
    }

    public void goToRegisterBooks() {
        lendOutBookPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerBook"));
    }

    public void goToRegisterUser() {
        lendOutBookPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "employee/registerUser"));
    }

    public void goToSearch() {
    }

    public void lendOutAction() {
        try {

            if (BookUtil.getBook(isbn.getText()) == null && UserUtil.getUser(ssn.getText()) == null)
                message.setText("Felaktig inmatning. Försök mata in igen.");
            else if (UserUtil.getUser(ssn.getText()) == null)
                message.setText("Vi hittar inte personnummer. Försök mata in igen.");
            else if (BookUtil.getBook(isbn.getText()) == null)
                message.setText("Vi hittar inte den bok. Försök mata in igen.");
            else {
               History history = BookUtil.registerLendOutBook(ssn.getText(), isbn.getText());

               isbn.setText("");
               ssn.setText("");

                SuccessModal.message = "Name: " + history.getUser().getFirstName() + " " + history.getUser().getLastName()
                                        + "\nTitle: " + history.getBook().getTitle() +
                                        "\nReturn Date: " + history.getReturnDate().toString();
                SuccessModal.displaySuccessDisplay(getClass());
            }

        } catch (Exception e) {
            e.printStackTrace();
            message.setText("Det gick något fel. Försök igen");
        }
    }
}