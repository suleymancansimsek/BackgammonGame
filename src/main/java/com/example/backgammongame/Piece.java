package com.example.backgammongame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece extends Circle {
    private Player owner;
    private int position;

    public Piece(Player owner, int position) {
        this.owner = owner;
        this.position = position;
        setRadius(15);
        setFill(owner.getName().equals("Player 1") ? Color.RED : Color.BLUE);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
