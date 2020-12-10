package Client.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerUtil {

    public static AnchorPane loadFMXLFiles(Class<?> tClass, String FMXLFileName) {
        try {
            return FXMLLoader.load(tClass.getClassLoader().getResource("view/" + FMXLFileName + ".fxml"));
        } catch (IOException e) {
            System.out.println("Couldn't load FMXLfile");
            e.printStackTrace();
        }
        return null;
    }

    public static Scene loadModalScene(Class<?> currentClass, String FXMLFileName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(currentClass.getResource(FXMLFileName));
            return new Scene(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load FMXLfile");
            e.printStackTrace();
        }
        return null;
    }

    public void loadNewScreen(String fxml, Node node) throws IOException {
        try {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/" + fxml + ".fxml"));
        Stage primaryStage = (Stage) node.getScene().getWindow();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Nackademin Bibliotek");
        primaryStage.setResizable(false);
        primaryStage.show();
        } catch (IOException e) {
            System.out.println("Couldn't load FMXLfile");
            e.printStackTrace();
        }
    }

    public void goToTop(ActionEvent e) throws IOException {
        loadNewScreen("home", (Node) e.getSource());
    }

    public void goToSearch(ActionEvent e) throws IOException {
        loadNewScreen("search", (Node) e.getSource());
    }

    public void goToLogIn(ActionEvent e) throws IOException {
        loadNewScreen("logIn", (Node) e.getSource());
    }

    public void goToLogOut(ActionEvent e) throws IOException {
        //visitorHistoryPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "logIn"));
        loadNewScreen("logIn", (Node) e.getSource());
    }

    public void goToVisitorTop(ActionEvent e) throws IOException {
        //visitorSearchPane.getChildren().setAll(ControllerUtil.loadFMXLFiles(getClass(), "visitor/visitorHome"));
        loadNewScreen("visitor/visitorHome", (Node) e.getSource());
    }

    public void goToVisitorSearch(ActionEvent e) throws IOException {
        loadNewScreen("visitor/visitorSearch", (Node) e.getSource());
    }

    public void goToVisitorHistory(ActionEvent e) throws IOException {
        loadNewScreen("visitor/visitorHistory", (Node) e.getSource());
    }
}
