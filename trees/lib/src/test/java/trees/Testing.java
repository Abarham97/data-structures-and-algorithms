package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    private BinaryTree tree;

    @BeforeEach
    public void setUp() {

        tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.right.left = new Node(12);
        tree.root.right.right = new Node(18);
    }

    @Test
    public void testPreOrderTraversal() {
        List<Integer> result = tree.preOrder();
        assertArrayEquals(new Integer[]{10, 5, 3, 7, 15, 12, 18}, result.toArray());
    }

    @Test
    public void testInOrderTraversal() {
        List<Integer> result = tree.inOrder();
        assertArrayEquals(new Integer[]{3, 5, 7, 10, 12, 15, 18}, result.toArray());
    }

    @Test
    public void testPostOrderTraversal() {
        List<Integer> result = tree.postOrder();
        assertArrayEquals(new Integer[]{3, 7, 5, 12, 18, 15, 10}, result.toArray());
    }

    @Test
    public void testFindMaxValue() {
        int maxValue = tree.findMaxValue();
        assertEquals(18, maxValue);
    }
}