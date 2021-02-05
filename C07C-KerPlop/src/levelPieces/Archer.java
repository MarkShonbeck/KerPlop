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
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation - this.getLocation() >= RANGE || playerLocation - this.getLocation() <= RANGE) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}
