package by.bsu.spothot.mediaservice.vkapi.jsonprocess;

import by.bsu.spothot.util.httphelper.HttpRequestHelper;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dmitry on 1/6/14.
 */
public class JsonContentRetriever
{
    @Autowired
    VKApiRequestBuilder requestBuilder;

    public String retrievePosts(String domain, int count) throws URISyntaxException, IOException, HttpException
    {
        URI urlRequest = requestBuilder.wallContentRequest(domain, count);
        return HttpRequestHelper.sendGetRequest(urlRequest);
    }
}
