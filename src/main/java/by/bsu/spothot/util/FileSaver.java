package by.bsu.spothot.util;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Dmitry on 1/2/14.
 */
public class FileSaver
{

    public static void save(String content, String destination, String fileName)
    {
        FileOutputStream out = null;
        File file = new File(destination + File.separator + fileName);

        try
        {
            file.createNewFile();
            out = new FileOutputStream(file);
            IOUtils.copy(new StringReader(content), out);
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
