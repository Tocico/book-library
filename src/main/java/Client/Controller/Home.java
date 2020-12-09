package Client.Controller;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class Home {
    public AnchorPane homePane;
    public Button search;
    public Button top;
    public Button log;
    ControllerUtil c = new ControllerUtil();


    public void goToTop() throws IOException {
        c.loadNewScreen("home", top);
    }

    public void goToSearch() throws IOException {
        c.loadNewScreen("search", search);
    }

    public void goToLogIn() throws IOException {
        c.loadNewScreen("logIn", log);
    }

}
