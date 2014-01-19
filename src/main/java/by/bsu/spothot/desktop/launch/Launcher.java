package by.bsu.spothot.desktop.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        Scene scene = new Scene(rootNode);

        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();

        //Code to delete
        FXMLLoader barLoader = new FXMLLoader();
        GridPane progressBarParent = (GridPane) barLoader.load(getClass().getResourceAsStream("/fxml/progress-bar.fxml"));
        VBox vBox = (VBox) progressBarParent.getChildren().get(0);
        final ProgressBar progressBar = (ProgressBar) vBox.getChildren().get(0);

        Scene bar =  new Scene(progressBarParent);

        Stage barStage = new Stage();
        barStage.setScene(bar);
        barStage.show();

        Thread thread = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <= 100; ++i)
                {
                    try {
                        this.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setProgress(new Double(i) / 100.0);
                }
            }
        };

        thread.start();

    }
}
