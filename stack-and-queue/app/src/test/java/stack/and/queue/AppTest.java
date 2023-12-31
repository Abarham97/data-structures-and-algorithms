/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package stack.and.queue;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

 @Test

    public void pushSingle(){
     //Arrange

     Stack<Integer> stack= new Stack<>();

     //act

     stack.Push(7);

     //Assert

     assertEquals("Stack { 7 }",stack.toString());


 }

 @Test
    public void pushMultiple(){

     Stack<Integer> stack= new Stack<>();

     stack.Push(8);
     stack.Push(9);
     stack.Push(10);

     assertEquals("Stack { 10 -> 9 -> 8 }",stack.toString());

 }

 @Test

    public void popSingle(){

     Stack<Integer> stack= new Stack<>();
     stack.Push(8);
     stack.Push(9);
     stack.Push(10);

     stack.pop();
     assertEquals("Stack { 9 -> 8 }",stack.toString());


 }

 @Test

 public void popMultiple(){

     Stack<Integer> stack= new Stack<>();
     stack.Push(8);
     stack.Push(9);
     stack.Push(10);

     stack.pop();
     stack.pop();
     stack.pop();
     assertTrue(stack.isEmpty());


 }

 @Test
    public void stackPeek(){

     Stack<Integer> stack= new Stack<>();
     stack.Push(8);
     stack.Push(9);
     stack.Push(10);
     stack.peek();
     assertEquals(10,stack.peek());
 }

 @Test
    public void instantiateStack(){

     Stack<Integer> stack= new Stack<>();

     assertTrue(stack.isEmpty());

 }

 @Test

    public void popPeekEmpty(){
     Stack<Integer> stack= new Stack<>();

 assertThrows(EmptyStackException.class, stack::peek);
 }

 @Test

    public void enqueueSingle(){

     Queue<Integer> queue= new Queue<>();

     queue.enqueue(8);

     assertEquals("Queue { 8 }",queue.toString());

 }

 @Test

 public void enqueueMultiple(){

     Queue<Integer> queue= new Queue<>();

     queue.enqueue(8);
     queue.enqueue(9);
     queue.enqueue(10);

     assertEquals("Queue { 8 -> 9 -> 10 }",queue.toString());

 }

 @Test

    public  void dequeueSingle(){
     Queue<Integer> queue= new Queue<>();
     queue.enqueue(8);
     queue.enqueue(9);
     queue.enqueue(10);
     queue.dequeue();

assertEquals("Queue { 9 -> 10 }",queue.toString());


 }

 @Test
    public  void peekQueue(){
     Queue<Integer> queue= new Queue<>();
     queue.enqueue(8);
     queue.enqueue(9);
     queue.enqueue(10);
     queue.peek();
     assertEquals(8,queue.peek());

 }

 @Test
    public void multipleDequeues(){
     Queue<Integer> queue= new Queue<>();
     queue.enqueue(8);
     queue.enqueue(9);
     queue.enqueue(10);
     queue.dequeue();
     queue.dequeue();
     queue.dequeue();

     assertTrue(queue.isEmpty());

 }

 @Test
    public void emptyQueue(){
     Queue<Integer> queue= new Queue<>();
     assertTrue(queue.isEmpty());
 }

@Test

    public void dequeuePeekEmpty(){

    Queue<Integer> queue= new Queue<>();
    assertThrows(NoSuchElementException.class, queue::peek);

}


}
