package levelPieces;

import gameEngine.*;

public class Treasure extends GamePiece {
	
	private static final char SYMBOL = 'T';
	private static final String NAME = "Treasure";
	
	public Treasure(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
