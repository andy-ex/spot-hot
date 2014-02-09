package by.bsu.spothot.mediaservice.vkapi.main.operation;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.bean.Song;
import by.bsu.spothot.mediaservice.vkapi.jsonprocess.JsonContentRetriever;
import by.bsu.spothot.mediaservice.vkapi.parser.PostExtractor;
import by.bsu.spothot.mediaservice.vkapi.parser.SongExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dmitry on 2/2/14.
 */
@Component
public class GetMostLikedPostOperation
{
    @Autowired
    JsonContentRetriever contentRetriever;

    @Autowired
    SongExtractor songExtractor;

    @Autowired
    PostExtractor postExtractor;

    public Post getMostLikedPost(String domain, int postCount)
    {
        try
        {
            String content = contentRetriever.retrievePosts(domain, postCount);
            List<Post> posts = postExtractor.extractPosts(content);
            Collections.sort(posts, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    return o2.getLikesCount() - o1.getLikesCount();
                }
            });
            List<Song> songs = getMostLikedSongs(posts);
            System.out.println(posts.get(0));
            return posts.get(0);
        }
        catch (Exception e)
        {
            System.out.println("Could not obtain songs");
            e.printStackTrace();
        }
        return new Post();
    }

    private List<Song> getMostLikedSongs(List<Post> posts) {
        List<Song> result = new ArrayList<Song>();
        for (Post post : posts)
        {
            result.addAll(post.getSongs());
        }
        return result;
    }
}
