import java.util.Scanner;

/**
 * A basic Game class that allows two users to play
 * tic tac toe. This is a cleaned up version of what
 * we did in class, with the final three win 
 * condition checkers completed.
 * 
 * It does not handle non-numeric input, and will 
 * crash with an InputMismatchException if the user
 * attempts it.
 * 
 * @author Heath Carroll for CSCE 146, Fall 2013
 */
public class TicTacToe {
	private static final int ROWS = 3;
	private static final int COLS = 3;
	public static Cell[] board;
	boolean isPlayerX = true;
	byte moveCounter = 0;
	
	/**
	 * No-args constructor.
	 */
	public TicTacToe() {
		board = new Cell[ROWS * COLS];
		initBoard();
	}
	
	/**
	 * Helper that initializes the board
	 * for playing. It creates all of the cells
	 * and assigns them an index number.
	 * Also, resets the moveCounter to 0 for
	 * subsequent play throughs.
	 */
	private void initBoard() {
		moveCounter = 0;
		int index;
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				index = row * COLS + col;
				board[index] = new Cell((byte)index);
			}
		}
	}
	
	/**
	 * Custom method providing us the ability to 
	 * print a rudimentary version of the board to
	 * the Console.
	 */
	@Override
	public String toString() {
		String output = "|---|---|---|\n";
		
		for(int row = 0; row < ROWS; row++) {
			output += "|";
			for(int col = 0; col < COLS; col++) {
				output += " " + board[row * COLS + col].player + " |"; 
			}
			output += "\n|---|---|---|\n";
		}
		
		return output;
	}
	
	/**
	 * Where the actual game play occurs.
	 * 
	 * @return
	 */
	public boolean play() {
		Scanner kb = new Scanner(System.in);
		
		boolean isActive = true;
		
		while(isActive) {
			
			System.out.println(this);
			
			letPlayerChoose(kb);
			
			isActive = checkForWinCondition();
			
			isPlayerX = !isPlayerX; // switch players
		}
		
		return playAgain(kb);	
	}
	
	/**
	 * Helper providing the player with the 
	 * ability to choose one of the cells. It keeps
	 * asking until the player selects a valid cell.
	 * @param kb
	 */
	private void letPlayerChoose(Scanner kb) {
		int cellChoice;
		boolean isValidChoice = false;
		
		while(!isValidChoice) {
			if(isPlayerX) System.out.println("Player X, make your move...");
			else System.out.println("Player O, make your move...");
	
			System.out.print("Enter one of the available indices: ");
			cellChoice = kb.nextInt() - 1;
			if(isValidChoice = validateInput(cellChoice)) {
				board[cellChoice].move(isPlayerX);
				moveCounter++;
			}

			if(!isValidChoice) System.out.println("WRONG!!! try again...");
		}
	}
	
	/**
	 * Helper for .letPlayerChoose() method. It
	 * evaluates the players choice for validity and 
	 * returns true if the choice should be allowed.
	 * @param choice
	 * @return
	 */
	private boolean validateInput(int choice) {
		boolean output = true;

		if(!(choice >= 0 && choice <= 8)) output = false; 
		else if(board[choice].isTaken) output = false;
		
		return output;
	}
	
	/**
	 * Helper for .play() method. It checks
	 * to see if the current player just won the game
	 * with the last move. It also will inform the 
	 * users that the game was a draw if the last cell
	 * was taken, but there is no winner.
	 * 
	 * @return
	 */
	private boolean checkForWinCondition() {
		boolean output = true;
		
		if(didPlayerWin(isPlayerX)) output = false;
		else if(moveCounter == 9) {
			System.out.println("It is a DRAW!");
			output = false;
		}
		
		return output;
	}
	
	/**
	 * Helper for .play() method. Checks to see 
	 * if the current player has won along any of
	 * the winning paths. Will print a winning 
	 * message if so.
	 * 
	 * @param isPlayerX
	 * @return
	 */
	private boolean didPlayerWin(boolean isPlayerX) {
		boolean didWin = false;
		
		if(didWin = checkCols(isPlayerX) || 
					checkRows(isPlayerX) || 
					checkForwardDiag(isPlayerX) || 
					checkBackwardDiag(isPlayerX)) {
			
			System.out.print("CONGRATULATIONS PLAYER ");
			if(isPlayerX) System.out.println("X");
			else System.out.println("O");
		}
		
		return didWin;
	}
	
	/**
	 * Helper for .play() method. Queries the 
	 * users if they want to play again, and resets 
	 * the board if they do.
	 * 
	 * @param kb
	 * @return
	 */
	private boolean playAgain(Scanner kb) {
		boolean output = false;
		
		System.out.println(this);
		System.out.print("Would you like to play again?");
		String query = kb.next().trim().toUpperCase();
		if(output = query.equals("YES") || query.equals("Y")) {
			initBoard();
		}
		
		return output;

	}
	
	/**
	 * Helper for didPlayerWin() method. Checks
	 * to see if the current player has a win condition 
	 * along any column.
	 * 
	 * @param isPlayerX
	 * @return
	 */
	private boolean checkCols(boolean isPlayerX) {
		boolean didWin = false;
		char currentPlayer;
		if(isPlayerX) currentPlayer = 'X';
		else currentPlayer = 'O';
	
		for(int col = 0; col < COLS; col++) {
			if(board[col].player == currentPlayer &&
			   board[ROWS + col].player == currentPlayer &&
			   board[2*ROWS + col].player == currentPlayer) {
				didWin = true;
			}
		}
		
		return didWin;
	}
	
	/**
	 * Helper for didPlayerWin() method. Checks
	 * to see if the current player has a win condition 
	 * along any row.
	 * 
	 * @param isPlayerX
	 * @return
	 */
	private boolean checkRows(boolean isPlayerX) {
		boolean didWin = false;
		char currentPlayer;
		if(isPlayerX) currentPlayer = 'X';
		else currentPlayer = 'O';
	
		for(int row = 0; row < ROWS; row++) {
			if(board[row * ROWS].player == currentPlayer &&
			   board[row * ROWS + 1].player == currentPlayer &&
			   board[row * ROWS + 2].player == currentPlayer) {
				didWin = true;
			}
		}
		
		return didWin;
	}
	
	/**
	 * Helper for didPlayerWin() method. Checks
	 * to see if the current player has a win condition 
	 * along the forward diagonal.
	 * 
	 * @param isPlayerX
	 * @return
	 */
	private boolean checkForwardDiag(boolean isPlayerX) {
		boolean didWin = false;
		char currentPlayer;
		if(isPlayerX) currentPlayer = 'X';
		else currentPlayer = 'O';
	
		if(board[2 * ROWS].player == currentPlayer &&
		   board[1 * ROWS + 1].player == currentPlayer &&
		   board[2].player == currentPlayer) {
			
			didWin = true;
		}
	
		return didWin;
	}
	
	/**
	 * Helper for didPlayerWin() method. Checks
	 * to see if the current player has a win condition 
	 * along the backward diagonal.
	 * 
	 * @param isPlayerX
	 * @return
	 */
	private boolean checkBackwardDiag(boolean isPlayerX) {
		boolean didWin = false;
		char currentPlayer;
		if(isPlayerX) currentPlayer = 'X';
		else currentPlayer = 'O';
	
		if(board[0].player == currentPlayer &&
		   board[1 * ROWS + 1].player == currentPlayer &&
		   board[2 * ROWS + 2].player == currentPlayer) {
			
			didWin = true;
		}
	
		return didWin;
	}

	/**
	 * Node-like class that allows us to keep track 
	 * of individual grid locations and their status.
	 * These nodes have no information about other nodes
	 * in the data structure.
	 * 
	 * @author Heath Carroll
	 */
	private class Cell {
		char player = '*';
		byte index;
		boolean isTaken = false;
		
		public Cell(byte index) {
			this.index = index;
			this.player = (char)(index + 49);
		}
		
		public void move(boolean isPlayerX) {
			if(isPlayerX) this.player = 'X';
			else this.player = 'O';
			
			this.isTaken = true;
		}
	}
	
	/**
	 * The Entry Point for our program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		while(game.play());

		System.out.println("THANKS FOR PLAYING");
	}
}
