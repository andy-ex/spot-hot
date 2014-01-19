package by.bsu.spothot.desktop.controller;

import by.bsu.spothot.mediaservice.vkapi.main.VKApiHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private TextField destination;
    @FXML
    private TextField folder;

    public void download()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/app-context.xml");

        try
        {
            String destFolder = destination.getText() + File.separator + folder.getText();
            context.getBean(VKApiHelper.class).saveSongs("indie_music", 1, destFolder, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String defaultValue = resourceBundle.getString("destination.default");
        destination.setText(defaultValue);
    }
}
