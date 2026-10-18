package edu.course.lab03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MinMaxNormalizationTest {

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

        double[] arr = {10.0,20.0,30.0};
        NormalizationStrategy strategy = new MinMaxNormalization();
        assertArrayEquals(new double[] {0,0.5,1}, strategy.normalize(arr));
    }

}
