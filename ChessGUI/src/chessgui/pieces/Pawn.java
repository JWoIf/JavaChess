package chessgui.pieces;

import chessgui.Board;
import chessgui.pieces.Piece;

public class Pawn extends Piece {
	public Pawn(int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        super(x, y, is_white, file_path, board, is_jester);
    }
    
	@Override
	public boolean canMove(int destination_x, int destination_y)
	{
		//Check if piece is diagonal if not cannot move out of x value
				// Check if piece is directly in front if so cannot move out of y value
				// check if piece is both white and on square 1 or black on square 6 if so can move it's y 2
				//else restrict movement to 1 up y
				Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
				if (this.isWhite()) {
					if (potentialPiece != null) { //to avoid nullpointer
						if (Math.abs(destination_x - this.getX()) == 1 && destination_y - this.getY() == 1 && !potentialPiece.isWhite()) {
							return true;
						}
					}
					if (destination_x != this.getX()) {
						return false;
					}
					if (destination_y - this.getY() == 1 && potentialPiece == null) {
						return true;
					}
					if (this.getY() == 1) {
						if (destination_y - this.getY() == 2 && potentialPiece == null && this.board.getPiece(destination_x, destination_y - 1) == null) {
							return true;
						}
					}
					
				}
				//For POCs (Pieces of Color)
				if (!this.isWhite()) {
					if (potentialPiece != null) { //to avoid nullpointer
						if (Math.abs(destination_x - this.getX()) == 1 && this.getY() - destination_y  == 1 && potentialPiece.isWhite()) {
							return true;
						}
					}
					if (destination_x != this.getX()) {
						return false;
					}
					if (this.getY() - destination_y == 1 && potentialPiece == null) {
						return true;
					}
					if (this.getY() == 6) {
						if (this.getY() - destination_y == 2 && potentialPiece == null) {
							return true;
						}
					}
				}
				return false;
			}
}
