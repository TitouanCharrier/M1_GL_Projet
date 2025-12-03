package com.example.server;

import org.springframework.stereotype.Component;
import org.springframework.core.io.Resource;
import java.util.List;
import java.util.ArrayList;

@Component
public class Storage {

    private final List<Resource> resources = new ArrayList<>();

    public List<Resource> getResources() {
        return resources;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }
}
