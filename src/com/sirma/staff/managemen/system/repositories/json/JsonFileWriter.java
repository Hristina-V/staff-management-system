package com.sirma.staff.managemen.system.repositories.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.sirma.staff.managemen.system.repositories.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter<T> extends FileWriter<T> {

    private final ObjectMapper objectMapper;

    private String filePath;

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
    }

    public void writeToFile(List<T> entities) {
        try {
            objectMapper.writeValue(new File(filePath), entities);
            System.out.println("Data has been written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}