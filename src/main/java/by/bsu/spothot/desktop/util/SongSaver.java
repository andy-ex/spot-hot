package by.bsu.spothot.desktop.util;

import by.bsu.spothot.bean.Song;
import by.bsu.spothot.desktop.ui.CustomProgressBar;
import by.bsu.spothot.util.saver.UrlContentSaver;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Dmitry on 2/4/14.
 */
public class SongSaver
{
    private static final Logger log = LoggerFactory.getLogger(SongSaver.class);

    public static void save(final String destination, final List<Song> songs)
    {
        final CustomProgressBar progressBar = new CustomProgressBar();

        progressBar.show();

        Thread thread = new Thread(){
            @Override
            public void run() {
                int savedSongs = 0;
                for (final Song song : songs)
                {
                    log.info("Saving song: " + song.toString());
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setText("Downloading " + song.toString());
                        }
                    });
                    UrlContentSaver.save(song.getUrl(), destination, song.toString());
                    progressBar.setProgress(new Double(++savedSongs) / new Double(songs.size()));
                }
            }
        };

        thread.start();
    }


}
