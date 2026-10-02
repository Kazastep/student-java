package edu.course.lab02;

public class DataSample {
    private SampleId id;
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

        this.id = new SampleId(id);
        this.label = label;
        this.status = SampleStatus.NEW;
        this.features = features.clone();
    }

    public String getId() {
        return this.id.value();
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

    public double[] normalizedFeatures() {
        double[] featuresClone = features.clone();
        double min = features[0];
        double max = features[0];

        for(int i=1; i < features.length; i++) {
            if (min > features[i]) {
                min = features[i];
            }
            if (max < features[i]) {
                max = features[i];
            }
        }
        if (max == min) {
            return new double[features.length];
        }
        for (int i=0; i < features.length; i++) {
            double value = (features[i]-min) / (max - min);
            featuresClone[i] = value;
        }
        return featuresClone;
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
