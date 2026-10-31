package edu.course.lab04;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MutableKeyTest {

    static class MutableKey {
        private int id;

        MutableKey(int id) {
            this.id = id;
        }

        void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MutableKey)) {
                return false;
            }
            MutableKey other = (MutableKey) obj;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    @Test
    void changingKeyBreaksLookup() {
        HashMap<MutableKey, String> map = new HashMap<>();

        MutableKey key = new MutableKey(1);
        map.put(key, "sample");

        assertEquals("sample", map.get(key));

        // Меняем поле, участвующее в hashCode.
        key.setId(100);

        assertNull(map.get(key));
        assertEquals(1, map.size());
    }
}
