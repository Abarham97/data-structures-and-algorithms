package tree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FizzBuzzTreeTest {
    @Test
    void testFizzBuzzTree() {

        TreeNode root = new TreeNode("FizzBuzz");
        root.children.add(new TreeNode("Fizz"));
        root.children.add(new TreeNode("Buzz"));
        root.children.add(new TreeNode("7"));


        FizzBuzzTree fbTree = new FizzBuzzTree();
        TreeNode newRoot = fbTree.fizzBuzzTree(root);


        assertEquals("FizzBuzz", newRoot.value);
        assertEquals("Fizz", newRoot.children.get(0).value);
        assertEquals("Buzz", newRoot.children.get(1).value);
        assertEquals("7", newRoot.children.get(2).value);
    }
}
