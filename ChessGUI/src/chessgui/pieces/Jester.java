package chessgui.pieces;

import chessgui.Board;

public class Jester extends Piece {
	
	public Jester(int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        super(x, y, is_white, file_path, board, is_jester);
    }
    
	@Override
	public boolean canMove(int destination_x, int destination_y)
	{

		
		Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
		if (potentialPiece == null) { 
			return false;
		}
		if (potentialPiece.isWhite() && this.isWhite()) {
			return true;
		}
		else if (!potentialPiece.isWhite() && !this.isWhite()) {
			return true;
		}
		else {
			return false;
		}
		
	}
}
