package com.sirma.staff.managemen.system.manager;

import com.sirma.staff.managemen.system.services.Service;

import java.util.List;
import java.util.Scanner;

public abstract class Manager {

    protected Service service;

    protected Scanner scanner;

    public Manager(Service service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void print(List entities) {
        entities.forEach(e -> System.out.println(e));
    }

    protected abstract void displayCommands();

    protected abstract boolean execute();
}
