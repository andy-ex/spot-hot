package by.bsu.spothot.util.saver;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Dmitry on 1/1/14.
 */
public class UrlContentSaver
{


    public static void save(String url, String destination, String fileName)
    {
        FileOutputStream out = null;

        try
        {
            URL source = new URL(url);
            URLConnection connection = source.openConnection();

            File destDir = new File(destination);
            File destFile = new File(destination + File.separator + fileName);

            if (!destDir.exists())
            {
                destDir.mkdir();
            }

            destFile.createNewFile();

            out = new FileOutputStream(destFile);

            IOUtils.copy(source.openStream(), out);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(out);
        }
    }

}
