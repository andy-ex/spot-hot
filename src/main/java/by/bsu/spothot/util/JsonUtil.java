package by.bsu.spothot.util;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import java.io.IOException;

/**
 * Created by Dmitry on 1/2/14.
 */
public class JsonUtil
{

    public static String getValueFor(String source, String name)
    {
        JsonFactory factory = new JsonFactory();
        JsonParser parser = null;

        try
        {
            parser = factory.createJsonParser(source);

            return iterate(parser, name);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(parser);
        }

        return null;
    }

    private static String iterate(JsonParser parser, String name) throws IOException
    {
        while (parser.nextToken() != JsonToken.END_OBJECT)
        {
            System.out.println(parser.getCurrentName() + " : " + parser.getText());
            if (parser.getCurrentToken() == JsonToken.START_OBJECT)
            {
                String result = iterate(parser, name);
                if (result != null)
                {
                    return result;
                }
            }
            if (name.equals(parser.getCurrentName()))
            {
                parser.nextToken();
                return parser.getText();
            }
        }
        return null;
    }
}
