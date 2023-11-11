package com.sirma.staff.managemen.system.repositories.csv.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.csv.CsvFileReader;
import com.sirma.staff.managemen.system.services.DateParser;

import static com.sirma.staff.managemen.system.repositories.FileConstants.EMPLOYEE_CSV_FILE_PATH;

public class EmployeeCsvFileReader extends CsvFileReader<Employee> {

    public EmployeeCsvFileReader() {
        super(EMPLOYEE_CSV_FILE_PATH, EmployeeCsvFileHeaderUtils.FILE_HEADER_LABELS);
    }

    @Override
    protected Employee parseEntity(String[] valuesAsString) {
        boolean hasIsActiveValue = valuesAsString.length == 7 && valuesAsString[6] != null && valuesAsString[6].length() > 0;
        boolean isActive = hasIsActiveValue ? Boolean.parseBoolean(valuesAsString[6]) : true;

        return new Employee(Integer.parseInt(valuesAsString[0]),
                valuesAsString[1],
                DateParser.parseLocalDate(valuesAsString[2]),
                valuesAsString[3],
                valuesAsString[4],
                Double.parseDouble(valuesAsString[5]),
                isActive
        );
    }
}