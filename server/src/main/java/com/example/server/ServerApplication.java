package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class ServerApplication {

    public List<Resource> globalResourceList = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);

        ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        Storage storage = context.getBean(Storage.class);

        storage.addResource(new ByteArrayResource("Hello".getBytes()));
    }
}
