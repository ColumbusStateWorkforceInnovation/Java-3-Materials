package edu.cscc.designpatterns.strategy;

public class Sword implements Weapon {

    private int damage;

    public Sword() {
        this.damage = 10;
    }

    @Override
    public void applyDamage(Character character) {
        if (isSkeleton(character)) {
            character.takeDamage(damage / 2);
        }
    }

    private boolean isSkeleton(Character character) {
        //Logic for determining if a Character
        // is a skeleton.
        return true;
    }
}