package com.sirma.staff.managemen.system.repositories.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.staff.managemen.system.repositories.FileWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter<T> extends FileWriter<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String filePath;

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
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