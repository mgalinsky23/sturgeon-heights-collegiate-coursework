package TicTacToe;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The Main Tic tac toe class
 *
 * @author m.galinsky
 */
public class TicTacToe extends javax.swing.JFrame {

    static int count = 0;
    static final String ROWX = Globals.Xn + " wins at row ";
    static final String ROWO = Globals.On + " wins at row ";
    static final String COLUMNX = Globals.Xn + " wins at column ";
    static final String COLUMNO = Globals.On + " wins at column ";
    static final String DIAGONALX = Globals.Xn + " wins in the diagonal";
    static final String DIAGONALO = Globals.On + " wins in the diagonal";
    static final String XLETTER = Globals.Xl;
    static final String OLETTER = Globals.Ol;

    /**
     * Creates new form TicTacToe
     */
    public TicTacToe() {
        initComponents();

        matrix[0][0] = cellLabel00;
        matrix[0][1] = cellLabel01;
        matrix[0][2] = cellLabel02;

        matrix[1][0] = cellLabel10;
        matrix[1][1] = cellLabel11;
        matrix[1][2] = cellLabel12;

        matrix[2][0] = cellLabel20;
        matrix[2][1] = cellLabel21;
        matrix[2][2] = cellLabel22;

        Image image = new ImageIcon(getClass().getResource("/TicTacToe/tic-tac-toe.png")).getImage();

        this.setIconImage(image);

        this.setResizable(false);

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                final int ROW = row;
                final int COLUMN = column;
                matrix[row][column].addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        clickMouse(ROW, COLUMN);
                    }
                });
            }
        }
        this.setSize(286, 279);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * What happens when a user clicks on a square (in the code)
     *
     * @param row the row that the square is in
     * @param column the column that the square is in
     */
    private void clickMouse(int row, int column) {
        click(row, column);
        count++;
        if (count >= 5) {
            String win = checkWin();
            if (!win.equals("")) {
                JOptionPane.showMessageDialog(null, win);
                if (playAgain() == true) {
                    this.dispose();
                    count = 0;
                    TicTacToe ticTacToe = new TicTacToe();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Thanks for playing TicTacToe",
                            Globals.title,
                            JOptionPane.PLAIN_MESSAGE
                    );
                    System.exit(0);
                }
            } else if (win.equals("") && count == 9) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                if (playAgain() == true) {
                    this.dispose();
                    count = 0;
                    TicTacToe ticTacToe = new TicTacToe();
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Thanks for playing TicTacToe",
                            Globals.title,
                            JOptionPane.PLAIN_MESSAGE
                    );
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Displays a message to the user to see if they want to continue playing
     *
     * @return true (yes), false (no)
     */
    private static boolean playAgain() {
        return yesNo("Do you want to play again?");
    }

    /**
     * Ask the user a yes and no question, in a confirm dialog box
     *
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    private static boolean yesNo(String text) {
        int response = JOptionPane.showConfirmDialog(null, text, Globals.title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is what happens when the user clicks on a label (user interface)
     *
     * @param row what row the label is in
     * @param column what column the label is in
     */
    private void click(int row, int column) {
        if (count % 2 == 0 && matrix[row][column].getText().equals("")) {
            matrix[row][column].setText(Globals.Xl);
            matrix[row][column].setBackground(Color.blue);
        } else if (count % 2 != 0 && matrix[row][column].getText().equals("")) {
            matrix[row][column].setText(Globals.Ol);
            matrix[row][column].setBackground(Color.yellow);
        } else {
            JOptionPane.showMessageDialog(null, "You need to chose a different square");
            count--;
        }
    }

    /**
     * Checks to see if someone won
     *
     * @return the player who won
     */
    private String checkWin() {
        String text = "";
        if (text.equals("")) {
            text = checkWinsGoingDown();
        }
        if (text.equals("")) {
            text = checkWinsGoingAcross();
        }
        if (text.equals("")) {
            text = checkWinsGoingDiagonally();
        }
        return text;
    }

    /**
     * Checks to see if a player won diagonally
     *
     * @return the player who won
     */
    private String checkWinsGoingDiagonally() {
        String text = "";
        // Loops through the diagonals
        if (matrix[0][0].getText().equals(Globals.Xl)
                && matrix[1][1].getText().equals(Globals.Xl)
                && matrix[2][2].getText().equals(Globals.Xl)) {
            text = DIAGONALX;
            return text;
        } else if (matrix[0][2].getText().equals(Globals.Xl)
                && matrix[1][1].getText().equals(Globals.Xl)
                && matrix[2][0].getText().equals(Globals.Xl)) {
            text = DIAGONALX;
            return text;
        }
        if (matrix[0][0].getText().equals(Globals.Ol)
                && matrix[1][1].getText().equals(Globals.Ol)
                && matrix[2][2].getText().equals(Globals.Ol)) {
            text = DIAGONALO;
            return text;
        } else if (matrix[0][2].getText().equals(Globals.Ol)
                && matrix[1][1].getText().equals(Globals.Ol)
                && matrix[2][0].getText().equals(Globals.Ol)) {
            text = DIAGONALO;
            return text;
        }
        return text;
    }

    /**
     * Checks to see if a player won going across
     *
     * @return the player who won
     */
    private String checkWinsGoingAcross() {
        String text = "";
        // Loops through the rows
        for (int row = 0; row < 3; row++) {
            if (matrix[row][0].getText().equals(Globals.Xl)
                    && matrix[row][1].getText().equals(Globals.Xl)
                    && matrix[row][2].getText().equals(Globals.Xl)) {
                text = ROWX + row;
                return text;
            } else if (matrix[row][0].getText().equals(Globals.Ol)
                    && matrix[row][1].getText().equals(Globals.Ol)
                    && matrix[row][2].getText().equals(Globals.Ol)) {
                text = ROWO + row;
                return text;
            }
        }
        return text;
    }

    /**
     * Checks to see if someone won going down
     *
     * @return the player who won
     */
    private String checkWinsGoingDown() {
        String text = "";
        // Loops through the columns
        for (int column = 0; column < 3; column++) {
            if (matrix[0][column].getText().equals(Globals.Xl)
                    && matrix[1][column].getText().equals(Globals.Xl)
                    && matrix[2][column].getText().equals(Globals.Xl)) {
                text = COLUMNX + column;
                return text;
            } else if (matrix[0][column].getText().equals(Globals.Ol)
                    && matrix[1][column].getText().equals(Globals.Ol)
                    && matrix[2][column].getText().equals(Globals.Ol)) {
                text = COLUMNO + column;
                return text;
            }
        }
        return text;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cellLabel00 = new javax.swing.JLabel();
        cellLabel01 = new javax.swing.JLabel();
        cellLabel02 = new javax.swing.JLabel();
        cellLabel10 = new javax.swing.JLabel();
        cellLabel11 = new javax.swing.JLabel();
        cellLabel12 = new javax.swing.JLabel();
        cellLabel20 = new javax.swing.JLabel();
        cellLabel21 = new javax.swing.JLabel();
        cellLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        getContentPane().setLayout(null);

        cellLabel00.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel00.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel00.setOpaque(true);
        getContentPane().add(cellLabel00);
        cellLabel00.setBounds(0, 0, 90, 80);

        cellLabel01.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel01.setOpaque(true);
        getContentPane().add(cellLabel01);
        cellLabel01.setBounds(90, 0, 90, 80);

        cellLabel02.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel02.setOpaque(true);
        getContentPane().add(cellLabel02);
        cellLabel02.setBounds(180, 0, 90, 80);

        cellLabel10.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel10.setOpaque(true);
        getContentPane().add(cellLabel10);
        cellLabel10.setBounds(0, 80, 90, 80);

        cellLabel11.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel11.setOpaque(true);
        getContentPane().add(cellLabel11);
        cellLabel11.setBounds(90, 80, 90, 80);

        cellLabel12.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel12.setOpaque(true);
        getContentPane().add(cellLabel12);
        cellLabel12.setBounds(180, 80, 90, 80);

        cellLabel20.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel20.setOpaque(true);
        getContentPane().add(cellLabel20);
        cellLabel20.setBounds(0, 160, 90, 80);

        cellLabel21.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel21.setOpaque(true);
        getContentPane().add(cellLabel21);
        cellLabel21.setBounds(90, 160, 90, 80);

        cellLabel22.setBackground(new java.awt.Color(255, 255, 255));
        cellLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cellLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cellLabel22.setOpaque(true);
        getContentPane().add(cellLabel22);
        cellLabel22.setBounds(180, 160, 90, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cellLabel00;
    private javax.swing.JLabel cellLabel01;
    private javax.swing.JLabel cellLabel02;
    private javax.swing.JLabel cellLabel10;
    private javax.swing.JLabel cellLabel11;
    private javax.swing.JLabel cellLabel12;
    private javax.swing.JLabel cellLabel20;
    private javax.swing.JLabel cellLabel21;
    private javax.swing.JLabel cellLabel22;
    // End of variables declaration//GEN-END:variables

    final int ROWS = 3;
    final int COLUMNS = 3;

    JLabel[][] matrix = new JLabel[ROWS][COLUMNS];

}
