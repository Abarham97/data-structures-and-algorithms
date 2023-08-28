package linked.list.zip;

public class TestLinkedList {
    public static void main(String[] args) {
        testZipLists();
    }

    public static void testZipLists() {
        LinkedList linkedList = new LinkedList();

        // Test case 1: Zipping two empty lists
        Node result1 = linkedList.zipLists(null, null);
        printList(result1);  // Expected: null

        // Test case 2: Zipping one empty list with a non-empty list
        Node list2 = createLinkedList(new int[]{2, 4, 6});
        Node result2 = linkedList.zipLists(null, list2);
        printList(result2);  // Expected: 2 -> 4 -> 6 -> null

        // Test case 3: Zipping two non-empty lists of equal length
        Node list3 = createLinkedList(new int[]{1, 3, 5});
        Node result3 = linkedList.zipLists(list2, list3);
        printList(result3);  // Expected: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> null

        // Test case 4: Zipping two non-empty lists of different lengths
        Node list4 = createLinkedList(new int[]{7, 8, 9});
        Node result4 = linkedList.zipLists(list3, list4);
        printList(result4);  // Expected: 1 -> 7 -> 3 -> 8 -> 5 -> 9 -> null
    }

    public static Node createLinkedList(int[] values) {
        LinkedList list = new LinkedList();
        for (int value : values) {
            list.insert(value);
        }
        return list.head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

