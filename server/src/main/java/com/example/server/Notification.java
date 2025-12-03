package com.example.server;

import java.util.Date;
import java.util.List;

public class Notification {
    private String id;
    private String type;
    private String content;
    private boolean isRead;
    private Date creationDate;
    
    private User recipient;
}
