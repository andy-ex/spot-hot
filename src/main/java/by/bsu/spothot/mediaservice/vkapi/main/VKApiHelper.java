package by.bsu.spothot.mediaservice.vkapi.main;

import by.bsu.spothot.bean.Song;
import by.bsu.spothot.mediaservice.vkapi.parser.SongExtractor;
import by.bsu.spothot.mediaservice.vkapi.jsonprocess.JsonContentRetriever;
import by.bsu.spothot.util.saver.UrlContentSaver;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Dmitry on 1/2/14.
 */

public class VKApiHelper
{
    @Autowired
    JsonContentRetriever contentRetriever;

    @Autowired
    SongExtractor songExtractor;

    ProgressBar progressBar = new ProgressBar();
    Stage stage;

    public void saveSongs(String domain, int postCount, String destination, String fileName) throws Exception
    {
        String content = contentRetriever.retrievePosts(domain, postCount);
        List<Song> songs = songExtractor.extractSongs(content);

        showProgressBar();
        int songsProceed = 0;
        for (Song song : songs)
        {
            UrlContentSaver.save(song.getUrl(), destination, song.getArtist() + " - " + song.getTitle() + ".mp3");
            songsProceed++;
            setProgress(songsProceed / songs.size());
        }

        closeProgressBar();
    }

    public void showProgressBar()
    {
        stage = new Stage();
        HBox box = new HBox();
        progressBar.setProgress(0);
        progressBar.setVisible(true);
        box.getChildren().add(progressBar);

        Scene scene = new Scene(box, 200, 100);

        stage.setScene(scene);
        stage.show();
    }

    public void setProgress(double progress)
    {
        progressBar.setProgress(progress);
    }

    public void closeProgressBar()
    {
        stage.close();
    }

}
