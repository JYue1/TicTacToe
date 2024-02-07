import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {
    private TicTacToeViewer window;
    private Image oImage, xImage;
    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(TicTacToeViewer window, int row, int col) {
        this.window = window;
        this.row = row;
        this.col = col;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        oImage = window.getImages()[0];
        xImage = window.getImages()[1];
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }


    // Marker
    // if marker = x
    // set the box to x or o
    // if winningsquare = true
    // set all the winningsqure boxes to green
    public void draw(Graphics g, int row, int col) {
        // C.T. Can utilize class-scope instance variables and local parameters in methods.
        if (isWinningSquare == true) {
        g.setColor(Color.GREEN);
        g.drawRect(150 + (col * 150), 150 + (row * 150), 150, 150);
        g.fillRect(150 + (col * 150), 150 + (row * 150), 150, 150);
        g.setColor(Color.BLACK);
         }

        // Border/Grid
        g.setColor(Color.BLACK);
        g.drawRect(150 + (row * 150), 150 + (col * 150), 150, 150);

        // Row Axis
        g.setFont(new Font("Serif", Font.BOLD, 40));
        g.drawString("1", 225, 100);
        g.drawString("2", 375, 100);
        g.drawString("3", 525, 100);

        // Col Axis
        g.drawString("1", 100, 225);
        g.drawString("2", 100, 375);
        g.drawString("3", 100, 525);

//        for (int i = 0; i < 3; i++) {
//            g.drawString("i", 225 + (i * 150), 100)
//            g.drawString("i", 100, 225 + (i * 150))
//        }

        // C.T. Can use if, while, and for.
        if (marker.equals("O")) {
            g.drawImage(oImage, 150 + (col  * 150), 150 + (row * 150), 150, 150, window);
        }
        else if (marker.equals("X")) {
            g.drawImage(xImage, 150 + (col  * 150), 150 + (row * 150), 150, 150, window);
        }


    }

}
