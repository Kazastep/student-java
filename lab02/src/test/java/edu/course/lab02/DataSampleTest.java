package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataSampleTest {
 
    // Тест проверяет отработку ошибки null параметра в label
    @Test 
    public void throwsExceptionForNullLabel() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample("first", null,new double[]{1.2, 3.4}));
    }

    // Тест проверяет отработку ошибки "" параметра в label
    @Test 
    public void throwsExceptionForEmptyLabel() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample("first", "",new double[]{1.2, 3.4}));
    }

    // Тест проверяет отработку ошибки null параметра в id
    @Test 
    public void throwsExceptionForNullId() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample(null, "programmer",new double[]{1.2, 3.4}));
    }

    // Тест проверяет отработку ошибки "" параметра в id
    @Test 
    public void throwsExceptionForEmptyId() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample("", "programmer",new double[]{1.2, 3.4}));
    }

    // // Тест проверяет ошибку при передаче пустого массива features
    @Test
    public void throwsExceptionForNullFeatures() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample("first", "programmer",null));
    }

    // Тест проверяет отработку ошибки "" параметра в features
    @Test
    public void throwsExceptionForEmptyFeatures() {
        assertThrows(IllegalArgumentException.class, 
        () -> new DataSample("first", "programmer", new double[] {}));
    }

    // Тест проверяет, что при конструкторе создается копия
    @Test 
    public void constructorCopiesFeatures() {
        double[] originalData = {1.2, 2.3};
        DataSample data = new DataSample(
            "First", "Lab", originalData
        );
        originalData[0] = 999;
        assertEquals(1.2, data.getFeatures()[0]);
    }
    
    // Тест проверяет, что getFeatures() возвращает копию массива
    @Test 
    public void getFeaturesReturnsCopy() {
        DataSample data = new DataSample(
            "First", "Lab", new double[]{1.2, 3.5}
        );
        double[] dataClone = data.getFeatures();
        dataClone[0] = 999;
        assertEquals(1.2, data.getFeatures()[0]);
    }

    // Тест проверяет отработку ошибки null параметра в changeStatus
    @Test
    public void throwsExceptionForNullStatus() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{1.2, 3.5}
        );
        assertThrows(IllegalArgumentException.class, 
        () -> data.changeStatus(null));
    }

    // Тест проверяет что статус изменился
    @Test
    public void changesStatus() {
        DataSample data = new DataSample(
            "first", "programmer", new double[]{2.0, 3.0}
        );
        data.changeStatus(SampleStatus.READY);
        assertEquals(SampleStatus.READY, data.getStatus());
    }

    // Тест проверяет среднее значение в averageFeatures
    @Test 
    public void calculatesAverageFeatures() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{2.0,3.0}
        );
        assertEquals(2.5,data.averageFeatures());
    }

    // Тест проверяет что значение возращает true для isReady
    @Test 
    public void returnTrueIsReady() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{2.0,3.0}
        );
        data.changeStatus(SampleStatus.READY);
        assertTrue(data.isReady());
    }

    // Тест проверяет что значение возращает false для isReady
    @Test
    public void returnFalseIsReady() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{2.0,3.0}
        );
        assertFalse(data.isReady());
    }

    // Тест проверяет грамотную инициализацию
    @Test 
    public void createsValidDataSample() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{2.0,3.0}
        );
        assertEquals("first", data.getId());
        assertEquals("programmer", data.getLabel());
        assertEquals(SampleStatus.NEW, data.getStatus());
        assertArrayEquals(new double[]{2.0, 3.0}, data.getFeatures());
    }

    // Тест проверяет нормализацию массива
    @Test 
    public void normalizedFeaturesTest() {
        DataSample data = new DataSample(
            "first", "programmer",new double[]{10.0, 20.0, 30.0}
        );
        assertArrayEquals(new double[]{0.0,0.5,1.0}, data.normalizedFeatures());
    }

    // Тест проверяет сохранность исходного массива после нормализации
    @Test
    public void normalizationDoesNotModifyOriginal() {
        DataSample data = new DataSample(
            "first",
            "programmer",
            new double[]{10.0, 20.0, 30.0}
        );

        data.normalizedFeatures();

        assertArrayEquals(
            new double[]{10.0, 20.0, 30.0},
            data.getFeatures()
        );
    }
}
