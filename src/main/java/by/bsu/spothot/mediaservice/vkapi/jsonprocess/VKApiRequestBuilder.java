package by.bsu.spothot.mediaservice.vkapi.jsonprocess;

import by.bsu.spothot.mediaservice.vkapi.parser.PostExtractor;
import com.sun.org.glassfish.gmbal.NameValue;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 1/6/14.
 */
public class VKApiRequestBuilder
{
    private String scheme;
    private String host;

    public URI wallContentRequest(String domain, int count) throws URISyntaxException
    {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("domain", domain));
        parameters.add(new BasicNameValuePair("count", Integer.toString(count)));

        return URIUtils.createURI(scheme, host, -1, "/method/wall.get", URLEncodedUtils.format(parameters, "UTF-8"),
                null);
    }

    public URI postsRequest(String... ids) throws URISyntaxException
    {
        List<NameValuePair>  parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("posts", ids[0]));

        return URIUtils.createURI(scheme, host, -1, "/method/wall.getById", URLEncodedUtils.format(parameters, "UTF-8"),
                null);
    }

    public void setScheme(String scheme)
    {
        this.scheme = scheme;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

}
