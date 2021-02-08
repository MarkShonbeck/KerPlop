package levelPieces;

import java.util.ArrayList;
import gameEngine.*;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {

	private final int BOARD_LENGTH = 40;
	private ArrayList<Drawable> board;
	
	public void createLevel(int levelNum) {
		board = new ArrayList<Drawable>();
		for(int i = 0; i < BOARD_LENGTH; i++) {
			board.add(null);
		}
		new Player(getPlayerStartLoc());
		switch(levelNum) {
		case 1:
			board.set(5, new Sorcerer(5));
			board.set(8, new Archer(8));
			board.set(14, new Treasure(14));
			board.set(15, new Warrior(15));
			board.set(25, new Wall());
			board.set(32, new Wall());
			board.set(28, new Warrior(28));
			board.set(30, new Treasure(30));
			break;
		case 2:
			board.set(5, new Sorcerer(5));
			board.set(8, new Wall());
			board.set(30, new Treasure(30));
			board.set(13, new Treasure(13));
			board.set(31, new Archer(31));
			board.set(18, new Warrior(18));
			break;
		}
	}

	public Drawable[] getBoard() {
		Drawable [] drawablePieces = new Drawable[BOARD_LENGTH];
		for(int i = 0; i < board.size(); i++) {
			drawablePieces[i] = board.get(i);
		}
		return drawablePieces;
	}

	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> movingPieces = new ArrayList<Moveable>();
		for(int i = 0; i < board.size(); i++) {
			if(board.get(i) instanceof Moveable) {
				movingPieces.add((Moveable) board.get(i));
			}
		}
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
		for(int i = 0; i < board.size(); i++) {
			if(board.get(i) instanceof GamePiece) {
				interactingPieces.add((GamePiece) board.get(i));
			}
		}
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return 20;
	}

}
