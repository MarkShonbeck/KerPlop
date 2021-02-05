package levelPieces;

import gameEngine.*;

public class Warrior extends GamePiece implements Moveable{

	private static final char SYMBOL = 'W';
	private static final String NAME = "Warrior";
	private boolean movingRight = true;
	
	public Warrior(int location)
	{
		super(SYMBOL, NAME, location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable [] gameBoard, int playerLocation) {
		gameBoard[getLocation()] = null;
		if(movingRight) {
			if(getLocation() == gameBoard.length) {
				movingRight = false;
			}
			else if(gameBoard[getLocation() + 1] != null) {
				movingRight = false;
			}
			else {
				gameBoard[getLocation() + 1] = this;
			}
		}
		else {
			if(getLocation() == 0) {
				movingRight = true;
			}
			else if(gameBoard[getLocation() - 1] != null) {
				movingRight = true;
			}
			else {
				gameBoard[getLocation() - 1] = this;
			}
		}
	}
}
