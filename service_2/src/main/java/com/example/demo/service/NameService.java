package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class NameService {
 
    public String getName(String id) {
        switch (id) {
            case "1":
                return "Jesse";
            case "2":
                return "Jimmy";
            default:
                return "UnKnown";
        }
    }
}