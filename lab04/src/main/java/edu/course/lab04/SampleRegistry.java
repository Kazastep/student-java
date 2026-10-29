package edu.course.lab04;

import java.util.HashMap;

public class SampleRegistry {
    private final HashMap<SampleId, DataSample> samples;

    public SampleRegistry() {
        this.samples = new HashMap<>();
    }

    public void add(SampleId id, DataSample sample) {
        this.samples.put(id, sample);
    }
    public DataSample get(SampleId id) {
        return this.samples.get(id);
    }
    public DataSample remove(SampleId id) {
        return this.samples.remove(id);
    }
    public boolean contains(SampleId id) {
        return this.samples.containsKey(id);
    }
    public int size() {
        return this.samples.size();
    }
}