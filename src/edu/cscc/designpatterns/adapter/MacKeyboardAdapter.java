package edu.cscc.designpatterns.adapter;

public class MacKeyboardAdapter implements PCKeyboard {

    private final MacKeyboard macKeyboard;

    public MacKeyboardAdapter(MacKeyboard macKeyboard) {
        this.macKeyboard = macKeyboard;
    }

    @Override
    public void controlKey() {
        macKeyboard.commandKey();
    }

    @Override
    public void backspaceKey() {
        macKeyboard.deleteKey();
    }

    @Override
    public void windowsKey() {
        macKeyboard.optionKey();
    }
}
