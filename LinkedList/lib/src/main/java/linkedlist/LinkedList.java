package linkedlist;

public class LinkedList {
    Node Head;
public LinkedList (Node Head){
    this.Head = null;
}
public LinkedList(){}
    public void insert(int value){
    Node newNode = new Node(value);
    newNode.Next = Head;
    Head = newNode;
    }
    public boolean contain (int value ){
    Node current = Head;
    while (current != null ){
        if (current.value == value ){
            return true;
        }
        current = current.Next;
    }
    return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = Head;
        while (current!= null ){
            result.append("{").append(current.value).append("} ->");
            current = current.Next;
        }
        result.append("Null");
        return result.toString();
    }
}
