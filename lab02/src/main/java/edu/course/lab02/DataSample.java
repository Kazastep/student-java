package edu.course.lab02;

public class DataSample {
    private String id;
    private String label;
    private SampleStatus status;
    private double[] features;

    public DataSample(String id, String label, double[] features) {
        // Проверка lable
        if (label == null || label.isEmpty()){
            throw new IllegalArgumentException();
        }
        // Проврка id
        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException();
        }
        // Проверка массива
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.label = label;
        this.status = SampleStatus.NEW;
        this.features = features.clone();
    }

    public String getId() {
        return this.id;
    }

    public SampleStatus getStatus() {
        return this.status;
    }

    public String getLabel() {
        return this.label;
    }

    public double[] getFeatures() {
        return this.features.clone();
    }

    public void changeStatus(SampleStatus status) {
        if (status == null) {
            throw new IllegalArgumentException();
        }
        this.status = status;
    }

    public double averageFeatures() {
        double sum = 0;
        for (int i=0; i < features.length; i++) {
            sum += features[i];
        }
        double average = sum / features.length;
        return average;
    }

    public boolean isReady() {
        return this.status == SampleStatus.READY;
    }
}
