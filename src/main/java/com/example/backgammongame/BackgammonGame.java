package com.example.backgammongame;

import java.util.List;

public class BackgammonGame {
    private GameBoard gameBoard;
    private Dice dice1;
    private Dice dice2;
    private Player player1;
    private Player player2;

    public BackgammonGame() {
        gameBoard = new GameBoard();
        dice1 = new Dice();
        dice2 = new Dice();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
    }

    public void start() {
        // Initialize the game state
        List<Piece> player1Pieces = player1.getPieces();
        List<Piece> player2Pieces = player2.getPieces();

        for (int i = 0; i < 15; i++) {
            player1Pieces.add(new Piece(player1, i));
            player2Pieces.add(new Piece(player2, 23 - i));
        }

        // Add the pieces to the game board
        for (Piece piece : player1Pieces) {
            gameBoard.addPiece(piece);
        }
        for (Piece piece : player2Pieces) {
            gameBoard.addPiece(piece);
        }

        while (true) {
            // Roll the dice
            dice1.roll();
            dice2.roll();

            // Determine which player's turn it is
            Player currentPlayer = player1;
            if (/* determine current player based on game state */) {
                currentPlayer = player2;
            }

            // Allow the current player to make a move
            boolean validMove = false;

            while (!validMove) {
                // Prompt the user to select a piece to move
                Piece selectedPiece = /* prompt user to select a piece */;

                // Check if the selected piece is owned by the current player
                if (selectedPiece.getOwner() == currentPlayer) {
                    // Calculate the destination position for the selected piece
                    int destination = selectedPiece.getPosition() + dice1.getValue() + dice2.getValue();

                    // Check if the destination is within the bounds of the board
                    if (destination >= 0 && destination < 24) {
                        // Check if the destination is occupied by an opponent's piece
                        Piece occupyingPiece = gameBoard.getPieceAtPosition(destination);
                        if (occupyingPiece == null || occupyingPiece.getOwner() != currentPlayer) {
                            // Remove the piece from its current position
                            gameBoard.removePiece(selectedPiece);

                            // Update the piece's position
                            selectedPiece.setPosition(destination);

                            // Add the piece to its new position
                            gameBoard.addPiece(selectedPiece);

                            // The move is valid
                            validMove = true;
                        }
                    }
                }
            }

// Update the game state based on the player's move
// Update the game state based on the player's move
            if (selectedPiece.getPosition() == 0) {
                // The piece has reached the end of the board and can be removed from play
                currentPlayer.removePiece(selectedPiece);
            } else if (occupyingPiece != null && occupyingPiece.getOwner() != currentPlayer) {
                // The destination position was occupied by an opponent's piece, so the opponent's piece is sent back to their starting position
                occupyingPiece.setPosition(/* starting position for opponent's pieces */);
                gameBoard.addPiece(occupyingPiece);
            }

// Check if the game is over
            if (player1.getPieces().isEmpty() || player2.getPieces().isEmpty()) {
                // One of the players has no more pieces, so the game is over
                break;
            }

// Check if the game is over
            if (/* game is over */) {
                break;
            }

        }


    }
}

        // Announce the winner

