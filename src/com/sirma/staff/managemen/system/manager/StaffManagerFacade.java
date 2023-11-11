package com.sirma.staff.managemen.system.manager;

import com.sirma.staff.managemen.system.manager.employee.EmployeeChangeManager;
import com.sirma.staff.managemen.system.manager.employee.EmployeeDisplayManager;
import com.sirma.staff.managemen.system.manager.employee.EmployeeOnboardManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StaffManagerFacade {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Map<Integer, Manager> COMMAND_TO_MANAGER_MAPPING;


    static {
        COMMAND_TO_MANAGER_MAPPING = new HashMap<>();

        final EmployeeChangeManager employeeChangeManager = new EmployeeChangeManager();
        final EmployeeDisplayManager employeeDisplayManager = new EmployeeDisplayManager();
        final EmployeeOnboardManager employeeOnboardManager = new EmployeeOnboardManager();

        COMMAND_TO_MANAGER_MAPPING.put(1, employeeDisplayManager);
        COMMAND_TO_MANAGER_MAPPING.put(2, employeeOnboardManager);
        COMMAND_TO_MANAGER_MAPPING.put(3, employeeChangeManager);
    }

    /**
     * Main engine for the application.
     * @return true if we would like to continue with another round or else if there is a problem and we would like to finish.
     */
    public boolean execute() {
        displayCommands();

        int command = readValidCommand();

        return COMMAND_TO_MANAGER_MAPPING.get(command).execute();
    }

    private int readValidCommand() {
        int command;
        do {
            command = Integer.parseInt(scanner.nextLine()); //TODO extract to ManagerUtils readInteger method
        } while(command < 1 || command > 3);

        return command;
    }

    private void displayCommands() {
        System.out.println("Please select an option:");
        System.out.println("Select \"1\" to display employees."); //display CLI
        System.out.println("Select \"2\" to add new employee.");
        System.out.println("Select \"3\" to update employee data."); //also includes fire
    }
}
