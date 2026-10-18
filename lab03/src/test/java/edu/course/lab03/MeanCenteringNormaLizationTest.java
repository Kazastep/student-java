package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeanCenteringNormaLizationTest {

    @Test 
    public void testEmptyArr(){

        double[] arr = {};
        assertThrows(IllegalArgumentException.class, 
            () -> { NormalizationStrategy account = new MeanCenteringNormalization();
                account.normalize(arr);
            });
    }

    @Test 
    public void currectWork(){

        double[] arr = {3.0,4.0,2.0};
        NormalizationStrategy strategy = new MeanCenteringNormalization();

        assertArrayEquals(new double[]{0.0, 1.0, -1.0},strategy.normalize(arr));
    }
}
