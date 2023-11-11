package com.sirma.staff.managemen.system.services;

import com.sirma.staff.managemen.system.exceptions.EntityNotFoundException;
import com.sirma.staff.managemen.system.models.Employee;
import com.sirma.staff.managemen.system.repositories.FileReader;
import com.sirma.staff.managemen.system.repositories.FileWriter;

import java.util.List;

public class StaffService extends Service<Employee> {

    public StaffService(FileReader<Employee> fileReader, FileWriter<Employee> fileWriter) {
        super(fileReader, fileWriter);
    }

    public List<Employee> findByDepartment(String department) {
        return findMultipleByCriteria(x -> x.getDepartment().equals(department));
    }

    public List<Employee> findByName(String name) {
        return findMultipleByCriteria(x -> x.getName().trim().equalsIgnoreCase(name));
    }

    public List<Employee> findByStatus(boolean isActive) {
        return findMultipleByCriteria(x -> x.isActive() == isActive);
    }

    public Employee findById(int id) {
        return findAll()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException());
    }
}
