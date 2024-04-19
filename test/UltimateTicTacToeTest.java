import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UltimateTicTacToeTest {

    // creating positions up here to remove duplicates within tests
    UltimateTicTacToeKernel.Position topRight = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.TOP_RIGHT);
    UltimateTicTacToeKernel.Position topMiddle = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.TOP_MIDDLE);
    UltimateTicTacToeKernel.Position topLeft = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.TOP_LEFT);
    UltimateTicTacToeKernel.Position middleRight = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.MIDDLE_RIGHT);
    UltimateTicTacToeKernel.Position middleMiddle = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.MIDDLE_MIDDLE);
    UltimateTicTacToeKernel.Position middleLeft = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.MIDDLE_LEFT);
    UltimateTicTacToeKernel.Position bottomRight = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.BOTTOM_RIGHT);
    UltimateTicTacToeKernel.Position bottomMiddle = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.BOTTOM_MIDDLE);
    UltimateTicTacToeKernel.Position bottomLeft = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.BOTTOM_LEFT);
    UltimateTicTacToeKernel.Position all = new UltimateTicTacToeKernel.Position(
            UltimateTicTacToeKernel.Position.P.ALL);

    /*
     * makeMove tests
     */
    @Test
    public final void testMakeMoveFirstMove() {
        UltimateTicTacToe t = new UltimateTicTacToe1L();
        t.makeMove(this.topRight, this.topLeft);

        assertEquals(t.getPlayer(), "O");
        assertEquals(t.getSmallBoard(this.topRight, this.topLeft), "X");
        assertEquals(t.getBigBoard(this.topRight), "");
        assertEquals(t.getValidBoard(), this.topLeft);
    }

    @Test
    public final void testMakeMoveBigBoardWinner() {
        UltimateTicTacToe t = new UltimateTicTacToe1L();

        t.makeMove(this.topRight, this.topLeft);
        t.makeMove(this.topLeft, this.topRight);
        t.makeMove(this.topRight, this.topMiddle);
        t.makeMove(this.topMiddle, this.topRight);
        t.makeMove(this.topRight, this.topRight);

        assertEquals(t.getBigBoard(this.topRight), "X");
    }

    /*
     * getWinner tests
     */
    @Test
    public final void testGetWinnerEmpty() {
        UltimateTicTacToe t = new UltimateTicTacToe1L();
        assertEquals(t.getWinner(), "");
    }

    @Test
    public final void testGetWinnerPlayer() {
        UltimateTicTacToe t = new UltimateTicTacToe1L();

        t.makeMove(this.topRight, this.topLeft);
        t.makeMove(this.topLeft, this.topRight);
        t.makeMove(this.topRight, this.topMiddle);
        t.makeMove(this.topMiddle, this.topRight);
        t.makeMove(this.topRight, this.topRight);
        t.makeMove(this.middleMiddle, this.topMiddle);

        t.makeMove(this.topMiddle, this.bottomLeft);
        t.makeMove(this.bottomLeft, this.topMiddle);
        t.makeMove(this.topMiddle, this.bottomMiddle);
        t.makeMove(this.bottomMiddle, this.topMiddle);
        t.makeMove(this.topMiddle, this.bottomRight);
        t.makeMove(this.bottomLeft, this.topLeft);

        t.makeMove(this.topLeft, this.middleLeft);
        t.makeMove(this.middleLeft, this.topLeft);
        t.makeMove(this.topLeft, this.middleMiddle);
        t.makeMove(this.middleMiddle, this.topLeft);
        t.makeMove(this.topLeft, this.middleRight);

        assertEquals(t.getWinner(), "X");
    }

}
