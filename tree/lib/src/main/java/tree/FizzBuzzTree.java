package tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String value;
    List<TreeNode> children;

    TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
public class FizzBuzzTree {
    public TreeNode fizzBuzzTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(getFizzBuzzValue(root.value));

        for (TreeNode child : root.children) {
            newRoot.children.add(fizzBuzzTree(child));
        }

        return newRoot;
    }

    private String getFizzBuzzValue(String value) {
        if ("FizzBuzz".equals(value)) {
            return "FizzBuzz";
        } else if ("Fizz".equals(value)) {
            return "Fizz";
        } else if ("Buzz".equals(value)) {
            return "Buzz";
        } else {
            try {
                int intValue = Integer.parseInt(value);
                if (intValue % 3 == 0 && intValue % 5 == 0) {
                    return "FizzBuzz";
                } else if (intValue % 3 == 0) {
                    return "Fizz";
                } else if (intValue % 5 == 0) {
                    return "Buzz";
                } else {
                    return String.valueOf(intValue);
                }
            } catch (NumberFormatException e) {

                return value;
            }
        }
    }
}




