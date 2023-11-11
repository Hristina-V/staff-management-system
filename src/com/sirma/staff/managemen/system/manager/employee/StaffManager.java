package com.sirma.staff.managemen.system.manager.employee;

import com.sirma.staff.managemen.system.manager.Manager;
import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileReader;
import com.sirma.staff.managemen.system.repositories.FileWriter;
import com.sirma.staff.managemen.system.repositories.csv.employee.EmployeeCsvFileReader;
import com.sirma.staff.managemen.system.repositories.csv.employee.EmployeeCsvFileWriter;
import com.sirma.staff.managemen.system.repositories.json.employee.EmployeeJsonFileReader;
import com.sirma.staff.managemen.system.repositories.json.employee.EmployeeJsonFileWriter;
import com.sirma.staff.managemen.system.services.StaffService;

public abstract class StaffManager extends Manager {

    // Change to EmployeeCsvFileReader if you would like to change persistence layer to CSV file
    private static final FileReader<Employee> reader = new EmployeeCsvFileReader();
    //private static final FileReader<Employee> reader = new EmployeeJsonFileReader();

    // Change to EmployeeCsvFileWriter if you would like to change persistence layer to CSV file
//    private static final FileWriter<Employee> writer = new EmployeeJsonFileWriter();
    private static final FileWriter<Employee> writer = new EmployeeCsvFileWriter();


    public StaffManager() {
        super(new StaffService(reader, writer));
    }
}
