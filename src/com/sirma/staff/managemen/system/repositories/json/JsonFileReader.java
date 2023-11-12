package com.sirma.staff.managemen.system.repositories.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.sirma.staff.managemen.system.repositories.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileReader<T> extends FileReader<T> {
    private final ObjectMapper objectMapper;

    private final String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
    }

    public List<T> readFromFile() {
        try {
            return getObjectMapper().readValue(getFile(), new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Something happened");
        }
    }

    protected File getFile() {
        return new File(filePath);
    }

    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}