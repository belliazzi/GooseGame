package goosegame;

import java.util.*;

public class ZeroCell implements Cell{
	
	/* the index of the cell */
	protected int index;
	
	/* the player dealing with the cell */
	protected List<Player> thePlayers;
	
	/* Constructor for a zero cell */
	public ZeroCell(int iniIndex, List<Player> iniPlayers) {
		this.index = iniIndex;
		this.thePlayers = iniPlayers;
	}
	
	/* Constructor for a zero cell */
	public ZeroCell(int iniIndex) {
		this.index = iniIndex;
		this.thePlayers = new ArrayList<Player>();
	}
	
	/** 
	 * @return <tt>true</tt> because it is a zero cell.
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
		return this.thePlayers != null;
	}
	
	 /** Returns 0 which is the index of the zero cell */
	public int handleMove(int diceThrow) {
		return 0;
	}
	
	/** gets the player in this cell <tt>null</tt> if none */
	public List<Player> getPlayers() {
		return this.thePlayers;
	}
	
	/** gets the player in this cell <tt>null</tt> if none */
	public Player getPlayer() {
		if(this.getPlayers().size() == 0) return null;
		return this.getPlayers().get(0);
	}
	
	/** sets the player in this cell
	 * @param p is the player to set
	 */
	public void setPlayer(Player player) {
		if(!this.getPlayers().contains(player)){
			this.getPlayers().add(player);
			player.setCell(this);
		}
	}

	public void welcomePlayer(Player player){}
	
	public void letOneTurnGo(){};

}
