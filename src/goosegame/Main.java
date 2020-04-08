package goosegame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		/* Create the board we are going to play in */
		Board origiBoard = new OriginalBoard();
		boolean exit = false;
		System.out.println("istruction the commad ");
		System.out.println("add player <name>  what mean : add a player with name <name> too the game ");
		System.out.println(
				"move <playername> number,number   what mean : move a player with name <playername> like the rsult of the throw two dices ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		while (!(exit)) {
			Game aGame = new Game(origiBoard);
			aGame.getBoard().initBoard();
			System.out.println("the game is start digit add player ");
			while (!aGame.getGameFinished()) {
				try {
					/* Initiate a game with the board */
					String sts = Utility.getStringaDaConsole(bufferedReader);
					ICommand ic = FactoryCommand.getCommand(sts); //PAttern Factory
					ic.exec(aGame, bufferedReader, sts);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				} catch (GooseException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());

				}

			}
			/* Define the player */
			System.out.println("the game is end replay y/n ");
			String stsExit;
			stsExit = Utility.getStringaDaConsole(bufferedReader);
			if (stsExit.toUpperCase().equals("N"))
				exit = true;
		}
	}

}
