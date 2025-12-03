package com.example.server;

import java.util.Date;
import java.util.List;

public class Item extends Resource {
    private double price;

    public boolean create() {
        return false;
    }

    public List<Item> browse() {
        return null;
    }

    public List<Item> search() {
        return null;
    }

}
