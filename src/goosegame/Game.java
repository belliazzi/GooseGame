package goosegame;

import java.util.*;

public class Game {
	
	private List<Player> thePlayers = new ArrayList<Player>();
	
	private Board board;
	
	private boolean gameFinished;
	private boolean gameStart;
	
	/* Constructor for Game */
	public Game (Board iniBoard) {
		this.board = iniBoard;
		this.thePlayers = new ArrayList<Player> ();
		this.gameFinished = false;
	}
	
	/** Check if the game is finished
	 * @return true if the game is finished
	 */
	public boolean getGameFinished() {
		return this.gameFinished;
	}
	
	/** Changes the status of the game
	 * @param b is the status to set
	 */
	public void setGameFinished(boolean b) {
		this.gameFinished = b;
	}
	
	/** Get the current board
	 * @return the board
	 */
	public Board getBoard() {
		return this.board;
	}
	
	/** Add a player in the game and assigns him to the first cell
	 * @param p is the new player to add
	 */
	public void addPlayer(Player p) {
		this.thePlayers.add(p);
		this.getBoard().getCells()[0].setPlayer(p);
	}
	
	
	
	public List<Player> getThePlayers() {
		return thePlayers;
	}

	public void setThePlayers(List<Player> thePlayers) {
		this.thePlayers = thePlayers;
	}
	
	

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public void playOneTime(){
		
		int boardSize = this.getBoard().getNbOfCells() - 1;
		
		/* For each player we are going to throw the dice */
		oneRound:
		for (Player p : thePlayers) {
			
			/*We check if the player can leave the cell */
			if (p.getCell().canBeLeft()) {
				
				int result = p.twoDiceThrow();
				
				/* Compute the new index of the player */
				int currentIndex = p.getCell().getIndex();
				int interIndex = currentIndex + result;
				int intermediateIndex;
				int destinationIndex;
				
				/* If the player is not out of the board */
				if (interIndex < boardSize + 1) {
					intermediateIndex = interIndex;
					destinationIndex = this.getBoard().getCell(intermediateIndex).handleMove(result);
				} else {
					intermediateIndex = boardSize - (result - (boardSize - currentIndex));
					destinationIndex = intermediateIndex;
				}
				
				/* gives the status of the player */
				System.out.print(p.toString() + " in in cell " +currentIndex +".");
				System.out.println(" He throws " +result + " and reaches the cell " +intermediateIndex +".");
				
				Cell destinationCell = this.getBoard().getCell(destinationIndex);
								
				destinationCell.welcomePlayer(p);
				p.setCell(destinationCell);
				this.getBoard().getCell(destinationIndex).setPlayer(p);
				
				/* Check if there is a winner */
				if (destinationIndex == boardSize) {
					System.out.println(p.toString() + " is in cell " +destinationIndex
							+" which is the final cell. He wins !");
					this.setGameFinished(true);
					break oneRound;
				}
			} else {
				p.getCell().letOneTurnGo();
			}
			
		}
		
	}
	
	
	public void playManyTimes(int Nmax) {
		int i = 0;
		while (i < Nmax & !this.getGameFinished()) {
			System.out.println("Round " +i);
			this.playOneTime();
			i++;
		}
	}

}
