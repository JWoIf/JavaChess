package chessgui.pieces;

import chessgui.Board;

public class Piece {
    private int x;
    private int y;
    final private boolean is_white;
    private String file_path;
    private boolean is_jester;
    public Board board;
    
    public Piece(int x, int y, boolean is_white, String file_path, Board board, boolean is_jester)
    {
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.file_path = file_path;
        this.board = board;
        this.is_jester = is_jester;
    }
    
    public String getFilePath()
    {
        return file_path;
    }
    
    public void setFilePath(String path)
    {
        this.file_path = path;
    }
    
    public boolean isWhite()
    {
        return is_white;
    }
    
    public boolean isBlack()
    {
        return !is_white;
    }
    
    public boolean isJester()
    {
        return is_jester;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean canMove(int destination_x, int destination_y)
    {
        return false;
    }
}