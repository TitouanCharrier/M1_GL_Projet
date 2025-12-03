package com.example.server.controller;

import com.example.server.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private Storage storage;

    public Controller(Storage storage) {
        this.storage = storage;
    }

    @GetMapping("/resources")
    public List<com.example.server.Resource> getAllResources() {
        System.out.println("test");
        return storage.getAllResources();
    }


}
