package chessgui.pieces;


import chessgui.Board;

public class Bishop extends Piece {
	
	public Bishop(int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        super(x, y, is_white, file_path, board, is_jester);
    }
    
	@Override
	public boolean canMove(int destination_x, int destination_y)
	{
		//Only diagonal movement
		if (Math.abs(this.getX() - destination_x) != Math.abs(this.getY() - destination_y) ) {
			return false;
		}

		//Check if destination has same color piece
		Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
		if (potentialPiece != null) { //to avoid nullpointer
			if (board.getPiece(destination_x, destination_y).isWhite() && this.isWhite()) {
				return false;
			}
			if (!board.getPiece(destination_x, destination_y).isWhite() && !this.isWhite()) {
				return false;
			}
		}
		//Establish direction
		String direction = "";
		if (destination_y > this.getY()) {
			direction = "up";
		}
		if (destination_y < this.getY()) {
			direction = "down";
		}

		String direction2 = "";
		if (destination_x > this.getX()) {
			direction2 = "right";
		}
		if (destination_x < this.getX()) {
			direction2 = "left";
		}

		//Check each passed over space for piece
		int num_spaces = 0;
		if (direction.equals("up")) {
			num_spaces = destination_y - this.getY();
			for (int i = 1; i < num_spaces; i++) {
				if (direction2.equals("left")) {
					if (this.board.getPiece(this.getX() - i, this.getY() + i) != null) {
						return false;
					}
				}
				if (direction2.equals("right")) {
					if (this.board.getPiece(this.getX() + i, this.getY() + i) != null) {
						return false;
					}
				}
			}
		}
		if (direction.equals("down")) {
			num_spaces = this.getX() - destination_y;
			for (int i = 1; i < num_spaces; i++) {
				if (direction2.equals("left")) {
					if (this.board.getPiece(this.getX() - i, this.getY() - i) != null) {
						return false;
					}
				}
				if (direction2.equals("right")) {
					if (this.board.getPiece(this.getX() + i, this.getY() - i) != null) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
