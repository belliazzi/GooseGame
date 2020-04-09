package goosegame;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class AllTests {
	

	@BeforeClass
	public static void initClass() {
	System.out.println("initClass()");
	}
	@AfterClass
	public static void endClass() {
	System.out.println("endClass()");
	}
	@Before
	public void initMethod() {	
	System.out.println("initMethod()");
	}
	@After
	public void endMethod() {
	System.out.println("end Method");
	}
	
	@Test
	public void testTrapCell() {
	System.out.println("testTrapCell");
	Player Player1=new Player("Pippo");
	Player1.setCell(new RegularCell(1));
	Player Player2=new Player("Pluto");
	Player2.setCell(new TrapCell(2));
	TrapCell TrapCell= new TrapCell(2,Player2);
	TrapCell.welcomePlayer(Player1);
	assertEquals(Player2.getCell().getIndex(),1);
	
	}
	@Test
	public void testTeleportCell() {
	System.out.println("testTeleportCell");
	Player Player1=new Player("Pippo");
	Player1.setCell(new RegularCell(1));
	Player Player2=new Player("Pluto");
	Player2.setCell(new TeleportCell(2));
	TeleportCell TrapCell= new TeleportCell(2,Player2);
	TrapCell.welcomePlayer(Player1);
	assertEquals(Player2.getCell().getIndex(),1);
	
	}
	
	@Test
	public void testGooseCell() {
	System.out.println("testGooseCell");
	Player Player1=new Player("Pippo");
	Player1.setCell(new RegularCell(1));
	Player Player2=new Player("Pluto");
	Player2.setCell(new GooseCell(2));
	GooseCell TrapCell= new GooseCell(2,Player2);
	TrapCell.welcomePlayer(Player1);
	assertEquals(Player2.getCell().getIndex(),1);
	
	}
	
	
	@Test
	public void tesFactoryCommand() {
	System.out.println("tesFactoryCommand");
	try {
		assertEquals(FactoryCommand.getCommand("add player").getClass(),CmdAddPlayer.class);
		assertEquals(FactoryCommand.getCommand("move").getClass(),CmdMove.class);
	} catch (GooseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}

