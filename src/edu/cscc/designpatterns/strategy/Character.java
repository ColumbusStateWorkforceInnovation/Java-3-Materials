package edu.cscc.designpatterns.strategy;

public class Character {
    private String name;
    private int health;
    private Weapon weapon;

    public Character(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(Character target) {
        weapon.applyDamage(target);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    //More of the Character class...
}
