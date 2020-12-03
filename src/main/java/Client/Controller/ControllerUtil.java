package Client.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class ControllerUtil {

    public static AnchorPane loadFMXLFiles(Class<?> tClass, String FMXLFileName) {
        try {
            return FXMLLoader.load(tClass.getClassLoader().getResource("view/"
                    + FMXLFileName + ".fxml"));
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
}
