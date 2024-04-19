import java.util.Random;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class Bot {

    private static void printDirections(SimpleWriter out) {
        out.println("Welcome to Ultimate Tic Tac Toe\n");
        out.println("0 is top left corner");
        out.println("1 is top middle corner");
        out.println("2 is top right corner");
        out.println("3 is middle left corner");
        out.println("4 is middle middle corner");
        out.println("5 is middle right corner");
        out.println("6 is bottom left corner");
        out.println("7 is bottom middle corner");
        out.println("8 is bottom right corner\n\n");
    }

    private static void makePlayerMove(UltimateTicTacToe1L t, SimpleReader in,
            SimpleWriter out) {
        out.print("Enter the big board: ");
        int bigInt = in.nextInteger();
        UltimateTicTacToeKernel.Position big = new UltimateTicTacToeKernel.Position(
                bigInt);

        out.print("Enter the small board: ");
        int smallInt = in.nextInteger();
        UltimateTicTacToeKernel.Position small = new UltimateTicTacToeKernel.Position(
                smallInt);

        t.makeMove(big, small);
        out.println(t);
    }

    private static int getRandomNumber0through8() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private static UltimateTicTacToeKernel.Position getRandomValidBigBoard(
            UltimateTicTacToe1L t) {
        int validBoard = t.getValidBoard().value();

        int big = getRandomNumber0through8();
        if (validBoard == -1) {
            while (!t.getBigBoard(new UltimateTicTacToeKernel.Position(big))
                    .equals("")) {
                big = getRandomNumber0through8();
            }
        } else {
            big = validBoard;
        }

        return new UltimateTicTacToeKernel.Position(big);
    }

    private static UltimateTicTacToeKernel.Position getRandomValidSmallBoard(
            UltimateTicTacToe1L t, UltimateTicTacToeKernel.Position big) {
        int small = getRandomNumber0through8();

        while (!t
                .getSmallBoard(big, new UltimateTicTacToeKernel.Position(small))
                .equals("")) {
            small = getRandomNumber0through8();
        }

        return new UltimateTicTacToeKernel.Position(small);
    }

    private static void makeBotMove(UltimateTicTacToe1L t, SimpleWriter out) {
        UltimateTicTacToeKernel.Position big = getRandomValidBigBoard(t);
        UltimateTicTacToeKernel.Position small = getRandomValidSmallBoard(t,
                big);

        out.println(small.value());
        out.println(big.value());

        t.makeMove(big, small);
        out.println(t);
    }

    private static void playGame(SimpleWriter out) {
        SimpleReader in = new SimpleReader1L();
        UltimateTicTacToe1L t = new UltimateTicTacToe1L();
        out.println(t);

        boolean isPlayerTurn = true;
        while (t.getWinner().equals("")) {
            if (isPlayerTurn) {
                makePlayerMove(t, in, out);
                isPlayerTurn = false;
            } else {
                makeBotMove(t, out);
                isPlayerTurn = true;
            }
        }

        in.close();
    }

    public static void main(String args[]) {
        SimpleWriter out = new SimpleWriter1L();

        printDirections(out);
        playGame(out);

        out.close();
    }
}