package edu.cscc.designpatterns.adapter;

public class PCInterface {

    private PCKeyboard pcKeyboard;

    public PCInterface(PCKeyboard pcKeyboard) {
        this.pcKeyboard = pcKeyboard;
    }

    public void controlKeyPressed() {
        pcKeyboard.controlKey();
    }

    public void windowsKeyPressed() {
        pcKeyboard.windowsKey();
    }

    public void backspaceKeyPressed() {
        pcKeyboard.backspaceKey();
    }
}
