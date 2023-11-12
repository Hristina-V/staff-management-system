package com.sirma.staff.managemen.system.manager.employee;

import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.services.DateParser;

import java.time.LocalDate;
import java.util.Scanner;

import static com.sirma.staff.managemen.system.manager.ManagerUtils.readDoubleFromConsole;
import static com.sirma.staff.managemen.system.manager.ManagerUtils.readLocalDate;

public class EmployeeOnboardManager extends StaffManager {
    private final Scanner scanner = new Scanner(System.in);

    public boolean execute() {
        System.out.println("Enter employee name: ");
        String name = scanner.nextLine();

        LocalDate startDate = readStartDate();

        System.out.println("Enter department: ");
        String department = scanner.nextLine();

        System.out.println("Enter employee role: ");
        String role = scanner.nextLine();

        double salary = readDoubleFromConsole(scanner, "salary");

        Employee newEmployee = new Employee(0, name.trim(), startDate, department.trim(), role.trim(), salary, true);

        service.create(newEmployee);

        // We return true because we would like the program to continue
        return true;
    }

    protected void displayCommands() {
        //TODO Maybe add some welcome msg.
    }

    private LocalDate readStartDate() {
        return readLocalDate(scanner, DateParser.DATE_FORMAT_STRING, "Start date");
    }
}
