package edu.course.lab04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleRegistryTest {

    @Test
    void addAndGetSample() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id = new SampleId("Iris", 1);
        DataSample sample = new DataSample(
                id, "setosa", new double[]{5.1, 3.5}
        );

        registry.add(id, sample);

        assertSame(sample, registry.get(id));
        assertTrue(registry.contains(id));
        assertEquals(1, registry.size());
    }

    @Test
    void equalKeysFindSameValue() {
        SampleRegistry registry = new SampleRegistry();

        SampleId id1 = new SampleId("Iris", 1);
        SampleId id2 = new SampleId("Iris", 1);

        DataSample sample = new DataSample(
                id1, "setosa", new double[]{5.1}
        );

        registry.add(id1, sample);

        assertSame(sample, registry.get(id2));
        assertTrue(registry.contains(id2));
    }

    @Test
    void equalKeyReplacesValue() {
        SampleRegistry registry = new SampleRegistry();

        SampleId id1 = new SampleId("Iris", 1);
        SampleId id2 = new SampleId("Iris", 1);

        DataSample first = new DataSample(
                id1, "first", new double[]{1.0}
        );
        DataSample second = new DataSample(
                id2, "second", new double[]{2.0}
        );

        registry.add(id1, first);
        registry.add(id2, second);

        assertEquals(1, registry.size());
        assertSame(second, registry.get(id1));
    }

    @Test
    void removeSample() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id = new SampleId("Iris", 1);
        DataSample sample = new DataSample(
                id, "setosa", new double[]{5.1}
        );

        registry.add(id, sample);

        assertSame(sample, registry.remove(id));
        assertFalse(registry.contains(id));
        assertNull(registry.get(id));
        assertEquals(0, registry.size());
    }

    @Test
    void missingKeyReturnsNull() {
        SampleRegistry registry = new SampleRegistry();
        SampleId id = new SampleId("Iris", 99);

        assertNull(registry.get(id));
        assertNull(registry.remove(id));
        assertFalse(registry.contains(id));
        assertEquals(0, registry.size());
    }

    @Test
    void collisionDoesNotMergeDifferentKeys() {
        SampleRegistry registry = new SampleRegistry();

        // У строк "Aa" и "BB" одинаковые hashCode.
        SampleId id1 = new SampleId("Aa", 1);
        SampleId id2 = new SampleId("BB", 1);

        assertEquals(id1.hashCode(), id2.hashCode());
        assertNotEquals(id1, id2);

        DataSample first = new DataSample(
                id1, "first", new double[]{1.0}
        );
        DataSample second = new DataSample(
                id2, "second", new double[]{2.0}
        );

        registry.add(id1, first);
        registry.add(id2, second);

        assertEquals(2, registry.size());
        assertSame(first, registry.get(id1));
        assertSame(second, registry.get(id2));
    }
}
