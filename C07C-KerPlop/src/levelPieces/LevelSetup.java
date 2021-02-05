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
		board.set(10, new Warrior(10));
		board.set(35, new Warrior(35));
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
