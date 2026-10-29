package edu.course.lab04;

public class DataSample {
    private final SampleId id;
    private final String label;
    private final double[] features;

    public DataSample(SampleId id, String label, double[] features){
        this.id = id;
        this.label = label;
        this.features = features.clone();
    }
    public SampleId getId(){
        return this.id;
    }
    public String getLabel(){
        return this.label;
    }
    public double[] getFeatures(){
        return this.features.clone();
    }
}
