package tree.intersection;


import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class TreeIntersection {
    public static Set<Integer> treeIntersection(TreeNode tree1, TreeNode tree2) {
        Set<Integer> set1 = buildHashSet(tree1);

        Set<Integer> commonValues = findCommonValues(tree2, set1);

        return commonValues;
    }

    public static Set<Integer> buildHashSet(TreeNode node) {
        Set<Integer> set = new HashSet<>();
        buildHashSetRecursive(node, set);
        return set;
    }

    public static void buildHashSetRecursive(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        buildHashSetRecursive(node.left, set);
        buildHashSetRecursive(node.right, set);
    }

    public static Set<Integer> findCommonValues(TreeNode node, Set<Integer> set) {
        Set<Integer> commonValues = new HashSet<>();
        findCommonValuesRecursive(node, set, commonValues);
        return commonValues;
    }

    private static void findCommonValuesRecursive(TreeNode node, Set<Integer> set, Set<Integer> commonValues) {
        if (node == null) {
            return;
        }
        if (set.contains(node.val)) {
            commonValues.add(node.val);
        }
        findCommonValuesRecursive(node.left, set, commonValues);
        findCommonValuesRecursive(node.right, set, commonValues);
    }
}

