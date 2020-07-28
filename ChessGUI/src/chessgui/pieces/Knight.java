package chessgui.pieces;

import chessgui.Board;
import chessgui.pieces.Piece;

public class Knight extends Piece {
	
	public Knight(int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        super(x, y, is_white, file_path, board, is_jester);
    }
    
	@Override
	public boolean canMove(int destination_x, int destination_y)
	{
		//Ensures only L-Shape
				if (Math.abs(destination_x - this.getX()) == 1 && Math.abs(destination_y - this.getY()) == 2) {
					//Check if destination has same color piece
					Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
					if (potentialPiece != null) { //to avoid nullpointer
						if (this.board.getPiece(destination_x, destination_y).isWhite() && this.isWhite()) {
							return false;
						}
						if (!this.board.getPiece(destination_x, destination_y).isWhite() && !this.isWhite()) {
							return false;
						}
					}
					return true;
				}
				//Ensures only L-Shape
				if (Math.abs(destination_x - this.getX()) == 2 && Math.abs(destination_y - this.getY()) == 1) {
					//Check if destination has same color piece
					Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
					if (potentialPiece != null) { //to avoid nullpointer
						if (this.board.getPiece(destination_x, destination_y).isWhite() && this.isWhite()) {
							return false;
						}
						if (!this.board.getPiece(destination_x, destination_y).isWhite() && !this.isWhite()) {
							return false;
						}
					}
					return true;
				}
				return false;
			}
}
