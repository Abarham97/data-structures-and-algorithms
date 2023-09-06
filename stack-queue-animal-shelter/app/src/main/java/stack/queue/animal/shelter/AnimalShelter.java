package stack.queue.animal.shelter;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private Queue<Animal> dogQueue;
    private Queue <Animal> catQueue;
    private int timestamp;
    public AnimalShelter(){
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
        timestamp = 0 ;
    }
    public void enqueue(Animal animal) {
        animal.timestamp = timestamp++;
        if ("dog".equals(animal.species)) {
            dogQueue.offer(animal);
        } else if ("cat".equals(animal.species)) {
            catQueue.offer(animal);
        }
    }
    public Animal dequeue(String pref) {
        if ("dog".equals(pref) && !dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else if ("cat".equals(pref) && !catQueue.isEmpty()) {
            return catQueue.poll();
        } else if (!dogQueue.isEmpty()) {
            return dogQueue.poll();
        } else if (!catQueue.isEmpty()) {
            return catQueue.poll();
        } else {
            return null;
        }
    }
}
