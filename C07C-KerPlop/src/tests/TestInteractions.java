/**
 * 
 * @Author Joshua Bordick and Mark Shonbeck
 * 2/10/21
 * 
 */
package tests;

import gameEngine.*;
import levelPieces.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestInteractions {
	/**
	 * check if interaction with player is kill on contact 
	 * for the warrior and none if anywhere else.
	 */
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
	/**
	 * test if range of archer is working properly. Should hit player if within plus
	 * or minus three spaces. Should be none if anywhere else. 
	 */
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
	/**
	 * Check if when player is at treasure location the player gets a point. 
	 * Should be none anywhere else.
	 * 
	 */
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
	/**
	 * Check if player advances when interacting with sorcerer. 
	 * Should be none if anywhere else. 
	 */
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
