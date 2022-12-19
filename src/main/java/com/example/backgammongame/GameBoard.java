package com.example.backgammongame;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameBoard extends GridPane {
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 4;
    private static final int SQUARE_SIZE = 50;

    private Rectangle[][] squares;

    public GameBoard() {
        squares = new Rectangle[NUM_ROWS][NUM_COLS];

        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                // Create a new square
                Rectangle square = new Rectangle(SQUARE_SIZE, SQUARE_SIZE);

                // Set the square's fill color based on its position
                if ((row + col) % 2 == 0) {
                    square.setFill(Color.WHITE);
                } else {
                    square.setFill(Color.BLACK);
                }

                // Add the square to the grid pane
                add(square, col, row);

                // Store a reference to the square
                squares[row][col] = square;
            }
        }
    }
}