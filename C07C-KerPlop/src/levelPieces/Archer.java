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

public class Archer extends GamePiece {
	
	private static final char SYMBOL = 'A';
	private static final String NAME = "Archer";
	private static final int RANGE = 3;
	
	public Archer(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	/**
	 * Hits player if the player is within 3 tiles of it
	 */
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(Math.abs(playerLocation - this.getLocation()) <= RANGE) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
