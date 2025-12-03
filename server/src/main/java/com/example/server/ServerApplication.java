package com.example.server;

import java.sql.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;



@SpringBootApplication
public class ServerApplication {


    public List<Resource> globalResourceList = new ArrayList<>();

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        Storage storage = context.getBean(Storage.class);

    }


    
}
