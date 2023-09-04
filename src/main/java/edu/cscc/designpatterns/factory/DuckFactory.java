package edu.cscc.designpatterns.factory;

public class DuckFactory {

    public Duck makeDuck(String type) {
        if ("mallard".equals(type)) {
            return new Mallard();
        } else if ("rubber".equals(type)) {
            return new RubberDuck();
        } else if ("daffy".equals(type)) {
            return new Daffy();
        } else if ("robot".equals(type)) {
            RoboticDuck roboticDuck =
                    new RoboticDuck(
                            new Wings(),
                            new Bill(),
                            new WebbedFeet(),
                            "Green");
            return roboticDuck;
        }

        throw new IllegalArgumentException("Could not create Duck for " + type);
    }
}
