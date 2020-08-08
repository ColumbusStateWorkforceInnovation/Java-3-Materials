package edu.cscc.designpatterns.singleton;

public class Main {

    public static void main(String[] args) {
        Library library = Library.getInstance();
        System.out.println("Hash code for the first library: " + library.hashCode());
        Library library2 = Library.getInstance();
        System.out.println("Hash code for the second library: " + library2.hashCode());
    }
}
