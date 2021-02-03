package levelPieces;

import gameEngine.*;

public class Warrior extends GamePiece{

	private static final char SYMBOL = 'W';
	private static final String NAME = "Warrior";
	
	public Warrior(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
}
