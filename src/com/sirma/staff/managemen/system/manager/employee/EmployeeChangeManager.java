package com.sirma.staff.managemen.system.manager.employee;

import com.sirma.staff.managemen.system.exceptions.EntityNotFoundException;
import com.sirma.staff.managemen.system.models.Employee;

import java.time.LocalDate;
import java.util.Scanner;

import static com.sirma.staff.managemen.system.manager.ManagerUtils.readDoubleFromConsole;
import static com.sirma.staff.managemen.system.manager.ManagerUtils.readLocalDate;

public class EmployeeChangeManager extends StaffManager {

     public boolean execute() {

          while (true) {
               displayCommands();
               String userSelection = scanner.nextLine();

               if ("1".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);
                    System.out.println("Current employee name is: " + employee.getName());
                    System.out.println("Please provide new employee name: ");
                    String newName = scanner.nextLine();

                    employee.setName(newName);
                    service.update(employee);
               } else if ("2".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);
                    System.out.println("Current employee department is: " + employee.getDepartment());
                    System.out.println("Please provide new department: ");
                    String newDepartment = scanner.nextLine();

                    employee.setDepartment(newDepartment);
                    service.update(employee);
               } else if ("3".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);
                    System.out.println("Current employee position is: " + employee.getRole());
                    System.out.println("Please provide new position: ");
                    String newRole = scanner.nextLine();

                    employee.setDepartment(newRole);
                    service.update(employee);
               } else if ("4".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);
                    System.out.println("Current employee start date is: " + employee.getStartDate());
                    LocalDate newStartDate = readLocalDate(scanner, "dd/mm/yyyy", "new start date");

                    employee.setStartDate(newStartDate);
                    service.update(employee);
               } else if ("5".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);
                    System.out.println("Current employee salary is: " + employee.getSalary());
                    double newSalary = readDoubleFromConsole(scanner, "new salary");

                    employee.setSalary(newSalary);
                    service.update(employee);
               } else if ("6".equals(userSelection)) {
                    Employee employee = readEmployee(scanner);

                    if (employee.isActive()){
                         employee.setActive(false);
                         service.update(employee);
                    } else {
                         System.out.println("Employee is already fired.");
                    }
               } else if ("7".equals(userSelection)) {
                    return true;
               } else if("8".equals(userSelection)) {
                    return false;
               } else {
                    System.out.println("Invalid selection.");
               }
          }
     }

     protected void displayCommands() {
          System.out.println("Please select an option:");
          System.out.println("Select \"1\" to change employee name.");
          System.out.println("Select \"2\" to change employee department.");
          System.out.println("Select \"3\" to change employee position.");
          System.out.println("Select \"4\" to change employee start date.");
          System.out.println("Select \"5\" to change employee salary.");
          System.out.println("Select \"6\" to fire employee.");
          System.out.println("Select \"7\" to go back to the previous menu.");
          System.out.println("Select \"8\" to Save & Exit.");
     }

     private Employee readEmployee(Scanner scanner) {
          int id = Integer.parseInt(scanner.nextLine());

          try {
               return (Employee) service.findById(id);
          } catch (EntityNotFoundException e) {
               System.out.println("There is no employee with id " + id);
               return readEmployee(scanner);
          }
     }
}
