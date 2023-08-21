package linked.list.insertions;

public class LinkedList {

    Node head;

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAfter(int prevValue, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.data == prevValue) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    public void insertBefore(int value, int newValue) {
        Node newNode = new Node(newValue);

        if (head == null) {
            head = newNode;
            return;
        }

        if (head.data == value) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }

    public String printList() {
        if (head == null) {
            return "head -> X";
        }

        StringBuilder result = new StringBuilder("head -> ");
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        result.append("X");
        return result.toString();
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
