package goosegame;

public class FactoryCommand {
	public static ICommand   getCommand(String commandString)throws GooseException{
		if (commandString.equals("") || (!commandString.toUpperCase().startsWith("ADD PLAYER") && !commandString.toUpperCase().startsWith("MOVE"))) 
			throw new GooseException("Illegal commandString : "+commandString);
		if (commandString.toUpperCase().startsWith("ADD PLAYER")) {
			commandString="AddPlayer";
		} else if (commandString.toUpperCase().startsWith("MOVE")) {
			commandString="Move";
		}
		
			return create("Cmd"+commandString);		
	}

	public static ICommand create(String name)throws GooseException {
		try {
		//	return (ICommand) Class.forName("game.src.goosegame."+name).newInstance();
			switch (name) {
			case "CmdAddPlayer":
				return new CmdAddPlayer();
				
			case "CmdMove":
				return new CmdMove();
				
			default:
				throw new GooseException("Illegal create "+name);
				
			}
			
		} catch (Throwable e) {
			throw new GooseException("Illegal create :"+e.getMessage());
		}
	}

}
