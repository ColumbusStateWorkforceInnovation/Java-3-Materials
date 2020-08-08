package edu.cscc.designpatterns.strategy;

public class Staff implements Weapon {

    private int damage;

    public Staff() {
        this.damage = 7;
    }

    @Override
    public void applyDamage(Character character) {
        character.takeDamage(damage);
    }
}
