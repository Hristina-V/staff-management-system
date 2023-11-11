package com.sirma.staff.managemen.system.repositories.json.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileConstants;
import com.sirma.staff.managemen.system.repositories.json.JsonFileReader;

public class EmployeeJsonFileReader extends JsonFileReader<Employee> {

    public EmployeeJsonFileReader() {
        super(FileConstants.EMPLOYEE_JSON_FILE_PATH);
    }
}
