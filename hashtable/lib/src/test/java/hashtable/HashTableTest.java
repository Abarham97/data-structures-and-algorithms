package hashtable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    @Test
    public void testSetAndGet() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        assertEquals(1, hashTable.get("one"));
    }

    @Test
    public void testGetNonExistentKey() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        assertNull(hashTable.get("nonexistent"));
    }

    @Test
    public void testHas() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("two", 2);
        assertTrue(hashTable.has("two"));
        assertFalse(hashTable.has("nonexistent"));
    }

    @Test
    public void testKeys() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three", 3);

        List<String> expectedKeys = new ArrayList<>();
        expectedKeys.add("one");
        expectedKeys.add("two");
        expectedKeys.add("three");

        assertEquals(expectedKeys, (List<String>) hashTable.keys());
    }

    @Test
    public void testCollisionHandling() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("neo", 11);
        assertEquals(1, hashTable.get("one"));
        assertEquals(11, hashTable.get("neo"));
    }

    @Test
    public void testHashFunction() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        int hash = hashTable.hash("test");
        assertTrue(hash >= 0 && hash < hashTable.getTableSize());
    }
}
