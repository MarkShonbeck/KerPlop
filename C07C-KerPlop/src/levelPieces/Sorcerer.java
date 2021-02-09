/**
 * 
 * Authors:
 * Mark Shonbeck
 * Joshua Bordick
 * 
 * Date: 2/8/21
 * 
 */
package levelPieces;

import gameEngine.*;

public class Sorcerer extends GamePiece implements Moveable{
	
	private static final char SYMBOL = 'S';
	private static final String NAME = "Sorcerer";
	private static final int MOVE_DISTANCE = 5;
	
	public Sorcerer(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	/**
	 * Immediately advances the player to next level if they are on the same spot
	 */
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}
	
	/**
	 * moves to a random tile 5 tiles forward or backward
	 */
	@Override
	public void move(Drawable [] gameBoard, int playerLocation) {
		int rand = (int)(Math.random() * (MOVE_DISTANCE+1));
		boolean forward = (1 == (int)(Math.random() * 2));
		if(forward) {
			if(getLocation() + rand < gameBoard.length && gameBoard[getLocation() + rand] == null) {
				gameBoard[getLocation()] = null;
				gameBoard[getLocation() + rand] = this;
				setLocation(getLocation() + rand);
			}
		}
		else {
			if(getLocation() - rand >= 0 && gameBoard[getLocation() - rand] == null) {
				gameBoard[getLocation()] = null;
				gameBoard[getLocation() - rand] = this;
				setLocation(getLocation() - rand);
			}
		}
	}
}
