package com.sirma.staff.managemen.system.repositories.json.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileConstants;
import com.sirma.staff.managemen.system.repositories.json.JsonFileWriter;

public class EmployeeJsonFileWriter extends JsonFileWriter<Employee> {

    public EmployeeJsonFileWriter() {
        super(FileConstants.EMPLOYEE_JSON_FILE_PATH);
    }
}
