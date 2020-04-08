package goosegame;

public class OriginalBoard extends Board {
	
	/* Constructor for the original board */
	public OriginalBoard() {
		super(64);
	}
	
	/* Initiate the original board */
	public void initBoard(){
		Cell[] myCells = new Cell[64];
		
		myCells[0] = new ZeroCell(0);
		
		for (int i = 1; i < 64; i++) {
			myCells [i] = new RegularCell(i);
		}
		
		int[] gooseCells = {9, 18, 27, 36, 45, 54};
		
		for (int i : gooseCells) {
			myCells [i] = new GooseCell(i);
		}
		
		myCells[19] = new WaitingCell(19,2);
		
		myCells[31] = new TrapCell(31);
		myCells[52] = new TrapCell(52);
		
		myCells[6] = new TeleportCell(6);
		myCells[42] = new TeleportCell(42);
		myCells[58] = new TeleportCell(58);
		
		this.setTheCells(myCells);
	}

}
