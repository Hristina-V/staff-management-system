package com.sirma.staff.managemen.system.services;

import com.sirma.staff.managemen.system.exceptions.EntityNotFoundException;
import com.sirma.staff.managemen.system.models.BaseEntity;
import com.sirma.staff.managemen.system.repositories.FileReader;
import com.sirma.staff.managemen.system.repositories.FileWriter;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service<T extends BaseEntity> {

    private FileReader<T> fileReader;

    private FileWriter<T> fileWriter;

    private Random random;

    public Service(FileReader<T> fileReader, FileWriter<T> fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.random = new Random();
    }

    public List<T> findAll() {
        return fileReader.readFromFile();
    }

    public T findById(int id) {
        return findSingleByCriteria(x -> x.getId() == id);
    }

    /**
     * Generates and appends id to the entity and saves entity to the data store.
     * @param entity
     */
    public void create(T entity) {
        entity.setId(generateId());

        List<T> entities = findAll();
        entities.add(entity);

        fileWriter.writeToFile(entities);
    }

    public void update(T entity) {
        boolean isUpdated = false;

        List<T> entities = findAll();

        for (int i = 0; i < entities.size(); i++) {
            if(entities.get(i).getId() == entity.getId()) {
                entities.set(i, entity);
                isUpdated = true;
            }
        }

        if(!isUpdated) {
            throw new EntityNotFoundException();
        }

        fileWriter.writeToFile(entities);
    }

    public void delete(int id) {
        List<T> entities = findMultipleByCriteria(x -> x.getId() != id);
        fileWriter.writeToFile(entities);
    }

    protected T findSingleByCriteria(Predicate<? super T> criteria) {
        return findByCriteria(criteria)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException());
    }

    protected List<T> findMultipleByCriteria(Predicate<? super T> criteria) {
        return
            findByCriteria(criteria)
            .collect(Collectors.toList());
    }

    protected Stream<T> findByCriteria(Predicate<? super T> criteria) {
        return findAll()
                .stream()
                .filter(criteria);
    }

    /**
     * Generates unique id that's not present in the data set just yet
     * @return
     */
    private int generateId() {
        do {
            int id = random.nextInt();
            List<T> all = findAll();
            final int tempIdCopy = id; // it's required by stream, so that we can filter
            long idRepeatsCount = all.stream().filter(x -> x.getId() == tempIdCopy).count();

            if(idRepeatsCount == 0) {
                return id;
            }
        } while(true);
    }
}
