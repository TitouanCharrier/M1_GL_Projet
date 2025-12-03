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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/resources")
    public List<com.example.server.Resource> getAllResources() {
        return storage.getAllResources();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/exchanges")
    public List<com.example.server.Exchange> getAllExchanges() {
        return storage.getAllExchanges();
    }


}
