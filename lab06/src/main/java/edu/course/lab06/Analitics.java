package edu.course.lab06;
import edu.course.lab05.DataSample;
import edu.course.lab05.SampleStatus;

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Analitics {
    private List<DataSample> samples;

    public Analitics(List<DataSample> samples){
        this.samples = samples;
    }

    public Map<SampleStatus, Integer> countStatus(){
        Map<SampleStatus, Integer> counts = new HashMap<>();

        for (DataSample sample: samples){
            SampleStatus status = sample.getStatus();
            if (counts.containsKey(status)){
                int count = counts.get(status);
                counts.put(status, count + 1);  ;
            } else{
            counts.put(status, 1);
            }
        }
        return counts;
    }

    public Set<String> uniqueSources() {
        Set<String> sources = new HashSet<>();

        for (DataSample sample: samples){
            sources.add(sample.getSource());
        }
        return sources;
    }

    public List<DataSample> sortedSamples() {
        List<DataSample> sorted = new ArrayList<>(samples);
        
        sorted.sort(Comparator.comparingInt(DataSample::getFeatureCount)
          .thenComparing(DataSample::getId));
        return sorted;
    }


}
