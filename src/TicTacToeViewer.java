import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame
{
    // TODO: Complete this class

    private Image[] playerSide;
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 700;
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
        Square[][] board = t.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].draw(g, i, j);
            }
        }


    }
    // do it on its own paint
    // g.String to draw axes and then set the font

}
