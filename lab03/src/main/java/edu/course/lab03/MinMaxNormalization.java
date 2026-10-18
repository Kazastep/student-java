package edu.course.lab03;

public class MinMaxNormalization implements NormalizationStrategy{

    @Override 
    public double[] normalize(double[] values){

        if (values.length == 0){
            throw new IllegalArgumentException("Пустой массив");
        }

        double[] normalizeArr = new double[values.length];
        double min = values[0];
        double max = values[0];

        for (int i=0; i < values.length; i++){
            if (values[i] > max) {
                max = values[i];
            }
            else if(values[i] < min){
                min = values[i];
            }
        }
        if (max == min) {
            return normalizeArr;
        }
        for (int i=0; i < values.length; i++){
            double normalizeIndex = (values[i] - min) / (max - min);
            normalizeArr[i] = normalizeIndex;
        }
        return normalizeArr;
    }
}

