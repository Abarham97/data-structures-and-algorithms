package linked.list.kth;

public class Testing {
    public static void main(String[] args) {
        testKthFromEndScenarios();
    }

    private static void testKthFromEndScenarios() {
        LinkedList linkedList = new LinkedList();
        linkedList.addToEnd(1);
        linkedList.addToEnd(3);
        linkedList.addToEnd(8);
        linkedList.addToEnd(2);

        System.out.println("Linked List: " + linkedList.toString());

        try {
            int result1 = linkedList.kthFromEnd(6);
            System.out.println("kthFromEnd(6): " + result1);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            int result2 = linkedList.kthFromEnd(3);
            System.out.println("kthFromEnd(3): " + result2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            int result3 = linkedList.kthFromEnd(-1);
            System.out.println("kthFromEnd(-1): " + result3);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            LinkedList singleNodeList = new LinkedList();
            singleNodeList.addToEnd(5);
            int result4 = singleNodeList.kthFromEnd(0);
            System.out.println("kthFromEnd(0) in singleNodeList: " + result4);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            int result5 = linkedList.kthFromEnd(1);
            System.out.println("kthFromEnd(1): " + result5);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
