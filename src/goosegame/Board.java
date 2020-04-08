package goosegame;

/**
 * A class to represent the board of the goose game.
 * The board has the all the cells of the game.
 */

public abstract class Board {
	
	/* the number of cells of the board*/
	protected int nbOfCells;
	
	/* the cells of the board */
	protected Cell[] theCells;
	
	/** builds a board with an initial number of cells
	 * @param nbOfCells is the number of cells wanted
	 */
	public Board (int nbOfCells) {
		this.nbOfCells = nbOfCells;
	}
	
	/** builds the board according to the board wanted*/
	public abstract void initBoard();
	
	/** get the cells of the board */
	public Cell[] getCells() {
		return this.theCells;
	}
	
	/** set the cells of the board
	 * @param cells are the cells we want to set
	 */
	public void setTheCells(Cell[] cells) {
		this.theCells = cells;
	}
	
	/** get a specific cell in the board
	 * @param number is the position of the cell wanted
	 */
	public Cell getCell(int number) {
		return this.getCells()[number];
	}
	
	/** get the number of cells of the board
	 */
	public int getNbOfCells() {
		return this.nbOfCells;
	}
	

}