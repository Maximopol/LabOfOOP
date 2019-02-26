package by.bnty.fitr.fusman.lab10.tank;

import java.util.Random;

public class Tank {
    private final static int COEFFICIENT_DAMAGE = 4;
    private final static int COEFFICIENT_DEFENCE = 3;
    private String name;
    private int health;
    private int damage;
    private int armor;
    private int caliber;

    public Tank() {
    }

    public Tank(int i) {
    }

    public Tank(Tank tank) {
        damage = tank.damage;
        armor = tank.armor;
        caliber = tank.caliber;
        name = tank.name;
        health = tank.health;
    }

    public void attack(Tank enemy) {
//        int totalDamage = damage;
//        if (new Random().nextBoolean()) {
//            totalDamage += damage / COEFFICIENT_DAMAGE;
//        }

        enemy.protection(new Random().nextBoolean() ? damage : damage / COEFFICIENT_DAMAGE + damage, this.caliber);
    }

    private void protection(int damage, int caliber) {
        if (caliber * COEFFICIENT_DEFENCE > armor) {
            health -= damage;
        }
    }

    public void update() {

    }

    public void move() {
    }


    public String toSting() {
        return "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setCaliber(int caliber) {
        this.caliber = caliber;
    }
}
