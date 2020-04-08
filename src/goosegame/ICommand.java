package goosegame;

import java.io.BufferedReader;

public interface ICommand {

	public Game exec (Game game,BufferedReader bufferedReader,String inputString) throws GooseException;
}
