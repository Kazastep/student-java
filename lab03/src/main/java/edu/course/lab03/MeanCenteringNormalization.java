package edu.course.lab03;

public class MeanCenteringNormalization implements NormalizationStrategy {

    @Override 
    public double[] normalize(double[] values){

        if (values.length == 0){
            throw new IllegalArgumentException("Пустой массив");
        }

        double[] normalizeArr = new double[values.length];
        double sum = 0;

        for (int i=0; i < values.length; i++){
            sum += values[i];
        }
        double meanValue = sum / values.length;

        for (int i=0; i < values.length; i++){
            double meanNormalize = values[i] - meanValue;
            normalizeArr[i] = meanNormalize;
        }
        return normalizeArr;
    }
}
