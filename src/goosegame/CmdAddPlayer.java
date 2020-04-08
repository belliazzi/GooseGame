package goosegame;

import java.io.BufferedReader;
import java.io.Serializable;

public class CmdAddPlayer implements ICommand ,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Game exec(Game game, BufferedReader bufferedReader,String inputString) throws GooseException {
		if (game.isGameStart()) {		
			   throw new  GooseException("Can't add player  the game is start : now only cmd move is allowed");
		}
		 String nome=inputString.toUpperCase().replace("ADD PLAYER", "").trim();
		 if (nome.isEmpty()) {
			 throw new  GooseException("name player i empty");
		 }
		 boolean OkPlayer=true;
		 for(Player elem: game.getThePlayers()) {
			 if (elem.toString().equals(nome)) {
				 
				  throw new  GooseException("player "+ nome+ " exist ");
				
						
			 } else {
				 OkPlayer=true;
			 }
		 }
		 
		 if (OkPlayer) {
			 Player p = new Player(nome);
			 game.addPlayer(p);
			 StringBuilder sts = new StringBuilder();
			 for(Player elem: game.getThePlayers()) {
				  sts.append(","+ elem.toString()+"");
				 
			 } 
			 System.out.println("players "+ sts + "  ");
		 }
		return game;
		
	}

	
}
