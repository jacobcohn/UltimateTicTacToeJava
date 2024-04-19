
/**
 * {@code UltimateTicTacToeKernel} enhanced with secondary methods.
 */
public interface UltimateTicTacToe extends UltimateTicTacToeKernel {

    /*
     * Makes a move for the player
     *
     * @param big the position in the big board
     *
     * @param small the position in the small board
     *
     * @updates {@code this.smallBoard this.bigBoard this.player}
     *
     * @requires {@code big != ALL && small != ALL &&
     * #this.smallBoard[big.value()][small.value()] = "" &&
     * #this.bigBoard[big.value()] = ""}
     *
     * @ensures {@code this.smallBoard[big.value()][small.value()] =
     * #this.player} && possibly (@code this.bigBoard[big.value()] =
     * #this.player} && {@code this.player != #this.player}
     */
    void makeMove(Position big, Position small);

    /*
     * Determines the winner of the game
     *
     * @ensures {@code this.player = #this.player && this.smallBoard =
     * #this.smallBoard && this.bigBoard = #this.bigBoard}
     *
     * @returns {@code "X" || "O" || ""}
     */
    String getWinner();
}
