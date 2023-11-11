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
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
            return objectMapper.readValue(new File(filePath), typeFactory.constructType(typeReference.getType()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}