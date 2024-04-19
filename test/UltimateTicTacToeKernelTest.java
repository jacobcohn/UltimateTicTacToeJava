import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UltimateTicTacToeKernelTest {

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
     * constructor tests
     */
    @Test
    public final void testPositionConstructorP() {
        UltimateTicTacToeKernel.Position p = new UltimateTicTacToe.Position(
                UltimateTicTacToeKernel.Position.P.TOP_LEFT);
        assertEquals(p.value(), 0);
    }

    @Test
    public final void testPositionConstructorInt() {
        UltimateTicTacToeKernel.Position p = new UltimateTicTacToe.Position(2);
        assertEquals(p.value(), 2);
    }

    /*
     * value tests
     */
    @Test
    public final void testValue() {
        UltimateTicTacToeKernel.Position p = new UltimateTicTacToe.Position(5);
        assertEquals(p.value(), 5);
    }

    /*
     * setPlayer tests
     */
    @Test
    public final void testSetPlayerX() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        t.setPlayer("X");
        assertEquals(t.getPlayer(), "X");
    }

    @Test
    public final void testSetPlayerO() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        t.setPlayer("O");
        assertEquals(t.getPlayer(), "O");
    }

    /*
     * getPlayer tests
     */
    @Test
    public final void testGetPlayerX() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        t.setPlayer("X");
        assertEquals(t.getPlayer(), "X");
    }

    @Test
    public final void testGetPlayerO() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        t.setPlayer("O");
        assertEquals(t.getPlayer(), "O");
    }

    /*
     * setSmallBoard tests
     */
    @Test
    public final void testSetSmallBoardFirstMove() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setSmallBoard(this.topRight, this.middleMiddle);
        assertEquals(t.getSmallBoard(this.topRight, this.middleMiddle), "X");
    }

    @Test
    public final void testSetSmallBoardSecondMove() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setSmallBoard(this.topRight, this.middleMiddle);
        t.setSmallBoard(this.topLeft, this.middleMiddle);
        assertEquals(t.getSmallBoard(this.topLeft, this.middleMiddle), "X");
    }

    /*
     * getSmallBoard tests
     */
    @Test
    public final void testGetSmallBoardFirstMoveEmpty() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        assertEquals(t.getSmallBoard(this.topLeft, this.middleMiddle), "");
    }

    @Test
    public final void testGetSmallBoardFirstMovePlayer() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setSmallBoard(this.topRight, this.middleMiddle);
        assertEquals(t.getSmallBoard(this.topRight, this.middleMiddle), "X");
    }

    /*
     * setBigBoard tests
     */
    @Test
    public final void testSetBigBoard() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setBigBoard(this.topLeft);
        assertEquals(t.getBigBoard(this.topLeft), "X");
    }

    /*
     * getBigBoard tests
     */
    @Test
    public final void testGetBigBoardEmpty() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();
        assertEquals(t.getBigBoard(this.topLeft), "");
    }

    @Test
    public final void testGetBigBoardPlayer() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setBigBoard(this.topRight);
        assertEquals(t.getBigBoard(this.topRight), "X");
    }

    /*
     * setValidBoard tests
     */
    @Test
    public final void testSetValidBoardAll() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setValidBoard(this.all);
        assertEquals(t.getValidBoard(), this.all);
    }

    @Test
    public final void testSetValidBoardSpecific() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setValidBoard(this.topLeft);
        assertEquals(t.getValidBoard(), this.topLeft);
    }

    /*
     * setValidBoard tests
     */
    @Test
    public final void testGetValidBoardAny() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setValidBoard(this.all);
        assertEquals(t.getValidBoard(), this.all);
    }

    @Test
    public final void testGetValidBoardSpecific() {
        UltimateTicTacToeKernel t = new UltimateTicTacToe1L();

        t.setValidBoard(this.topLeft);
        assertEquals(t.getValidBoard(), this.topLeft);
    }

}
