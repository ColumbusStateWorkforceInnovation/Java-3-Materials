package edu.cscc.designpatterns.adapter;

public class Main {
    public static void main(String[] args) {
        PCKeyboard keyboard = new MacKeyboardAdapter(new MacKeyboardImpl());

        PCInterface pcInterface = new PCInterface(keyboard);

        pcInterface.controlKeyPressed();
        pcInterface.windowsKeyPressed();
        pcInterface.backspaceKeyPressed();
    }
}
