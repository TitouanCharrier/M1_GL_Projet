package com.example.server;

import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


@Component
public class Storage {

    private final List<Resource> resources = new ArrayList<>();

    public List<Resource> getResources() {
        return resources;
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    private static final String DB_URL = "jdbc:sqlite:Database.db";

    // Méthode générique pour récupérer tous les resources
    public List<Resource> getAllResources() {
        List<Resource> resources = new ArrayList<>();
        String sql = "SELECT * FROM Resource";
        System.out.println(sql);

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Resource resource = new Resource();
                resource.setId(rs.getString("id"));
                resource.setTitle(rs.getString("title"));
                resource.setDescription(rs.getString("description"));
                resource.setCategory(rs.getString("category"));
                resource.setType(rs.getString("type"));
                resource.setPrice(rs.getDouble("price"));

                resources.add(resource);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resources;
    }

    public List<Exchange> getAllExchanges() {
        List<Exchange> exchanges = new ArrayList<>();
        String sql = "SELECT * FROM Exchange";
        System.out.println(sql);

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Exchange exchange = new Exchange();
                exchange.setId(rs.getString("id"));
                exchange.setStatus(rs.getString("status"));
                exchange.setUser1(rs.getString("participant1"));
                exchange.setUser2(rs.getString("participant2"));
                exchange.setSubjectTitle(rs.getString("subjectTitle"));

                exchanges.add(exchange);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exchanges;
    }


}
