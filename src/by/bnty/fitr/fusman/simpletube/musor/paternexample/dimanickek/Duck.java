package by.bnty.fitr.fusman.simpletube.musor.paternexample.dimanickek;

public class Duck {
    private Flying flying;

    public Duck(Flying flying) {
        this.flying = flying;
    }

    public static void main(String[] args) {
        Duck duck = new Duck(new NoFly());
        duck.fly();
        duck.setFlying(new Fly());
        duck.fly();
    }

    public void setFlying(Flying flying) {
        this.flying = flying;
    }

    public void fly() {
        flying.fly();
    }
}
