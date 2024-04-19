
/**
 * Layered implementations of secondary methods for {@code SimpleWriter}.
 */
public abstract class UltimateTicTacToeSecondary implements UltimateTicTacToe {

    private static String checkCombination(String[] board, int[] combination) {
        if (board[combination[0]].equals(board[combination[1]])
                && board[combination[0]].equals(board[combination[2]])) {
            return board[combination[0]];
        }

        return "";
    }

    private static String getTicTacToeWinner(String[] board) {
        // check rows
        for (int i = 0; i < 9; i += 3) {
            int combination[] = { i, i + 1, i + 2 };

            String winner = checkCombination(board, combination);
            if (!winner.equals("")) {
                return winner;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            int combination[] = { i, i + 3, i + 6 };

            String winner = checkCombination(board, combination);
            if (!winner.equals("")) {
                return winner;
            }
        }

        // check diagonal
        for (int i = 4; i > 0; i -= 2) {
            int combination[] = { 4 - i, 4, 4 + i };

            String winner = checkCombination(board, combination);
            if (!winner.equals("")) {
                return winner;
            }
        }

        // base case
        return "";
    }

    private void updateBigBoard(Position big, Position small) {
        String[] updatedBoard = new String[9];
        for (int i = 0; i < 9; i++) {
            updatedBoard[i] = this.getSmallBoard(big, new Position(i));
        }

        if (!getTicTacToeWinner(updatedBoard).equals("")) {
            this.setBigBoard(big);
        }
    }

    private void updateValidBoard(Position p) {
        if (!this.getBigBoard(p).equals("")) {
            this.setValidBoard(new Position(Position.P.ALL));
        } else {
            this.setValidBoard(p);
        }
    }

    private void updatePlayer() {
        String currentPlayer = this.getPlayer();

        if (currentPlayer.equals("X")) {
            this.setPlayer("O");
        } else {
            this.setPlayer("X");
        }
    }

    @Override
    public void makeMove(Position big, Position small) {
        this.setSmallBoard(big, small);
        this.updateBigBoard(big, small);
        this.updateValidBoard(small);
        this.updatePlayer();
    }

    @Override
    public String getWinner() {
        String[] bigBoard = new String[9];
        for (int i = 0; i < 9; i++) {
            bigBoard[i] = this.getBigBoard(new Position(i));
        }

        return getTicTacToeWinner(bigBoard);
    }

    /*
     * Common methods (from Object) -------------------------------------------
     */

    private int getIndex(int x, int y) {
        return 3 * x + y;
    }

    private String boardToString() {
        String str = "";

        int bigRow;
        int smallRow;
        int bigCol;
        int smallCol;

        int bigBoard;
        int smallBoard;
        String bigMove;
        String smallMove;

        for (bigRow = 0; bigRow < 3; bigRow++) {
            for (smallRow = 0; smallRow < 3; smallRow++) {
                for (bigCol = 0; bigCol < 3; bigCol++) {
                    str += " ";

                    for (smallCol = 0; smallCol < 3; smallCol++) {
                        bigBoard = this.getIndex(bigRow, bigCol);
                        smallBoard = this.getIndex(smallRow, smallCol);

                        bigMove = this.getBigBoard(new Position(bigBoard));
                        smallMove = this.getSmallBoard(new Position(bigBoard),
                                new Position(smallBoard));

                        // checks if the big board game is completed
                        if (bigMove.equals("")) {
                            // adds move
                            str += " ";
                            if (smallMove.equals("")) {
                                str += " ";
                            } else {
                                str += smallMove;
                            }
                            str += " ";

                            // adds divider on small board
                            if (smallCol < 2) {
                                str += "|";
                            } else {
                                str += " ";
                            }
                        } else {
                            if (smallCol == 0) {
                                // adds bigBoard move only once
                                if (smallRow == 1) {
                                    str += "     ";
                                    str += bigMove;
                                    str += "      ";
                                } else {
                                    str += "            ";
                                }
                            }

                        }
                    }

                    if (bigCol < 2) {
                        // add bigBoard divider
                        str += "|";
                    } else {
                        // adds next line
                        str += "\n";

                    }
                }

                if (smallRow < 2) {
                    for (bigCol = 0; bigCol < 3; bigCol++) {
                        bigBoard = this.getIndex(bigRow, bigCol);
                        bigMove = this.getBigBoard(new Position(bigBoard));

                        if (bigMove.equals("")) {
                            str += " ----------- ";
                        } else {
                            str += "             ";
                        }

                        if (bigCol < 2) {
                            str += "|";
                        } else {
                            str += "\n";
                        }
                    }
                }
            }

            if (bigRow < 2) {
                str += "-------------+-------------+-------------\n";
            }
        }

        return str;
    }

    private String playerToString() {
        return "Player " + this.getPlayer() + "'s Turn";
    }

    private String validBoardToString() {
        switch (this.getValidBoard().value()) {
            case 0:
                return "You have to go in the top left square.";
            case 1:
                return "You have to go in the top middle square.";
            case 2:
                return "You have to go in the top right square.";
            case 3:
                return "You have to go in the middle left square.";
            case 4:
                return "You have to go in the middle middle square.";
            case 5:
                return "You have to go in the middle right square.";
            case 6:
                return "You have to go in the bottom left square.";
            case 7:
                return "You have to go in the bottom middle square.";
            case 8:
                return "You have to go in the bottom right square.";
            case -1:
                return "You can go in any square that isn't complete.";
            default:
                return null;
        }
    }

    private String winnerToString() {
        return "Player " + this.getWinner() + " Wins!";
    }

    @Override
    public String toString() {
        String str = "\n\n";

        str += this.boardToString();
        str += "\n\n";
        if (this.getWinner().equals("")) {
            str += this.playerToString();
            str += "\n";
            str += this.validBoardToString();
        } else {
            str += this.winnerToString();
        }

        return str;
    }

    @Override
    public boolean equals(Object obj) {
        UltimateTicTacToe other = (UltimateTicTacToe) obj;

        // check player
        if (!this.getPlayer().equals(other.getPlayer())) {
            return false;
        }

        // check smallBoard
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!this.getSmallBoard(new Position(i), new Position(j))
                        .equals(this.getSmallBoard(new Position(i),
                                new Position(j)))) {
                    return false;
                }
            }
        }

        // check bigBoard
        for (int i = 0; i < 9; i++) {
            if (!this.getBigBoard(new Position(i))
                    .equals(this.getBigBoard(new Position(i)))) {
                return false;
            }
        }

        // check validBoard
        if (this.getValidBoard() != other.getValidBoard()) {
            return false;
        }

        return true;
    }
}
