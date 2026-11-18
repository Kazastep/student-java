
package edu.course.lab06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void testEmptyRepository() {
        Repository<Integer, String> repo = new Repository<>();

        assertEquals(0, repo.size());
        assertTrue(repo.findAll().isEmpty());
        assertFalse(repo.contains(1));
        assertNull(repo.findById(1));
    }

    @Test
    void testSaveAndFindById() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");
        repo.save(2, "Max");

        assertEquals("Alex", repo.findById(1));
        assertEquals("Max", repo.findById(2));
        assertEquals(2, repo.size());
    }

    @Test
    void testReplaceValue() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");
        repo.save(1, "Anna");

        assertEquals("Anna", repo.findById(1));
        assertEquals(1, repo.size());
    }

    @Test
    void testRemove() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");
        repo.save(2, "Max");

        repo.remove(1);

        assertFalse(repo.contains(1));
        assertNull(repo.findById(1));
        assertEquals(1, repo.size());
        assertEquals("Max", repo.findById(2));
    }

    @Test
    void testRemoveNonExistingKey() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");
        repo.remove(100);

        assertEquals(1, repo.size());
        assertEquals("Alex", repo.findById(1));
    }

    @Test
    void testContains() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");

        assertTrue(repo.contains(1));
        assertFalse(repo.contains(2));
    }

    @Test
    void testFindAllPreservesInsertionOrder() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(3, "Max");
        repo.save(1, "Anna");
        repo.save(2, "Alex");

        assertEquals(
            List.of("Max", "Anna", "Alex"),
            repo.findAll()
        );
    }

    @Test
    void testFindAllReturnsNewList() {
        Repository<Integer, String> repo = new Repository<>();

        repo.save(1, "Alex");
        repo.save(2, "Max");

        List<String> result = repo.findAll();
        result.clear();

        assertEquals(2, repo.size());
        assertEquals(
            List.of("Alex", "Max"),
            repo.findAll()
        );
    }

    @Test
    void testGenericTypes() {
        Repository<String, Integer> repo = new Repository<>();

        repo.save("first", 10);
        repo.save("second", 20);

        assertEquals(10, repo.findById("first"));
        assertEquals(20, repo.findById("second"));
    }
}
