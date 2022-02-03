package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.NameService;

@RestController
@RequestMapping(value="/name")
public class NameController {
 
    @Autowired
    NameService nameService;
 
    @GetMapping(value = "/{id}")
    public String name(@PathVariable("id") String id) {
        return nameService.getName(id);
    }
}

