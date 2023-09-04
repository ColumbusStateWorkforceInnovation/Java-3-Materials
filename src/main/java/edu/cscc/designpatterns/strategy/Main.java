package edu.cscc.designpatterns.strategy;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", 20, new Sword());
        Character gandalf = new Character("Gandalf", 30, new Staff());

        frodo.attack(gandalf);

        gandalf.setWeapon(new Sword());
        gandalf.attack(frodo);
    }
}
