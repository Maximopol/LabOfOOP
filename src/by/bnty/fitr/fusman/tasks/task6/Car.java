package by.bnty.fitr.fusman.tasks.task6;

public class Car implements Runnable {
    private Park2 park;
    private String name;

    public Car(String name, Park2 park) {
        this.name = name;
        this.park = park;
        new Thread(this).start();
    }

    public void run() {
        park.add(this);
        //  park.go(this);
    }

    public String toString() {
        return "Car{}" + name + "  " + hashCode();
    }
}
