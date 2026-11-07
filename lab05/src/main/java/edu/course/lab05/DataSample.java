package edu.course.lab05;

public final class DataSample {

    private final String id;
    private final String label;
    private final String source;
    private final int featureCount;
    private final SampleStatus status;

    public DataSample(String id, String label, String source, int featureCount, SampleStatus status){
        if (id == null || id.isBlank() || label == null || label.isBlank() || source == null || source.isBlank()){
            throw new IllegalArgumentException("String types is uncorrect");
        }
        if (status == null){
            throw new IllegalArgumentException("Status is null");
        }
        if (featureCount <= 0){
            throw new IllegalArgumentException("FeatureCount is <= 0");
        }
        this.id = id;
        this.label = label;
        this.source = source;
        this.featureCount = featureCount;
        this.status = status;
    }

    public String getId(){
        return this.id;
    }

    public  String getLabel(){
        return this.label;
    }

    public String getSource(){
        return this.source;
    }

    public int getFeatureCount(){
        return this.featureCount;
    }

    public SampleStatus getStatus(){
        return this.status;
    }

}
