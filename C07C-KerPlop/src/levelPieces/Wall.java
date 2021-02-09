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

public class Wall implements Drawable {
	
	private static final char SYMBOL = ']';
	
	@Override
	public void draw() {
		System.out.print(SYMBOL);
	}
}
