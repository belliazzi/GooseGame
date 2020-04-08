package goosegame;

public class TeleportCell implements Cell{
	
	/* the index of the cell */
	protected int index;
	
	/* the player dealing with the cell */
	protected Player player;
	
	/* Constructor for a teleport cell */
	public TeleportCell(int iniIndex, Player iniPlayer) {
		this.index = iniIndex;
		this.player = iniPlayer;
	}
	
	/* Constructor for a teleport cell */
	public TeleportCell(int iniIndex) {
		this.index = iniIndex;
		this.player = null;
	}
	
	/** 
	 * @return <tt>true</tt> because it is a teleport cell.
	 */
	public boolean canBeLeft(){
		return true;
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
     * @return the index of the actual cell where the player
     * arrives when the given throw of dice sends the player in this cell
     */
	public int handleMove(int diceThrow) {
		int finalIndex = 0;
		if(this.getIndex() == 6) { finalIndex = 12;}
		if(this.getIndex() == 42) { finalIndex = 30;}
		if(this.getIndex() == 58) { finalIndex = 1;}
		
		System.out.print("The player reaches a Teleport cell !");
		System.out.println(" He is now in cell " + finalIndex);
		return finalIndex;
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
	
	public void letOneTurnGo(){};

}
