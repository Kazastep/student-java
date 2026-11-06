package edu.course.lab05;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class SampleFileLoader {

    public LoadResult load(Path path) {
        List<String> lines;
        try{
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e){
            throw new DataLoadingException("Cannot read" + path, e);
        }
        if (lines.isEmpty()){
            throw new IllegalArgumentException("Lines is empty");
        }
        if (!(lines.get(0).equals("id;label;source;featureCount;status"))) {
            throw new IllegalArgumentException("First line is uncorrect");
        }
        List<DataSample> samples = new ArrayList<>();
        List<ValidationError> errors = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);

            if (line.isBlank()) {
                continue;
            }
            String[] fields = line.split(";", -1);
            if (fields.length != 5) {
                errors.add(new ValidationError(
                    i + 1,
                    "fields",
                    "Expected 5 fields"
                ));
                continue;
            }
            String id = fields[0];
            String label = fields[1];
            String source = fields[2];
            int featureCount;
            SampleStatus status;
            if (id.isBlank()) {
                    errors.add(new ValidationError(
                        i + 1,
                        "id",
                        "Id cannot be blank"
                    ));
                    continue;
                }
            if (label.isBlank()) {
                    errors.add(new ValidationError(
                        i + 1,
                        "label",
                        "Label cannot be blank"
                    ));
                    continue;
                }
            if (source.isBlank()) {
                    errors.add(new ValidationError(
                        i + 1,
                        "source",
                        "Source cannot be blank"
                    ));
                    continue;
                }
            try { featureCount = Integer.parseInt(fields[3]);
                } catch (NumberFormatException e) {
                    errors.add(new ValidationError(
                        i + 1, 
                        "featureCount", 
                        "Invalid number: " + fields[3]));
                        continue;
                }
            if (featureCount <= 0) {
                    errors.add(new ValidationError(
                        i + 1,
                        "featureCount",
                        "Feature count must be positive"
                    ));
                    continue;
                }
            try {status = SampleStatus.valueOf(fields[4]);
                } catch (IllegalArgumentException e) {
                    errors.add(new ValidationError(
                        i + 1, 
                        "status",
                        "Invalid status: " + fields[4]));
                        continue;
                }
            DataSample sample = new DataSample(
                id,
                label,
                source,
                featureCount,
                status
            );
            samples.add(sample);
        }
        return new LoadResult(samples, errors);
    }
}