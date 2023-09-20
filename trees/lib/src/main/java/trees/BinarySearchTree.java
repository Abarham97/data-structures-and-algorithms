package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree(){
        super();
    }
    public void add(int value){
        root = addRecursive (root, value);

    }
    private Node addRecursive(Node current, int value){
        if (current==null){
            return new Node(value);
        }
        if(value < current.value){
            current.left = addRecursive(current.left, value);
        } else if (value> current.value) {
            current.right = addRecursive(current.right, value);

        }
        return current;
    }
    public boolean contains(int value){
        return containRecursive(root,value);
    }
    private boolean containRecursive(Node current, int value){
        if (current == null){
            return false;
        }
        if (value==current.value){
            return true;
        }
        if(value<current.value){
            return containRecursive(current.left,value);
        }
        else {
            return containRecursive(current.right,value);
        }

    }
    public int findMaxValue() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMaxValueRecursive(root);
    }

    private int findMaxValueRecursive(Node current) {
        if (current.right == null) {
            return current.value;
        }
        return findMaxValueRecursive(current.right);
    }

    public List<Integer> breadthFirst() {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                result.add(current.value);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }
}
