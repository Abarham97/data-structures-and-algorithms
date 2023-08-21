package linked.list.insertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    void testAppendSingleNode() {
        linkedList.append(5);
        assertEquals("head -> 5 -> X", linkedList.printList());
    }

    @Test
    void testAppendMultipleNodes() {
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);
        assertEquals("head -> 5 -> 10 -> 15 -> X", linkedList.printList());
    }

    @Test
    void testInsertBeforeMiddleNode() {
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(20);
        linkedList.insertBefore(10, 15);
        assertEquals("head -> 5 -> 15 -> 10 -> 20 -> X", linkedList.printList());
    }

    @Test
    void testInsertBeforeFirstNode() {
        linkedList.append(10);
        linkedList.insertBefore(10, 5);
        assertEquals("head -> 5 -> 10 -> X", linkedList.printList());
    }

    @Test
    void testInsertAfterMiddleNode() {
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(20);
        linkedList.insertAfter(10, 15);
        assertEquals("head -> 5 -> 10 -> 15 -> 20 -> X", linkedList.printList());
    }

    @Test
    void testInsertAfterLastNode() {
        linkedList.append(5);
        linkedList.append(10);
        linkedList.insertAfter(10, 15);
        assertEquals("head -> 5 -> 10 -> 15 -> X", linkedList.printList());
    }
}

