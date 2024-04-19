
// I need to add correspondence and convention
/*
 * Correspondence
 * player - "X" || "O" || ""
 * smallBoard - 2D String Array filled with only a player values
 * bigBoard - String Array filled with only player values
 * validBoard - UltimateTicTacToeKernel.Position.P
 *
 * Convention
 * player - either player 1 or 2 values or empty
 * smallBoard - 9 sets of tic-tac-toe boards
 * bigBoard - 1 tic-tac-toe board
 * validBoard - Square in a tic-tac-toe board or all of them
 */
public class UltimateTicTacToe1L extends UltimateTicTacToeSecondary {

    private String player;
    private String[][] smallBoard;
    private String[] bigBoard;
    private Position validBoard;

    public UltimateTicTacToe1L() {
        this.createNewRep();
    }

    public void createNewRep() {
        this.player = "X";
        this.smallBoard = new String[9][9];
        this.bigBoard = new String[9];
        this.validBoard = new Position(Position.P.ALL);

        for (int i = 0; i < 9; i++) {
            this.bigBoard[i] = "";

            for (int j = 0; j < 9; j++) {
                this.smallBoard[i][j] = "";
            }
        }
    }

    @Override
    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public String getPlayer() {
        return this.player;
    }

    @Override
    public void setSmallBoard(Position big, Position small) {
        this.smallBoard[big.value()][small.value()] = this.player;
    }

    @Override
    public String getSmallBoard(Position big, Position small) {
        return this.smallBoard[big.value()][small.value()];
    }

    @Override
    public void setBigBoard(Position p) {
        this.bigBoard[p.value()] = this.player;
    }

    @Override
    public String getBigBoard(Position p) {
        return this.bigBoard[p.value()];
    }

    @Override
    public void setValidBoard(Position p) {
        this.validBoard = p;
    }

    @Override
    public Position getValidBoard() {
        return this.validBoard;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public UltimateTicTacToe newInstance() {
        return new UltimateTicTacToe1L();
    }

    @Override
    public void transferFrom(UltimateTicTacToe source) {
        this.player = source.getPlayer();
        this.validBoard = source.getValidBoard();

        for (int i = 0; i < 9; i++) {
            this.bigBoard[i] = source.getBigBoard(new Position(i));

            for (int j = 0; j < 9; j++) {
                this.smallBoard[i][j] = source.getSmallBoard(new Position(i),
                        new Position(j));
            }
        }

        source.clear();
    }

}
