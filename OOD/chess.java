public enum PlayerColor {

    WHITE,BLACK
}


public enum PieceStatus {


    LIVE, DEAD
}



public class Spot {

    private int x;
    private int y;

    private Piece piece;


    public Spot(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        piece = null;
    }


    public void occupySpot(Piece newPiece) {


        if (isOccupied()) {

            this.piece.setPieceStatus(PieceStatus.DEAD);
        }

        piece = newPiece;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}

public class Board {
    private Spot[][] spots;

    public Board() {
        spots = new Spot[8][8];
    }


    public void initialize(Player p) {
        // put the pieces with initial status
        for (int i = 0; i < p.getPieces().size(); i++) {
            spots[p.getPieces().get(i).getX()][p.getPieces().get(i).getY()].occupySpot(p.getPieces().get(i));
        }
    }

    public boolean executeMove(Player p) {
        Piece king = new King();
        Command cmd = new Command(king, 0, 0, 0, 0);

        // check the move step is valid for piece
        if (!king.isValid(this, cmd.curX, cmd.curY, cmd.desX, cmd.desY)) {
            // if not valid cmd remove the command and return false
            return false;
        }

        // check the two pieces side
        if (spots[cmd.desX][cmd.desY] != null && spots[cmd.desX][cmd.desY].getPiece().getPlayerColor() == p.getPlayerColor()) {
            return false;
        } else {

            spots[cmd.desX][cmd.desY].occupySpot(king);
            return true;
        }


    }
}


public abstract class Piece {

    private PieceStatus pieceStatus;
    private PlayerColor playerColor;

    private int x;
    private int y;


    public abstract boolean move();


    public PieceStatus getPieceStatus() {
        return pieceStatus;
    }

    public void setPieceStatus(PieceStatus pieceStatus) {
        this.pieceStatus = pieceStatus;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public abstract boolean isValid(Board board, int fromX, int fromY, int toX, int toY);

}

public class King extends Piece {
    @Override
    public boolean move() {
        return false;
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        return true;
    }
}

public class Command {
    Piece piece;
    int curX, curY, desX, desY;
    public Command(Piece piece, int curX, int curY, int desX, int desY) {
        this.piece = piece;
        this.curX = curX;
        this.curY = curY;
        this.desX = desX;
        this.desY = desY;
    }
}


public class Player  {

    private PlayerColor playerColor;
    private List<Piece> pieces = new ArrayList<>();


    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(PlayerColor playerColor) {
        this.playerColor = playerColor;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
}


public class ChessGame {
    private Board board;
    private Player p1;
    private Player p2;

    private boolean win;

    private ChessGame() {
        board = new Board();


        p1 = new Player();
        p2 = new Player();

        board.initialize(p1);
        board.initialize(p2);


    }


    private boolean checkStatus() {
        return false;
    }

    private void startGame() {
        while (true) {
            board.executeMove(p1);
            if (checkStatus()) {
                System.out.println("P1 win!");
                break;
            }
            board.executeMove(p2);
            if (checkStatus()) {
                System.out.println("P2 win!");
                break;
            }
        }
    }

}




