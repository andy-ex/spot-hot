package by.bsu.spothot.desktop.launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.bsu.spothot.desktop.util.FxmlUtils;

public class Launcher extends Application
{
    private static final Logger log = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) throws Exception
    {
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {
        String fxmlFile = "/fxml/main-window.fxml";
        Scene scene = FxmlUtils.loadScene(fxmlFile);

        stage.setTitle("Spot it hot");
        stage.setScene(scene);
        stage.show();
    }
}
