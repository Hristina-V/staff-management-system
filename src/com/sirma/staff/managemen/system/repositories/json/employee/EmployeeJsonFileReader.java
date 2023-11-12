package com.sirma.staff.managemen.system.repositories.json.employee;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileConstants;
import com.sirma.staff.managemen.system.repositories.json.JsonFileReader;

import java.io.IOException;
import java.util.List;

public class EmployeeJsonFileReader extends JsonFileReader<Employee> {

    public EmployeeJsonFileReader() {
        super(FileConstants.EMPLOYEE_JSON_FILE_PATH);
    }

    //TODO still don't know why I need to override it here. For some reason it's not working with the generics
    @Override
    public List<Employee> readFromFile() {
        try {
            return getObjectMapper().readValue(getFile(), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Something happened");
        }
    }

}
