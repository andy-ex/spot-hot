package by.bsu.spothot.desktop.controller;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.bean.Song;
import by.bsu.spothot.desktop.ui.Dialogs;
import by.bsu.spothot.desktop.util.ComboBoxUtils;
import by.bsu.spothot.desktop.util.SongSaver;
import by.bsu.spothot.mediaservice.SharedMediaService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private TextField destinationMostLiked;
    @FXML
    private ComboBox<String> countBox;
    @FXML
    private ComboBox<String> genreBox;

    @FXML
    private TextField destinationPost;
    @FXML
    private TextField postId;

    private ApplicationContext context;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String defaultValue = resourceBundle.getString("destination.default");
        destinationMostLiked.setText(defaultValue);
        destinationPost.setText(defaultValue);

        context = new ClassPathXmlApplicationContext("conf/app-context.xml");
    }

    public void downloadMostLiked()
    {
        SharedMediaService mediaService = context.getBean(SharedMediaService.class);

        final Stage stage = (Stage) destinationMostLiked.getScene().getWindow();

        try
        {
            int count = ComboBoxUtils.getComboBoxIntegerValue(countBox);
            String genre = ComboBoxUtils.getComboBoxStringValue(genreBox);

            Post post = mediaService.getMostLikedPost(genre, count);
            List<Song> songs = post.getSongs();

            Dialogs.DialogResponse response = Dialogs.showConfirmDialog(stage, songsToString(songs),
                    post.getText());

            if (Dialogs.DialogResponse.YES == response)
            {
                String destinationFolder = Dialogs.showInputDialog(stage, "Please, enter destination folder");
                SongSaver.save(destinationMostLiked.getText() + File.separator + destinationFolder, songs);
            }
        }
        catch (Exception e)
        {
            Dialogs.showErrorDialog(stage, "Contact your administrator", "Error has occur",
                    "Error", e);
        }
    }

    public void downloadPost()
    {
        SharedMediaService mediaService = context.getBean(SharedMediaService.class);

        final Stage stage = (Stage) destinationMostLiked.getScene().getWindow();

        try
        {
            Post post = mediaService.getPost(postId.getText());
            List<Song> songs = post.getSongs();

            Dialogs.DialogResponse response = Dialogs.showConfirmDialog(stage, songsToString(songs),
                    post.getText().length() > 300 ? post.getText().substring(0, 300) : post.getText());

            if (Dialogs.DialogResponse.YES == response)
            {
                String destinationFolder = Dialogs.showInputDialog(stage, "Please, enter destination folder");
                SongSaver.save(destinationPost.getText() + File.separator + destinationFolder, songs);
            }
        }
        catch (Exception e)
        {
            Dialogs.showErrorDialog(stage, "Contact your administrator", "Error has occur",
                    "Error", e);
        }
    }

    private String songsToString(List<Song> songs)
    {
        StringBuilder builder = new StringBuilder();
        for (Song song : songs)
        {
            builder.append(song.toString() + "\n");
        }
        return builder.toString();
    }

}
