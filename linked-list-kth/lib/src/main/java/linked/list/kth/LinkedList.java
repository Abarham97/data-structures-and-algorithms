package linked.list.kth;



class Node {
    int value;
    Node next;

    public Node (int value){
        this.value = value;
        this.next= null;
    }
}

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToEnd(int value) {
        Node newNode = new Node(value);
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

    public int kthFromEnd(int k) {
        if (head == null || k < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new IllegalArgumentException("Value of k is greater than the list length");
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("X");
        return sb.toString();
    }
}
