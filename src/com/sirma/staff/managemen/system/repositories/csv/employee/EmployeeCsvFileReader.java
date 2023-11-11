package com.sirma.staff.managemen.system.repositories.csv.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.csv.CsvFileReader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.sirma.staff.managemen.system.repositories.FileConstants.EMPLOYEE_CSV_FILE_PATH;

public class EmployeeCsvFileReader extends CsvFileReader<Employee> {

    public EmployeeCsvFileReader() {
        super(EMPLOYEE_CSV_FILE_PATH, EmployeeCsvFileHeaderUtils.FILE_HEADER_LABELS);
    }

    @Override
    protected Employee parseEntity(String[] valuesAsString) {
        //TODO extract a method for parsing date for all the places in the app.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");

        return new Employee(Integer.parseInt(valuesAsString[0]),
                valuesAsString[1],
                LocalDate.parse(valuesAsString[2], formatter),
                valuesAsString[3],
                valuesAsString[4],
                Double.parseDouble(valuesAsString[5])
        );
    }
}