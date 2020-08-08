package edu.cscc.designpatterns.factory;

public class Main {

    public static void main(String[] args) {
        DuckFactory duckFactory = new DuckFactory();

        Duck mallard = duckFactory.makeDuck("mallard");
        System.out.println(mallard.quack());

        Duck rubberDuck = duckFactory.makeDuck("rubber");
        System.out.println(rubberDuck.quack());

        Duck daffy = duckFactory.makeDuck("daffy");
        System.out.println(daffy.quack());

        Duck robotic = duckFactory.makeDuck("robot");
        System.out.println(robotic.quack());
    }
}
