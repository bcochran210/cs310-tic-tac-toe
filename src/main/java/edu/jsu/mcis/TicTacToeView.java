package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */
        
        // INSERT YOUR CODE HERE

        String[] playerCord;
        int row, col;

        if(isXTurn){
            System.out.println("Player 1 (X) Move: ");         
        } else {
            System.out.println("Player 2 (O) Move: ");
        }
        
        System.out.print("Enter the row and column numbers, seperated by a space: ");
        playerCord = keyboard.nextLine().split(" ");
        row = Integer.parseInt(playerCord[0]);
        col = Integer.parseInt(playerCord[1]);
        
        TicTacToeMove move = new TicTacToeMove(row, col);

        return move;
        //return null; // remove this line later!

    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
