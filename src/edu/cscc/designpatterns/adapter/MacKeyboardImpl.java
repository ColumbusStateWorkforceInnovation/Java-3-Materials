package edu.cscc.designpatterns.adapter;

public class MacKeyboardImpl implements MacKeyboard {
    @Override
    public void commandKey() {
        System.out.println("command");
    }

    @Override
    public void deleteKey() {
        System.out.println("delete");
    }

    @Override
    public void optionKey() {
        System.out.println("option");
    }
}
