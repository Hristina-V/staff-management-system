package com.sirma.staff.managemen.system.repositories;

import java.util.List;

public abstract class FileWriter<T> {

    public abstract void writeToFile(List<T> entities);
}
