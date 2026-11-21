package edu.course.lab06;

import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Repository<ID, T> {

    private final Map<ID, T> data = new LinkedHashMap<>();

    public void save(ID id, T value){
        data.put(id, value);
    }
    public T findById(ID id){
        return data.get(id);
    }
    public void remove(ID id) {
        data.remove(id);
    }
    public boolean contains(ID id) {
        return data.containsKey(id);
    }
    public int size() {
        return data.size();
    }
    public List<T> findAll() {
        return  new ArrayList<>(data.values());
    }
}