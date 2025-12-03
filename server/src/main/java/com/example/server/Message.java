package com.example.server;  

import java.time.LocalDateTime;

public class Message {
    private String id;
    private String content;
    private LocalDateTime timestamp; // type moderne
    
    private User sender;
    private User receiver;

}

