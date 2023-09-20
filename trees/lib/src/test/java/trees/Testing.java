package trees;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Testing {

    @Test
    public void testEmptyTreeInstantiation() {
        BinarySearchTree tree = new BinarySearchTree();
        assertNull(tree.root);
    }

    @Test
    public void testSingleRootNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        assertNotNull(tree.root);
        assertEquals(5, tree.root.value);
    }

    @Test
    public void testAddLeftAndRightChild() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertNotNull(tree.root);
        assertEquals(5, tree.root.value);

        assertNotNull(tree.root.left);
        assertEquals(3, tree.root.left.value);

        assertNotNull(tree.root.right);
        assertEquals(7, tree.root.right.value);
    }

    @Test
    public void testPreOrderTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);

        List<Integer> result = tree.preOrder();
        assertEquals(List.of(5, 3, 2, 4, 7), result);
    }

    @Test
    public void testInOrderTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);

        List<Integer> result = tree.inOrder();
        assertEquals(List.of(2, 3, 4, 5, 7), result);
    }

    @Test
    public void testPostOrderTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);

        List<Integer> result = tree.postOrder();
        assertEquals(List.of(2, 4, 3, 7, 5), result);
    }

    @Test
    public void testContainsExistingValue() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertTrue(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
    }

    @Test
    public void testContainsNonExistingValue() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);

        assertFalse(tree.contains(2));
        assertFalse(tree.contains(8));
    }
    @Test
    public void testFindMaxValueEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();
        assertThrows(IllegalStateException.class, () -> tree.findMaxValue());
    }

    @Test
    public void testFindMaxValue() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(9);

        int maxValue = tree.findMaxValue();
        assertEquals(9, maxValue);
    }
    @Test
    public void testBreadthFirstTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);

        List<Integer> result = tree.breadthFirst();
        assertEquals(List.of(5, 3, 7, 2, 4), result);
    }
}

