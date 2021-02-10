package tests;

import gameEngine.*;
import levelPieces.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestInteractions {

	@Test
	public void Warrior() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Warrior warrior = new Warrior(10);
		new Player(20);
		gameBoard[10] = warrior;
		assertEquals(InteractionResult.KILL, warrior.interact(gameBoard, 20));
		for(int i = 0; i < gameBoard.length; i++) {
			if(i == 20) {
				continue;
			}
			assertEquals(InteractionResult.NONE, warrior.interact(gameBoard, i));
		}
	}
	
	@Test
	public void Archer() {
		
	}
	
	@Test
	public void Treasure() {
		
	}
	
	@Test
	public void Sorcerer() {
		
	}
}
