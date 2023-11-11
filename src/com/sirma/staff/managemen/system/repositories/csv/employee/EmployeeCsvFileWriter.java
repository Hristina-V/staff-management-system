package com.sirma.staff.managemen.system.repositories.csv.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileConstants;
import com.sirma.staff.managemen.system.repositories.csv.CsvFileWriter;

import static com.sirma.staff.managemen.system.repositories.FileConstants.EMPLOYEE_CSV_FILE_PATH;

public class EmployeeCsvFileWriter extends CsvFileWriter<Employee> {

    public EmployeeCsvFileWriter() {
        super(EMPLOYEE_CSV_FILE_PATH, EmployeeCsvFileHeaderUtils.FILE_HEADER_LABELS);
    }

    @Override
    protected String convertItemToCsvRow(Employee employee) {
        return new StringBuilder()
                .append(employee.getId())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.getName())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.getStartDate())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.getDepartment())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.getRole())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.getSalary())
                .append(FileConstants.CSV_DELIMITER)
                .append(employee.isActive())
                .append(FileConstants.CSV_DELIMITER)
                .toString();
    }
}
