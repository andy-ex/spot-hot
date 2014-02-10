package by.bsu.spothot.mediaservice.vkapi.main.operation;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.mediaservice.vkapi.jsonprocess.JsonContentRetriever;
import by.bsu.spothot.mediaservice.vkapi.parser.PostExtractor;
import by.bsu.spothot.mediaservice.vkapi.parser.SongExtractor;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Dmitry on 2/2/14.
 */
@Component
public class GetPostByIdOperation
{
    @Autowired
    JsonContentRetriever contentRetriever;

    @Autowired
    SongExtractor songExtractor;

    @Autowired
    PostExtractor postExtractor;

    public Post getPostById(String postId)
    {
        try
        {
            String content = contentRetriever.retrievePostsByIds(postId);
            List<Post> posts = postExtractor.extractPosts(content);
            return posts.isEmpty() ? null : posts.get(0);
        }
        catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (HttpException e)
        {
            e.printStackTrace();
        }

        return new Post();
    }
}
