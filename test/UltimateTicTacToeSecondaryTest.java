import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UltimateTicTacToeSecondaryTest {

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
     * toString tests
     */
    @Test
    public final void testToStringEmpty() {
        UltimateTicTacToeSecondary t = new UltimateTicTacToe1L();
        assertEquals(t.toString(),
                "\n\n" + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n" + "\n"
                        + "\n" + "Player X's Turn\n"
                        + "You can go in any square that isn't complete.");
    }

    @Test
    public final void testToStringFirst() {
        UltimateTicTacToeSecondary t = new UltimateTicTacToe1L();
        t.makeMove(this.topRight, this.topLeft);

        assertEquals(t.toString(),
                "\n\n" + "    |   |    |    |   |    |  X |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n" + "\n"
                        + "\n" + "Player O's Turn\n"
                        + "You have to go in the top left square.");
    }

    @Test
    public final void testToStringBigBoardWon() {
        UltimateTicTacToeSecondary t = new UltimateTicTacToe1L();

        t.makeMove(this.topRight, this.topLeft);
        t.makeMove(this.topLeft, this.topRight);
        t.makeMove(this.topRight, this.topMiddle);
        t.makeMove(this.topMiddle, this.topRight);
        t.makeMove(this.topRight, this.topRight);

        assertEquals(t.toString(),
                "\n\n" + "    |   | O  |    |   | O  |             \n"
                        + " ----------- | ----------- |             \n"
                        + "    |   |    |    |   |    |      X      \n"
                        + " ----------- | ----------- |             \n"
                        + "    |   |    |    |   |    |             \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n" + "\n"
                        + "\n" + "Player O's Turn\n"
                        + "You can go in any square that isn't complete.");
    }

    @Test
    public final void testToStringWinner() {
        UltimateTicTacToeSecondary t = new UltimateTicTacToe1L();

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

        assertEquals(t.toString(),
                "\n" + "\n" + "             |             |             \n"
                        + "             |             |             \n"
                        + "      X      |      X      |      X      \n"
                        + "             |             |             \n"
                        + "             |             |             \n"
                        + "-------------+-------------+-------------\n"
                        + "  O |   |    |  O | O |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + "-------------+-------------+-------------\n"
                        + "  O | O |    |    | O |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n"
                        + " ----------- | ----------- | ----------- \n"
                        + "    |   |    |    |   |    |    |   |    \n" + "\n"
                        + "\n" + "Player X Wins!");
    }

    /*
     * equals tests
     */
    @Test
    public final void testEqualsTrue() {
        UltimateTicTacToeSecondary t1 = new UltimateTicTacToe1L();
        UltimateTicTacToeSecondary t2 = new UltimateTicTacToe1L();

        t1.makeMove(this.bottomRight, this.topRight);
        t2.makeMove(this.bottomRight, this.topRight);

        assertEquals(t1.equals(t2), true);
    }

    @Test
    public final void testEqualsFalse() {
        UltimateTicTacToeSecondary t1 = new UltimateTicTacToe1L();
        UltimateTicTacToeSecondary t2 = new UltimateTicTacToe1L();

        t1.makeMove(this.bottomRight, this.topRight);

        assertEquals(t1.equals(t2), false);
    }

}
