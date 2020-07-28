package chessgui.pieces;

import chessgui.Board;
import chessgui.pieces.Piece;

public class Queen extends Piece {
	public Queen (int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        super(x, y, is_white, file_path, board, is_jester);
    }
    
	@Override
	public boolean canMove(int destination_x, int destination_y)
	{
		//Check if destination has same color piece
				Piece potentialPiece = this.board.getPiece(destination_x, destination_y);
				if (potentialPiece != null) { //to avoid nullpointer
					if (potentialPiece.isWhite() && this.isWhite()) {
						return false;
					}
					if (!potentialPiece.isWhite() && !this.isWhite()) {
						return false;
					}
				}
				
				//Make sure the queen is moving either diagonally or linearly
				String movement = "";
				if (Math.abs(this.getX() - destination_x) == Math.abs(this.getY() - destination_y) ) {
					movement = "diagonal";
				}
				if (this.getX() == destination_x || this.getY() == destination_y) {
					movement = "straight";
				}
				
				//If Straight
				if (movement.equals("straight")) {
					
					//Establish linear direction
					String direction = "";
					if (destination_x > this.getX()) {
						direction = "right";
					}
					if (destination_x < this.getX()) {
						direction = "left";
					}
					if (destination_y > this.getY()) {
						direction = "up";
					}
					if (destination_y < this.getY()) {
						direction = "down";
					}
					
					//Get #of spaces to check each for piece
					int num_spaces = 0;
					if (direction.equals("right")) {
						num_spaces = destination_x - this.getX();
						for (int i = 1; i < num_spaces; i++) {
							if (this.board.getPiece(this.getX() + i, this.getY()) != null) {
								return false;
							}
						}
					}
					if (direction.equals("left")) {
						num_spaces = this.getX() - destination_x;
						for (int i = 1; i < num_spaces; i++) {
							if (this.board.getPiece(this.getX() - i, this.getY()) != null) {
								return false;
							}
						}
					}
					if (direction.equals("up")) {
						num_spaces = destination_y - this.getY();
						for (int i = 1; i < num_spaces; i++) {
							if (this.board.getPiece(this.getX(), this.getY() + i) != null) {
								return false;
							}
						}
					}
					if (direction.equals("down")) {
						num_spaces = this.getX() - destination_y;
						for (int i = 1; i < num_spaces; i++) {
							if (this.board.getPiece(this.getX(), this.getY() - i) != null) {
								return false;
							}
						}
					}
					//It didn't find any pieces in the way so..
					return true;
				}
				
				//If diagonal
				if (movement.equals("diagonal")) {
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
					//It didn't find any pieces in the way so..
					return true;
				}
				//If it wasn't traveling linearly or diagonally
				return false;
			}
}
