package com.example.backgammongame;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Dice extends Label {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;
    private static final int FONT_SIZE = 30;

    private int value;

    public Dice() {
        setFont(new Font(FONT_SIZE));
        roll();
    }

    public void roll() {
        value = MIN_VALUE + (int)(Math.random() * ((MAX_VALUE - MIN_VALUE) + 1));
        setText(String.valueOf(value));
    }

    public int getValue() {
        return value;
    }
}
