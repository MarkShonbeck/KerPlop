package levelPieces;

import gameEngine.*;

public class Wall implements Drawable {
	
	private static final char SYMBOL = 'W';
	
	@Override
	public void draw() {
		System.out.print(SYMBOL);
	}
}
