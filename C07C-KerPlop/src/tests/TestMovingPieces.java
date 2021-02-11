/**
 * 
 * @Author Joshua Bordick and Mark Shonbeck
 * 2/10/21
 * 
 * 
 */
package tests;

import gameEngine.*;
import levelPieces.*;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestMovingPieces {
	
	/**
	 * checks to see if warriors movement was as desired. If the warrior hits
	 * the wall it should change directions. Also checks if the warrior is moving properly 
	 * when at the edge of the board.
	 */
	@Test
	public void Warrior() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Warrior warrior = new Warrior(1);
		gameBoard[1] = warrior;
		gameBoard[30] = new Wall();
		
		for(int i = 2; i < 50; i++) {
			warrior.move(gameBoard, 0);
			int loc = warrior.getLocation(), fails = 0;
			if(loc >= 30) {
				fails++;
				fail("Moved past wall");
			}
			if(i < 5 && loc == 0) {
				fails++;
				fail("Moved wrong way");
			}
			if(i < 30 && loc != i) {
				fails++;
				fail("Invalid Movement");
			}
			assert(fails == 0);
		}
	}
	/**
	 * This test checks to see if the sorcerer is meeting a random probabilty check.
	 * The sorcerer is inteded to move 5 spaces forwards or backwards randomly.
	 * Run test 500 times to makes sure the sorcerer is being random. 
	 *
	 */
	@Test
	public void Sorcerer() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Sorcerer sorcerer = new Sorcerer(10);
		int [] open = {10, 8, 11, 15, 5};
		int [] counts = new int[5];
		for(int i = 0; i < gameBoard.length; i++) {
			boolean contains = false;
			for(int j = 0; j < open.length; j++) {
				if(i == open[j]) {
					contains = true;
				}
			}
			if(!contains) {
				gameBoard[i] = new Wall();
			}
		}
		for(int i = 0; i < 500; i++) {
			sorcerer.move(gameBoard, 0);
			int loc = sorcerer.getLocation();
			Boolean inOpen = false;
			for(int j = 0; j < open.length; j++) {
				if(loc == open[j]) {
					counts[j]++;
					inOpen = true;
				}
			}
			if(!inOpen) {
				fail("Moved onto a wall");
			}
		}
		for(int i = 0; i < counts.length; i++) {
			assert(counts[i] >= 50);
		}
	}
}
