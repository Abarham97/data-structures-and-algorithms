package tree.intersection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Set;

public class treeIntersectionTest {

    @Test
    public void testBuildHashSet() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        Set<Integer> set1 = TreeIntersection.buildHashSet(tree1);

        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    public void testFindCommonValues() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        Set<Integer> set1 = TreeIntersection.buildHashSet(tree1);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(5);
        tree2.right = new TreeNode(6);

        Set<Integer> commonValues = TreeIntersection.findCommonValues(tree2, set1);

        assertTrue(commonValues.contains(3));
    }

    @Test
    public void testTreeIntersection() {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(5);
        tree2.right = new TreeNode(6);

        Set<Integer> commonValues = TreeIntersection.treeIntersection(tree1, tree2);

        assertTrue(commonValues.contains(3));
    }
}

