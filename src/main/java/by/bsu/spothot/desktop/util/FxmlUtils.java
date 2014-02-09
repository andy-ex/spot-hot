package by.bsu.spothot.desktop.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 2/4/14.
 */
public class FxmlUtils
{
    private static final Logger log = LoggerFactory.getLogger(FxmlUtils.class);

    public static Scene loadScene(String fxmlFile) throws IOException
    {
        log.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();

        loader.setResources(ResourceBundle.getBundle("conf.conf"));
        Parent rootNode = (Parent) loader.load(FxmlUtils.class.getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        return new Scene(rootNode);
    }

}
