import components.standard.Standard;

public interface UltimateTicTacToeKernel extends Standard<UltimateTicTacToe> {

    public static class Position {

        public enum P {
            TOP_LEFT, TOP_MIDDLE, TOP_RIGHT, MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT, BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT, ALL;
        }

        private P value;

        public Position(P value) {
            this.value = value;
        }

        public Position(int value) {
            switch (value) {
                case 0:
                    this.value = P.TOP_LEFT;
                    break;
                case 1:
                    this.value = P.TOP_MIDDLE;
                    break;
                case 2:
                    this.value = P.TOP_RIGHT;
                    break;
                case 3:
                    this.value = P.MIDDLE_LEFT;
                    break;
                case 4:
                    this.value = P.MIDDLE_MIDDLE;
                    break;
                case 5:
                    this.value = P.MIDDLE_RIGHT;
                    break;
                case 6:
                    this.value = P.BOTTOM_LEFT;
                    break;
                case 7:
                    this.value = P.BOTTOM_MIDDLE;
                    break;
                case 8:
                    this.value = P.BOTTOM_RIGHT;
                    break;
                case -1:
                    this.value = P.ALL;
                    break;
                default:
                    this.value = P.ALL;
            }
        }

        public int value() {
            switch (this.value) {
                case TOP_LEFT:
                    return 0;
                case TOP_MIDDLE:
                    return 1;
                case TOP_RIGHT:
                    return 2;
                case MIDDLE_LEFT:
                    return 3;
                case MIDDLE_MIDDLE:
                    return 4;
                case MIDDLE_RIGHT:
                    return 5;
                case BOTTOM_LEFT:
                    return 6;
                case BOTTOM_MIDDLE:
                    return 7;
                case BOTTOM_RIGHT:
                    return 8;
                case ALL:
                    return -1;
                default:
                    return -1;
            }
        }

    }

    /*
     * Updates the current player
     *
     * @param player the {@code this.player} is set to {@code player}
     *
     * @updates {@code this.player}
     *
     * @requires {@code player = "X" || player = "O"}
     *
     * @ensures this.player = player
     */
    void setPlayer(String player);

    /*
     * Returns the current player
     *
     * @ensures {@code this.player = #this.player}
     *
     * @returns {@code this.player}
     */
    String getPlayer();

    /*
     * Adds a move to the game
     *
     * @param big the position in the big board
     *
     * @param small the position in the small board
     *
     * @updates {@code this.smallBoard}
     *
     * @requires {@code #this.smallBoard[big.value()][small.value()] = "" &&
     * #this.bigBoard[big.value()] = "" && big != ALL && small != ALL}
     *
     * @ensures {@code this.smallBoard[big.value()][small.value()] =
     * #this.player}
     */
    void setSmallBoard(Position big, Position small);

    /*
     * Returns a move of the game
     *
     * @param big the position in the big board
     *
     * @param small the position in the small board
     *
     * @requires {@code big != ALL && small != ALL}
     *
     * @ensures {@code this.smallBoard = #this.smallBoard}
     *
     * @returns {@code this.smallBoard[big.value()][small.value()]}
     */
    String getSmallBoard(Position big, Position small);

    /*
     * Adds a winner to a single board to the game
     *
     * @param board the position in the big board
     *
     * @updates {@code this.bigBoard}
     *
     * @requires {@code p != ALL && #this.bigBoard[big.value()] = ""}
     *
     * @ensures {@code this.bigBoard[p.value()] = #this.player}
     *
     * @returns {@code this.bigBoard[p.value()}
     */
    void setBigBoard(Position p);

    /*
     * Returns the winner to a single board to the game
     *
     * @param board the position in the big board
     *
     * @requires {@code p != ALL}
     *
     * @ensures {@code this.bigBoard[p.value()] = #this.bigBoard[board]}
     *
     * @returns {@code this.bigBoard[p.value()}
     */
    String getBigBoard(Position p);

    /*
     * Sets the board to which the next player can play
     *
     * @param board the position in the big board
     *
     * @updates {@code this.validBoard}
     *
     * @ensures {@code this.bigBoard[p.value()] = #this.bigBoard[p.value()] &&
     * -1 <= this.validBoard < 9}
     */
    void setValidBoard(Position p);

    /*
     * Gets the board to which the next player can play
     *
     * @returns {@code this.validBoard}
     */
    Position getValidBoard();

}
