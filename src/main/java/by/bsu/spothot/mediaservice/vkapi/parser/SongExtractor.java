package by.bsu.spothot.mediaservice.vkapi.parser;

import by.bsu.spothot.bean.Song;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 1/2/14.
 */
public class SongExtractor
{
    private static final Logger log = Logger.getLogger(SongExtractor.class);

    public List<Song> extractSongs(String content) throws IOException
    {
        List<Song> songs = new ArrayList<Song>();

        JsonParser parser = new JsonFactory().createJsonParser(content);

        log.info("Parsing vk response...");

        iterate(parser, songs);

        parser.close();

        log.info("Extracted songs: " + songs.size());

        return songs;
    }

    private void iterate(JsonParser parser, List<Song> songs) throws IOException
    {
        while (parser.nextToken() != JsonToken.END_OBJECT && parser.getCurrentToken() != null)
        {
            if (parser.getCurrentToken() == JsonToken.START_OBJECT)
            {
                parser.nextToken();
                iterate(parser, songs);
            }
            if ("audio".equals(parser.getCurrentName()))
            {
                songs.add(extractSong(parser));
            }
        }
    }

    private Song extractSong(JsonParser parser) throws IOException
    {
        Song song = new Song();

        while (parser.nextToken() != JsonToken.END_OBJECT)
        {
            String currentName = parser.getCurrentName();
            if ("artist".equals(currentName))
            {
                parser.nextToken();
                song.setArtist(parser.getText());
            }
            else if ("title".equals(currentName))
            {
                parser.nextToken();
                song.setTitle(parser.getText());
            }
            else if ("url".equals(currentName))
            {
                parser.nextToken();
                song.setUrl(parser.getText());
            }
            else if ("duration".equals(currentName))
            {
                parser.nextToken();
                song.setDuration(parser.getLongValue());
            }
        }
        return song;
    }

}
