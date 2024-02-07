import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame
{
    // TODO: Complete this class

    private Image[] playerSide;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private TicTacToe t;

    public TicTacToeViewer(TicTacToe t)  {
        this.t = t;

        playerSide = new Image[2];
        playerSide[0] = new ImageIcon("Resources/O.png").getImage();
        playerSide[1] = new ImageIcon("Resources/X.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getImages() {
        return playerSide;
    }

    // the board is filled with empty squares at first where you can input the X's and O's
    // this.window is in the TicTacToe (front end) and TicTacToeViewer has the myPaint where it is telling the square to draw itself
    public void paint(Graphics g) {
        // C.T. Can utilize class-scope instance variables and local parameters in methods.
        // C.T. Understand how to use nesting to embed loops and conditionals inside of other loops and conditionals.
        // C.T. Can write nested for-loops to traverse 2D arrays.
        Square[][] board = t.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].draw(g, i, j);
            }
        }

        // C.T. Can use if, while, and for.
        if (t.getWinner().equals("X")) {
            g.drawString("X Wins", 325, 650);
        }
        else if (t.getWinner().equals("O")) {
            g.drawString("O Wins", 325, 650);
        }
        else if (t.checkTie() == true) {
            g.drawString("Tie", 325, 650);
        }


    }

}
