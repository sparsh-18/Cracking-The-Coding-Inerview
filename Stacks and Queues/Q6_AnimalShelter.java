import java.util.LinkedList;

abstract class Animal {
    int time;
    String name;

    Animal(String name) {
        this.name = name;
    }

    public boolean isBefore(Animal x) {
        return time < x.time;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
}
public class Q6_AnimalShelter {
    int timeStamp = 0;

    LinkedList<Dog> d = new LinkedList<>();
    LinkedList<Cat> c = new LinkedList<>();

    public void add(Animal x) {
        x.time = timeStamp;
        timeStamp++;

        if (x instanceof Dog) d.addLast((Dog)x);
        else if (x instanceof Cat) c.addLast((Cat)x);
    }

    public void removeAny() {
        if (d.isEmpty()) {
            System.out.println(c.getFirst().name);
            c.removeFirst();
            System.exit(0);
        }

        if (c.isEmpty()) {
            System.out.println(d.getFirst().name);
            d.removeFirst();
            System.exit(0);
        }

        if (d.getFirst().isBefore(c.getFirst())) {
            System.out.println(d.getFirst().name);
            d.removeFirst();
        } else {
            System.out.println(c.getFirst().name);
            c.removeFirst();
        }
    }

    public void removeCat() {
        if (!c.isEmpty()) {
            System.out.println(c.getFirst().name);
            c.removeFirst();
        }
    }

    public void removeDog() {
        if (!d.isEmpty()) {
            System.out.println(d.getFirst().name);
            d.removeFirst();
        }
    }

    public static void main(String[] args) {
        Q6_AnimalShelter ob = new Q6_AnimalShelter();
        ob.add(new Dog("Tim"));
        ob.add(new Cat("Tom"));
        ob.add(new Cat("Jim"));
        ob.add(new Dog("Jim"));

        ob.removeAny();
        ob.removeCat();
        ob.removeDog();
    }
}
