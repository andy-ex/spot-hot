package by.bsu.spothot.util.httphelper;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dmitry on 1/7/14.
 */
public class HttpRequestHelper
{
    private static final Logger log = Logger.getLogger(HttpRequestHelper.class);

    public static String sendGetRequest(URI uri) throws URISyntaxException, IOException, HttpException {
        HttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(uri);

        log.info("Sending http request: " + uri);

        HttpResponse response = client.execute(getRequest);
        //getRequest.abort();

        return IOUtils.toString(response.getEntity().getContent());
    }
}
