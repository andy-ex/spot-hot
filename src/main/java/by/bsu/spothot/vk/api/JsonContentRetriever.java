package by.bsu.spothot.vk.api;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dmitry on 1/6/14.
 */
public class JsonContentRetriever
{
    @Autowired
    ApiRequestBuilder requestBuilder;

    public String retrievePosts(String domain, int count) throws URISyntaxException, IOException, HttpException
    {
        URI urlRequest = requestBuilder.wallContentRequest(domain, count);
        return HttpRequestHelper.sendGetRequest(urlRequest);
    }
}
