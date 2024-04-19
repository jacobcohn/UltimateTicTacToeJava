import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class HeadToHead {

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

    private static void playGame(SimpleWriter out) {
        SimpleReader in = new SimpleReader1L();
        UltimateTicTacToe1L t = new UltimateTicTacToe1L();
        out.println(t);

        while (t.getWinner().equals("")) {
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

        in.close();
    }

    public static void main(String args[]) {
        SimpleWriter out = new SimpleWriter1L();

        printDirections(out);
        playGame(out);

        out.close();
    }
}
