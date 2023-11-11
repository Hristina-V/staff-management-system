package com.sirma.staff.managemen.system.repositories.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.staff.managemen.system.repositories.FileConstants;
import com.sirma.staff.managemen.system.repositories.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class JsonFileReader<T> extends FileReader<T> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String filePath;

    public JsonFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<T> readFromFile() {
        try {
            return objectMapper.readValue(new File(FileConstants.EMPLOYEE_JSON_FILE_PATH), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}