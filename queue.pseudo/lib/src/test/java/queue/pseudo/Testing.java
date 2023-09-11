package queue.pseudo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {

    private PseudoQueue<Integer> pseudoQueue;

    @BeforeEach
    void setUp() {
        pseudoQueue = new PseudoQueue<>();
    }

    @Test
    void testEnqueueAndDequeue() {
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        pseudoQueue.enqueue(3);

        assertEquals(1, pseudoQueue.dequeue());
        assertEquals(2, pseudoQueue.dequeue());
        assertEquals(3, pseudoQueue.dequeue());
        assertTrue(pseudoQueue.isEmpty());
    }

    @Test
    void testDequeueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> pseudoQueue.dequeue());
    }

    @Test
    void testEnqueueAndDequeueMixed() {
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        assertEquals(1, pseudoQueue.dequeue());

        pseudoQueue.enqueue(3);
        assertEquals(2, pseudoQueue.dequeue());
        assertEquals(3, pseudoQueue.dequeue());
        assertTrue(pseudoQueue.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(pseudoQueue.isEmpty());
        pseudoQueue.enqueue(1);
        assertFalse(pseudoQueue.isEmpty());
        pseudoQueue.dequeue();
        assertTrue(pseudoQueue.isEmpty());
    }

    @Test
    void testCustomStackPushPop() {
       Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testCustomStackPeek() {
       Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
        stack.pop();
        assertEquals("A", stack.peek());
    }

    @Test
    void testCustomStackIsEmpty() {
       Stack<String> stack = new Stack<>();
        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}




