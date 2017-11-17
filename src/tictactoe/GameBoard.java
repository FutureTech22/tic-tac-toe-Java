package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	private char[ ][ ] gameBoard; 
	private boolean gameOnGoing = true;
	private Scanner keyboard;
	
	public GameBoard() 
	{
		gameBoard = new char[3][3]; 						   //building the game board constructor class 
		
		for(int row = 0;  row < gameBoard.length; row++)    // fill each row in the array with
		{												   // an empty space
			Arrays.fill(gameBoard[row], ' ');			  
		}
	} // end constructor
	
	
	//this method will display the game board to the screen
	public void displayBoard()
	{
		for (int row=0; row < gameBoard.length; row++) {			//drawing the lines for each row and 
			for (int col=0; col < gameBoard[0].length; col++) {	//column of the game board array
				System.out.print("\t"+gameBoard[row][col]);		
				if (col==0 || col == 1)
					System.out.print("|");
			}
		if(row == 0 || row ==1 )
			System.out.print("\n-----------------------------\n"); 
		}
	} 
	// end of game board display method
	
	//This method will return true if the variable is active
	
	public boolean gameActive() {
		return gameOnGoing;
	}
	
	//this method will ask the user to pick a row and column, 
	//validate the inputs and call the method makeMove
	
	public boolean askPlayer(char player) 
	{
			Scanner keyboard = new Scanner(System.in);
					int row, col;
			do
			{
				System.out.println("\n");
				System.out.print("Player %'s please enter a row (1-3) :") ;
				row = keyboard.nextInt();
				
				
				System.out.print("Player %'s please enter a column (1-3) :");
				col = keyboard.nextInt();
				
			} while (notValid(row, col));
			
			return makeMove(player,row-1 ,col-1);
	} // end of ask player method
	
	//this method will validate if the players move is between 1-3
	
	public boolean notValid(int row, int col)
	{
		if (row > 3 || row < 1)
			return true;
		if (col > 3 || col < 1)
			return true;	
		return false;
	}
	
	//this method will validate if the players move is allowed and return true if the move is valid
	
	public boolean makeMove(char player,int row,int col) 
	{
		if(row >= 0 && row <= 2 && col >=0 && col <= 2)  //if move is within the array
		{
				if (gameBoard[row][col] != ' ')	//if game board position does not equal empty space
					return false;  
				else 
				{
					gameBoard[row][col] = player; 
					return true;
				}
			}
			else 
				return false;
		} //end of make move method		
}