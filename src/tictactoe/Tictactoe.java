 package tictactoe;

public class Tictactoe {
	
	public static void main (String[] args) {
		GameBoard myGame = new GameBoard();
		myGame.displayBoard();
		int counter = 1;
		
		while(myGame.gameActive()) 
		{
			if (counter % 2 == 0)
				myGame.askPlayer('O');
			else
				myGame.askPlayer('X');
			counter++;
			
			myGame.displayBoard();
			myGame.checkForWinner();
		}
	}
}
 	