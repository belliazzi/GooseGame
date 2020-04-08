package goosegame;

public class WaitingCell implements Cell {
	
	/* the index of the cell */
	protected int index;
	
	/* the player dealing with the cell */
	protected Player player;
	
	/* the number of turns to wait */
	protected int nbTurnsToWait;
	
	/* Constructor for a waiting cell */
	public WaitingCell(int iniIndex, Player iniPlayer) {
		this.index = iniIndex;
		this.player = iniPlayer;
		this.nbTurnsToWait = 2;
	}
	
	/* Constructor for a waiting cell */
	public WaitingCell(int iniIndex, int nbTTW) {
		this.index = iniIndex;
		this.player = null;
		this.nbTurnsToWait = nbTTW;
	}
	
	/** get the number of turns to wait
	 * @return the number
	 */
	public int getNbTurnsToWait(){
		return this.nbTurnsToWait;
	}
	
	/** set the number of turns to wait
	 * @param nb is the number to set
	 */
	public void setNbTurnsTowait(int nb){
		this.nbTurnsToWait = nb;
	}
	
	/** checks if the player can leave the cell
	 * @return <tt>true</tt> when the number of turns to wait is zero
	 */
	public boolean canBeLeft(){
		if (this.getNbTurnsToWait() == 0) {
		return true;
		} else {
			return false;
		}
	}
	
	/** returns the index of this cell
	 * @return the index of the cell
	 */
	public int getIndex() {
		return this.index;
	}
	
	/** returns <tt>true</tt> if a player is in this cell */
	public boolean isBusy() {
		return this.player != null;
	}
	
	 /**
     * returns the index of the cell really reached by a player when the player
     *    reaches this cell.
     * @param diceThrow the result of the dice when the player reaches this cell
     * @return the index of the actual cell where the player arrives
     */
	public int handleMove(int diceThrow) {
		System.out.println("The player reaches a waiting cell !");
		return this.getIndex();
	}
	
	/** gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer() {
		return this.player;
	}
	
	/** sets the player in this cell
	 * @param p is the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	 /**  handles what happens when a player arrives in this cell 
     * @param player the new player in the cell
     */
	public void welcomePlayer(Player player){
		if (this.getPlayer() != null) {
			
			System.out.print("The player " +this.getPlayer().toString() + " is already here !");
			
			Player playerToTakeOff = this.getPlayer();
			
			Cell cellToSend = player.getCell();
			
			playerToTakeOff.setCell(cellToSend);
			
			System.out.println(" The player " +player.toString()
			+ " takes his place and the player "+playerToTakeOff.toString()
			+ " has been moved to the cell number " + cellToSend.getIndex() + ".");
		}
	}
	
	/* To decrease the number of turns to wait for the player */
	public void letOneTurnGo(){
		System.out.println("The player " +this.getPlayer() +" has to wait "
				+ this.getNbTurnsToWait() + " turns before playing !");
		int updateNb = this.getNbTurnsToWait() - 1;
		this.setNbTurnsTowait(updateNb);
		}
}
