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

public class Treasure extends GamePiece {
	
	private static final char SYMBOL = 'T';
	private static final String NAME = "Treasure";
	
	public Treasure(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	/**
	 * gives a point if the player lands on the treasure
	 */
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
