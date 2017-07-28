public enum Color {

    BLACK, WHITE, BLANK
}


public enum Direction {

    UP, DOWN, LEFT, RIGHT
}


public class Player {
    private Color color;

    public Player(Color c) {
        color = c;
    }

    public int getScore() {
        return 0;
    }

    public boolean playPiece(int r, int c) {
        return Game.getInstance().getBoard().placeColor(r, c, color);
    }

    public Color getColor() {
        return color;
    }

}


public class Piece {

    private Color color;

    public Piece(Color c) {
        color = c;
    }


    public void flip() {
        if (color == Color.BLACK)
            color = Color.WHITE;
        else
            color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}


public class Game {
    private Player[] players;
    private Board board;
    private final int ROWS = 10;
    private final int COLUMNS = 10;

    private Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.BLACK);
        players[1] = new Player(Color.WHITE);
    }


    private static Game instance = new Game();

    public static Game getInstance() {
        return instance;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}


public class Board {
    private int blackCount = 0;
    private int whiteCount = 0;

    private Piece[][] board;

    public Board(int rows, int columns) {
        board = new Piece[rows][columns];
    }

    public void initialize() {
        // initialize center black and white pieces
    }

    // attempt to place a piece of color color at(row, column)
    // return true if we were successful
    public boolean placeColor(int row, int column, Color color) {
        return false;

    }

    // flips pieces starting at(row, column)
    // and proceeding in direction d

    private int flipSection(int row, int column, Color color, Direction d) {
        return column;
    }

    public int getScoreForColor(Color c) {
        if (c == Color.BLACK)
            return blackCount;
        else
            return whiteCount;
    }

    // update board with additional newPieces pieces of color
    // newColor, decrease score of opposite color
    public void updateScore(Color newColor, int newPieces) {
    }

}

