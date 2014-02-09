package by.bsu.spothot.mediaservice.vkapi.parser;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.bean.Song;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dmitry on 1/25/14.
 */
@Component
public class PostExtractor
{
    private int depth = 0;
    private final int POST_DEPTH = 2;

    public List<Post> extractPosts(String content) throws IOException
    {
        List<Post> posts = new ArrayList<Post>();

        JsonParser parser = new JsonFactory().createJsonParser(content);

        depth = -1;

        while (depth != 0)
        {
            parser.nextToken();
            checkDepth(parser);
            if (parser.getCurrentToken() == JsonToken.START_OBJECT && depth == POST_DEPTH)
            {
                Post post = new Post();
                List<Song> songs = new ArrayList<Song>();
                while (depth >= POST_DEPTH)
                {
                    parser.nextToken();
                    checkDepth(parser);
                    while (depth == POST_DEPTH)
                    {
                        if ("id".equals(parser.getCurrentName()))
                        {
                            parser.nextToken();
                            post.setId(Integer.valueOf(parser.getText()));
                        }
                        else if ("text".equals(parser.getCurrentName()))
                        {
                            parser.nextToken();
                            post.setText(parser.getText());
                        }
                        else if ("date".equals(parser.getCurrentName()))
                        {
                            parser.nextToken();
                            post.setDate(new Date(parser.getLongValue() * 1000));
                        }
                        else if ("likes".equals(parser.getCurrentName()))
                        {
                            parser.nextToken();
                            post.setLikesCount(extractLikesCount(parser));
                        }
                        parser.nextToken();
                        checkDepth(parser);
                    }
                    if ("audio".equals(parser.getCurrentName()))
                    {
                        songs.add(SongExtractor.extractSong(parser));
                    }
                }
                post.setSongs(songs);
                posts.add(post);
            }
        }
        return posts;
    }

    private void checkDepth(JsonParser parser) throws IOException
    {
        if (parser.getCurrentToken() == JsonToken.START_OBJECT)
        {
            if (depth < 0)
            {
                depth = 0;
            }
            depth++;
        }
        else if (parser.getCurrentToken() == JsonToken.END_OBJECT)
        {
            depth--;
        }
    }

    private int extractLikesCount(JsonParser parser) throws IOException
    {
        int likes = 0;
        while (parser.nextToken() != JsonToken.END_OBJECT)
        {
            if ("count".equals(parser.getCurrentName()))
            {
                parser.nextToken();
                likes = parser.getIntValue();
            }
        }
        return likes;
    }

}
