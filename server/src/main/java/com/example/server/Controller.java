package com.example.server;

import com.example.server.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private Storage storage;

    public void ResourceController(Storage storage) {
        this.storage = storage;
    }

    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return storage.getResources();
    }


}
