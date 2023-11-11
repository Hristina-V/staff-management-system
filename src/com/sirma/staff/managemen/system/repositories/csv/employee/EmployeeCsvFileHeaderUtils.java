package com.sirma.staff.managemen.system.repositories.csv.employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCsvFileHeaderUtils {

    public static final Map<Integer, String> FILE_HEADER_LABELS;

    static {
        FILE_HEADER_LABELS = new HashMap<>();
        FILE_HEADER_LABELS.put(0, "Id");
        FILE_HEADER_LABELS.put(1, "Name");
        FILE_HEADER_LABELS.put(2, "StartDate");
        FILE_HEADER_LABELS.put(3, "Department");
        FILE_HEADER_LABELS.put(4, "Role");
        FILE_HEADER_LABELS.put(5, "Salary");
        FILE_HEADER_LABELS.put(6, "IsActive");
    }
}