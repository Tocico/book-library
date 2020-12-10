package Client.Controller.Visitor;

import Client.Controller.ControllerUtil;
import Client.Controller.LogIn;
import javafx.fxml.Initializable;
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


public class VisitorHome extends ControllerUtil implements Initializable {
    public AnchorPane loggedInVisitor;
    public Text userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userName.setText(LogIn.currentLoggedInUser.getFirstName());
    }
}
