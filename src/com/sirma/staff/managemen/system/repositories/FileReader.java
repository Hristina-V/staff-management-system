package com.sirma.staff.managemen.system.repositories;

import java.util.List;

public abstract class FileReader<T> {
    public abstract List<T> readFromFile();
}
