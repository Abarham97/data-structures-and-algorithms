package queue.pseudo;

public class PseudoQueue <T> {
    public Stack<T> stack1;
    public  Stack<T> stack2;

    public PseudoQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void enqueue (T value){
        stack1.push(value);
    }
    public T dequeue(){
        if (isEmpty()){
            throw  new IllegalStateException("The PseduoQueue is Empty");
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
