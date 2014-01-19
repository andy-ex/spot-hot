package by.bsu.spothot.mediaservice.vkapi.jsonprocess;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

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
    private String accessToken;

    public URI wallContentRequest(String domain, int count) throws URISyntaxException
    {
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("domain", domain));
        parameters.add(new BasicNameValuePair("count", Integer.toString(count)));
        parameters.add(new BasicNameValuePair("access_token", accessToken));

        return URIUtils.createURI(scheme, host, -1, "/method/wall.get", URLEncodedUtils.format(parameters, "UTF-8"),
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

    public void setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
    }
}
