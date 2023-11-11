package com.sirma.staff.managemen.system.repositories.csv;

import com.sirma.staff.managemen.system.repositories.FileConstants;

import java.util.Map;

public class BaseCsvFileHeaderUtils {

    public static String buildCsvHeaderRow(Map<Integer, String> fileHeaderLabels) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> columns = fileHeaderLabels;

        for(int i = 0; i < columns.size() - 1; i++) {
            sb.append(columns.get(i));
            sb.append(FileConstants.CSV_DELIMITER);
        }

        sb.append(columns.get(columns.size() - 1));

        return sb.toString();
    }
}
