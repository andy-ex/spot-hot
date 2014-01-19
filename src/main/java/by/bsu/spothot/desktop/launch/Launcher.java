package by.bsu.spothot.desktop.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ResourceBundle;

public class Launcher extends Application
{

    private static final Logger log = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) throws Exception
    {
        new ClassPathXmlApplicationContext("conf/app-context.xml");
        launch(args);
    }

    public void start(Stage stage) throws Exception
    {

        log.info("Starting Hello JavaFX and Maven demonstration application");

        String fxmlFile = "/fxml/sample.fxml";
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();

        loader.setResources(ResourceBundle.getBundle("conf.conf"));
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 400, 200);

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }
}
