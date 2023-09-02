package stack.and.queue;


import java.util.NoSuchElementException;

public class Queue<T> {
    Node <T> front;
    Node <T> rear;

    public Queue() {
        this.front = null;
        this.rear=null;
    }

    public boolean isEmpty(){

        return front==null;
    }

    public void enqueue(T value){
        Node node= new Node(value);
        if(!isEmpty())
        {
            rear.next = node;

        }
        else
        {

            front = node;
        }
        rear = node;


    }

    public T dequeue(){

        if(isEmpty())
        {

            throw new NoSuchElementException("Queue is empty");

        }

        T newFront= front.value;
       front =front.next;
       return newFront;

    }

    public T peek(){

        if(isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.value;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue { ");
        Node<T> current = front;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" }");
        return sb.toString();
    }

}
