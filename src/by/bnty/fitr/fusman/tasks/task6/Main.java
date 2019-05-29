package by.bnty.fitr.fusman.tasks.task6;

public class Main {
    public static void main(String[] args) {
        Park2 park = Park2.getInstance();

        for (int i = 0; i < 55; i++) {
            new Car("" + i, park);
        }


        //  TimeUnit.SECONDS.sleep(1);
        //java.util.concurrent class Lock
    }
}
