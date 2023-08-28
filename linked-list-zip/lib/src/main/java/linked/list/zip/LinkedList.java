package linked.list.zip;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }


    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public Node zipLists(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (list1 != null && list2 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;

            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }


}
