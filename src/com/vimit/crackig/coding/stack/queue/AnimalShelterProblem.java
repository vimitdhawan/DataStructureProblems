package com.vimit.crackig.coding.stack.queue;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class AnimalShelterProblem{
    public static void main(String[] args) {
        Animal a1 = new Animal("Tommy", Type.DOG, LocalDateTime.now());
        AnimalShelter shelter = new AnimalShelter();
        Animal a2 = new Animal("Meow", Type.CAT, LocalDateTime.now());
        shelter.enqueue(a1);
        shelter.enqueue( a2);
        shelter.enqueue(new Animal("Meow1", Type.CAT, LocalDateTime.now()));
        shelter.enqueue( new Animal("Tommy1", Type.DOG, LocalDateTime.now()));
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueCats());
        System.out.println(shelter.dequeueAny());
    }
}

class AnimalShelter {
    private LinkedList<Animal> dogs = new LinkedList<>();
    private LinkedList<Animal> cats = new LinkedList<>();

    public void enqueue(Animal animal) {
        if ( animal.type.equals(Type.DOG) ) {
            dogs.addLast(animal);
        } else if(animal.type.equals(Type.CAT)){
            cats.addLast(animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        }
        if (dogs.size() == 0) {
            return dequeueCats();
        }
        if (cats.size() == 0) {
            return dequeueDogs();
        }
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Animal dequeueDogs() {
        return dogs.poll();
    }

    public Animal dequeueCats() {
        return cats.poll();
    }
}


class Animal {
    String name;
    Type type;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", dateTime=" + dateTime +
                '}';
    }

    LocalDateTime dateTime;
    Animal(String name, Type type,  LocalDateTime dateTime){
        this.name = name;
        this.type = type;
        this.dateTime = dateTime;
    }

    public boolean isOlderThan(Animal cat) {
       return this.dateTime.isBefore(cat.dateTime);
    }
}
enum Type {DOG, CAT}

