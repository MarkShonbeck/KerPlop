package tests;

import gameEngine.*;
import levelPieces.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestInteractions {

	@Test
	public void Warrior() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Warrior warrior = new Warrior(20);
		gameBoard[20] = warrior;
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
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Archer archer = new Archer(20);
		gameBoard[20] = archer;
		for(int i = 0; i < gameBoard.length; i++) {
			if(i == 17 || i == 18 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23) {
				assertEquals(InteractionResult.HIT, archer.interact(gameBoard, i));
			}
			else {
				assertEquals(InteractionResult.NONE, archer.interact(gameBoard, i));
			}
		}
	}
	
	@Test
	public void Treasure() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure treasure = new Treasure(20);
		gameBoard[20] = treasure;
		assertEquals(InteractionResult.GET_POINT, treasure.interact(gameBoard, 20));
		for(int i = 0; i < gameBoard.length; i++) {
			if(i == 20) {
				continue;
			}
			assertEquals(InteractionResult.NONE, treasure.interact(gameBoard, i));
		}
	}
	
	@Test
	public void Sorcerer() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Sorcerer sorcerer = new Sorcerer(20);
		gameBoard[20] = sorcerer;
		assertEquals(InteractionResult.ADVANCE, sorcerer.interact(gameBoard, 20));
		for(int i = 0; i < gameBoard.length; i++) {
			if(i == 20) {
				continue;
			}
			assertEquals(InteractionResult.NONE, sorcerer.interact(gameBoard, i));
		}
	}
}
