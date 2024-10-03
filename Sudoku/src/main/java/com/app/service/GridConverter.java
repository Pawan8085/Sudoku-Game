package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class GridConverter {

	@Autowired
    private  Gson gson ;

    // Convert a grid to JSON string
    public  String gridToString(int[][] grid) {
        return gson.toJson(grid);
    }

    // Convert a JSON string to grid
    public  int[][] stringToGrid(String json) {
        return gson.fromJson(json, int[][].class);
    }
}