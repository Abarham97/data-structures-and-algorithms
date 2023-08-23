package linked.list.kth;


public class linkedListKth {
    class Node {
        int data;
        Node next;


        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }
    Node head;







    public int kthFromEnd(int k) {
        Node current = head;
        int count=0;
        int value=0;
        while(current != null)
        {
            current=current.next;
            count++;

        }

        if (count <k)
            throw new IllegalArgumentException("K is greater than list length ");

        else   if(k<0)
            throw new IllegalArgumentException("K is Negative value  ");

        else   if(k==count)
            value=current.data;

        else if (count > k) {
            current = head;
            for (int i =1 ; i < count - k; i++) {
                value=current.data;
                current = current.next;



            }
        }









        return value;

    }

    public void insert(int newValue) {
        Node newNode = new Node(newValue);
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("head - >");
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" -> ");
            current = current.next;
        }
        result.append("X");
        return result.toString();
    }




}