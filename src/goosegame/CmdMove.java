package goosegame;

import java.io.BufferedReader;
import java.io.Serializable;

public class CmdMove implements ICommand, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Game exec(Game game, BufferedReader bufferedReader,String inputString) throws GooseException {
		String nome;
		String dice1;
		String dice2;
		if (game.getGameFinished()) {
			  System.out.println(" game is finisched ");
		}
		if (game.getThePlayers()!=null && game.getThePlayers().size()>0) {
			
			
			try {
				String[] sts = inputString.split(" ");
				nome = sts[1];
				dice1 = sts[2];
				dice1=dice1.replace(",", "");
				dice2 = sts[3];
			} catch (IndexOutOfBoundsException e1) {
				throw new  GooseException("error digit command BEWARE the space blanc in istruction move<space><name><space><dice1>,<space><dice2>");
			}
			Player pToMove=null;
			for (Player p : game.getThePlayers()) {
				if (p.name.toUpperCase().equals(nome.toUpperCase())) {
					pToMove=p;
					break;
				}
					
			}
			try {
				int dice1Int=Integer.parseInt(dice1);
				int dice2Int=Integer.parseInt(dice2);
				if ((dice1Int<0 || dice1Int>6) || (dice2Int<0 || dice2Int>6)) {
					throw new  GooseException("error digit dice is  number >0 and <=6 es: move <name> 1,2 ");
				}
			} catch (NumberFormatException e) {
				throw new  GooseException("error digit dice is not number es: move <name> 1,2 ");
			}
			if (pToMove!=null) {
			int boardSize = game.getBoard().getNbOfCells() - 1;
			
			/* For  player we are going to throw the dice */
			
			
				
				/*We check if the player can leave the cell */
				if (pToMove.getCell().canBeLeft()) {
					
					int result = Integer.parseInt(dice1)+ Integer.parseInt(dice2);
					
					/* Compute the new index of the player */
					int currentIndex = pToMove.getCell().getIndex();
					int interIndex = currentIndex + result;
					int intermediateIndex;
					int destinationIndex;
					
					/* If the player is not out of the board */
					if (interIndex < boardSize + 1) {
						intermediateIndex = interIndex;
						destinationIndex = game.getBoard().getCell(intermediateIndex).handleMove(result);
					} else {
						intermediateIndex = boardSize - (result - (boardSize - currentIndex));
						destinationIndex = intermediateIndex;
					}
					
					/* gives the status of the player */
					System.out.print(pToMove.toString() + " in in cell " +currentIndex +".");
					System.out.println(" He throws " +result + " and reaches the cell " +intermediateIndex +".");
					
					Cell destinationCell = game.getBoard().getCell(destinationIndex);
									
					destinationCell.welcomePlayer(pToMove);
					pToMove.setCell(destinationCell);
					game.getBoard().getCell(destinationIndex).setPlayer(pToMove);
					
					/* Check if there is a winner */
					if (destinationIndex == boardSize) {
						System.out.println(pToMove.toString() + " is in cell " +destinationIndex
								+" which is the final cell. He wins !");
						game.setGameFinished(true);
					
					}
				} else {
					pToMove.getCell().letOneTurnGo();
				}
				
			} else {
				
				 throw new  GooseException("Player "+nome+"not exist");
			}
			
		} else {
			 
			  throw new  GooseException("No players : digit command   add player <name>  for add first player ");
		}
		
		return game;
		
	}
}
