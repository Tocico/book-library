package Client.Controller;

import Client.Controller.Employee.RegisterBook;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Created by Toshiko Kuno
 * Date: 2020-12-05
 * Time: 17:22
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */


public class SuccessModal implements Initializable {
    public Text successMsg;
    private static Stage stage;
    public static String message;

    public static void displaySuccessDisplay(Class<?> currentClass) {
        Scene scene = ControllerUtil.loadModalScene(currentClass, "/view/success.fxml");
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeModal() {
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        successMsg.setText(message);
    }
}
