package linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    public void testEmptyLinkedList() {
        LinkedList list = new LinkedList();
        assertEquals("Null", list.toString(), "Empty list should return 'Null'");
    }

    @Test
    public void testInsertIntoLinkedList() {
        LinkedList list = new LinkedList();
        list.insert(10);
        assertEquals("{10} ->Null", list.toString(), "List after insertion should match expected");
    }

    @Test
    public void testHeadPointsToFirstNode() {
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(4);
        assertEquals(2, list.Head.value, "Head should point to the first node");
    }

    @Test
    public void testInsertMultipleNodes() {
        LinkedList list = new LinkedList();
        list.insert(78);
        list.insert(58);
        assertEquals("{78} ->{58} ->Null", list.toString(), "List after multiple insertions should match expected");
    }

    @Test
    public void testContainsExistingValue() {
        LinkedList list = new LinkedList();
        list.insert(22);
        list.insert(40);
        assertTrue(list.contain(22), "Value 22 should exist in the list");
    }

    @Test
    public void testContainsNonExistingValue() {
        LinkedList list = new LinkedList();
        list.insert(60);
        list.insert(42);
        assertFalse(list.contain(70), "Value 78 should not exist in the list");
    }
}
