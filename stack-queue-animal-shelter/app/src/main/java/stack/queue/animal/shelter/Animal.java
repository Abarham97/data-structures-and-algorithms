package stack.queue.animal.shelter;

public class Animal {

    String species;
    String name;
    int timestamp;
    public Animal(String species,String name){
        this.species = species;
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }
}
