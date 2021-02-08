package levelPieces;

import gameEngine.*;

public class Wall implements Drawable {
	
	private static final char SYMBOL = ']';
	
	@Override
	public void draw() {
		System.out.print(SYMBOL);
	}
}
