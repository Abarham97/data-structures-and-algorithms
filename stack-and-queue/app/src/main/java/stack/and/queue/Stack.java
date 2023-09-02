package stack.and.queue;

import java.util.EmptyStackException;

public class Stack <T>{

    Node <T> top;


    public Stack() {
        this.top = null;

    }

    public void Push(T value){

        Node node= new Node(value);

        if (!isEmpty()) {
            node.next = top;
        }
        top= node;

    }

    public T pop(){
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        T topValue =top.value;
        top=top.next;
        return  topValue;
    }

    public T peek(){
        if(isEmpty())
            throw new EmptyStackException();

        return top.value;

    }

    public boolean isEmpty(){

        return top==null;
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        SB.append("Stack { ");
        Node<T> current = top;
        while (current != null) {
            SB.append(current.value);
            if (current.next != null) {
                SB.append(" -> ");
            }
            current = current.next;
        }
        SB.append(" }");
        return SB.toString();
    }
}
