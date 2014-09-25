package by.bsu.spothot.mediaservice.configuration;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dmitry on 25.09.2014.
 */
public class MusicDomainMapping {

    private Map<String, String> mapping;

    public String getDomainForKey(String key) {
        if (mapping != null) {
            return mapping.get(key);
        }
        return null;
    }

    public Set<String> getKeys() {
        if (mapping != null) {
            return mapping.keySet();
        }
        return Collections.EMPTY_SET;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }
}
