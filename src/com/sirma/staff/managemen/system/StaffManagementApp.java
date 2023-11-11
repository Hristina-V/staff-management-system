package com.sirma.staff.managemen.system;

import com.sirma.staff.managemen.system.manager.StaffManagerFacade;

public class StaffManagementApp {

    public static void main(String[] args) {
        StaffManagerFacade managerFacade = new StaffManagerFacade();

        System.out.println("Welcome to Staff Management System");

        boolean isRunning;
        do {
            isRunning = managerFacade.execute();
            // Add Employee
            // 1, Peter Peterson, IT, Junior Java Developer, 1400.50
            // Add Employee
            // 2, Ivan Ivanson, IT, Junior Front-End Developer, 1400.00
            // Edit 1
            // 1, Peter Peterson, IT, Java Developer, 2500.00
            // List employees
            // Search Department Marketing
            // Search Id 1
            // Fire 1
            // Search Name Peter
            // Save & Exit
        } while (isRunning);

        System.out.println("We've already saved your state and are waiting for you to come back! :) ");
    }
}
