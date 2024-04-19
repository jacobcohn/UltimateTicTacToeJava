import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UltimateTicTacToe1LTest {

    /*
     * constructor tests
     */
    @Test
    public final void testContructor() {
        UltimateTicTacToe t = new UltimateTicTacToe1L();

        assertEquals(t.getPlayer(), "X");
        assertEquals(t.getValidBoard().value(), -1);

        for (int i = 0; i < 9; i++) {
            UltimateTicTacToeKernel.Position iPos = new UltimateTicTacToeKernel.Position(
                    i);
            assertEquals(t.getBigBoard(iPos), "");

            for (int j = 0; j < 9; j++) {
                UltimateTicTacToeKernel.Position jPos = new UltimateTicTacToeKernel.Position(
                        j);

                assertEquals(t.getSmallBoard(iPos, jPos), "");
            }
        }
    }

}
