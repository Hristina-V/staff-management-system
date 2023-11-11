package com.sirma.staff.managemen.system.manager.employee;

import com.sirma.staff.managemen.system.exceptions.EntityNotFoundException;
import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.services.StaffService;

import java.util.List;

public class EmployeeDisplayManager extends StaffManager {

    public boolean execute() {
        final StaffService staffService = (StaffService) service;

        while (true) {
            displayCommands();
            String userSelection = scanner.nextLine();

            if ("1".equals(userSelection)) {
                List<Employee> employees = service.findAll();
                print(employees);
            } else if ("2".equals(userSelection)) {
                List<Employee> employees = staffService.findByStatus(true);
                print(employees);
            } else if ("3".equals(userSelection)) {
                String department = scanner.nextLine();
                List<Employee> employees = staffService.findByDepartment(department);

                if (employees == null || employees.isEmpty()) {
                    System.out.println("There are no employees in department " + department);
                } else {
                    print(employees);
                }
            } else if ("4".equals(userSelection)) {
                int id = Integer.parseInt(scanner.nextLine());

                try {
                    Employee employee = staffService.findById(id);
                    System.out.println(employee);
                } catch (EntityNotFoundException e) {
                    System.out.println("There is no employee with ID " + id);
                }
            } else if ("5".equals(userSelection)) {
                String name = scanner.nextLine();

                try {
                    List<Employee> employees = staffService.findByName(name);
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                } catch (EntityNotFoundException e) {
                    System.out.println("There is no employee with the name " + name);
                }
            } else if ("6".equals(userSelection)) {
                return true;
            } else if ("7".equals(userSelection)) {
                return false;
            } else {
                System.out.println("Invalid selection.");
            }
        }
    }

    protected void displayCommands() {
        System.out.println("Please select an option:");
        System.out.println("Select \"1\" to display all employees.");
        System.out.println("Select \"2\" to display all active employees.");
        System.out.println("Select \"3\" to display employees by department.");
        System.out.println("Select \"4\" to display employee by ID.");
        System.out.println("Select \"5\" to display employee by name.");
        System.out.println("Select \"6\" to go back to the previous menu.");
        System.out.println("Select \"7\" to Save & Exit.");
    }
}
