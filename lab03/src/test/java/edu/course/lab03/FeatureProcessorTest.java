package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FeatureProcessorTest {

    @Test
    void testProcessWithMinMax() {
        
        double[] arr = {10.0, 20.0, 30.0};
        NormalizationStrategy strategy = new MinMaxNormalization();
        FeatureProcessor processor = new FeatureProcessor(strategy);
        assertArrayEquals(
            new double[]{0.0, 0.5, 1.0},
            processor.process(arr)
        );
    }

    @Test
    void testProcessWithMeanCentering() {

        double[] arr = {10.0, 20.0, 30.0};
        NormalizationStrategy strategy = new MeanCenteringNormalization();
        FeatureProcessor processor = new FeatureProcessor(strategy);
        assertArrayEquals(
            new double[]{-10.0, 0.0, 10.0},
            processor.process(arr)
        );
    }

    @Test
    void testInputArrayNotModified() {

        double[] arr = {10.0, 20.0, 30.0};
        double[] expected = {10.0, 20.0, 30.0};
        NormalizationStrategy strategy = new MinMaxNormalization();
        FeatureProcessor processor = new FeatureProcessor(strategy);
        processor.process(arr);
        assertArrayEquals(expected, arr);
    }
}