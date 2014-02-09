package by.bsu.spothot.desktop.ui;

import by.bsu.spothot.desktop.util.FxmlUtils;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Dmitry on 2/4/14.
 */
public class CustomProgressBar
{
    private static final Logger log = LoggerFactory.getLogger(CustomProgressBar.class);

    private static final String FXML_PATH = "/fxml/progress-bar.fxml";

    private Stage stage;
    private ProgressBar progressBar;
    private Label label;

    public CustomProgressBar()
    {
        try
        {
            Scene scene = FxmlUtils.loadScene(FXML_PATH);

            this.progressBar = extractProgressBarFromScene(scene);
            this.label=  extractLabelFromScene(scene);
            this.stage = new Stage();
            this.stage.setScene(scene);
        }
        catch (IOException e)
        {
            log.error("Could not load progress bar window", e);
        }
    }


    public void show()
    {
        if (progressBar != null && stage != null)
        {
            stage.show();
        }
    }

    public void close()
    {
        if (stage != null)
        {
            stage.close();
        }
    }

    public void setProgress(double progress)
    {
        if (progressBar != null)
        {
            progressBar.setProgress(progress);
        }
    }

    public void setText(String text)
    {
        if (label != null)
        {
            label.setText(text);
        }
    }

    private ProgressBar extractProgressBarFromScene(Scene scene)
    {
        GridPane gridPane = (GridPane) scene.getRoot();
        VBox vBox = (VBox) gridPane.getChildren().get(0);
        return (ProgressBar) vBox.getChildren().get(1);
    }

    private Label extractLabelFromScene(Scene scene)
    {
        GridPane gridPane = (GridPane) scene.getRoot();
        VBox vBox = (VBox) gridPane.getChildren().get(0);
        return (Label) vBox.getChildren().get(0);
    }

}
