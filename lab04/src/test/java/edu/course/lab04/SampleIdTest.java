package edu.course.lab04;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleIdTest {

    @Test
    void equalKeysHaveSameHashCode() {
        SampleId a = new SampleId("Iris", 1);
        SampleId b = new SampleId("Iris", 1);

        assertNotSame(a, b);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void differentKeysAreNotEqual() {
        SampleId a = new SampleId("Iris", 1);
        SampleId b = new SampleId("Iris", 2);
        SampleId c = new SampleId("Wine", 1);

        assertNotEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    void equalsHandlesNullAndOtherTypes() {
        SampleId id = new SampleId("Iris", 1);

        assertNotEquals(null, id);
        assertFalse(id.equals("Iris"));
        assertEquals(id, id);
    }
}
