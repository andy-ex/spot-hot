package by.bsu.spothot.mediaservice.vkapi.main;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.bean.Song;
import by.bsu.spothot.mediaservice.vkapi.main.operation.GetMostLikedPostOperation;
import by.bsu.spothot.mediaservice.vkapi.main.operation.GetPostByIdOperation;
import by.bsu.spothot.mediaservice.vkapi.parser.PostExtractor;
import by.bsu.spothot.mediaservice.vkapi.parser.SongExtractor;
import by.bsu.spothot.mediaservice.vkapi.jsonprocess.JsonContentRetriever;
import by.bsu.spothot.util.saver.UrlContentSaver;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dmitry on 1/2/14.
 */
@Component
public class VkMediaService
{
    @Autowired
    GetMostLikedPostOperation getMostLikedPostOperation;

    @Autowired
    GetPostByIdOperation getPostByIdOperation;

    public Post getMostLikedPost(String genre, int postCount)
    {
        return getMostLikedPostOperation.getMostLikedPost(getAppropriateDomain(genre), postCount);
    }

    public Post getPostById(String id)
    {
        return getPostByIdOperation.getPostById(id);
    }

    private String getAppropriateDomain(String genre)
    {
        return "indie_music";
    }




}
