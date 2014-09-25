package by.bsu.spothot.mediaservice;

import by.bsu.spothot.bean.Post;
import by.bsu.spothot.mediaservice.vkapi.main.VkMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Julia on 1/19/14.
 */
@Component
public class SharedMediaService
{
    @Autowired
    private VkMediaService vkMediaService;

    public Post getMostLikedPost(String genre, int count)
    {
        return vkMediaService.getMostLikedPost(genre, count);
    }

    public Post getPost(String id)
    {
        return vkMediaService.getPostById(id);
    }
}
