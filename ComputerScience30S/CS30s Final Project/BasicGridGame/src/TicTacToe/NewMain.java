/** Required package class namespace */
package TicTacToe;

import javax.swing.JOptionPane;

/**
 * NewMain - the 'opening' class
 *
 * @author Michelle Galinsky
 * @since Jan 10, 2024
 */
public class NewMain {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int countN = 0;

        JOptionPane.showMessageDialog(null,
                "Welcome to Tic Tac Toe",
                Globals.title,
                JOptionPane.PLAIN_MESSAGE);

        namesX();
        namesO();

        TicTacToe ticTacToe = new TicTacToe();
    }

    /**
     * Asks the user for their name and a letter
     */
    private static void namesX() {
        Globals.Xn = JOptionPane.showInputDialog(null,
                "Player 'X' please enter your name:",
                Globals.title,
                JOptionPane.INFORMATION_MESSAGE);

        if (Globals.Xn.equals("")) {
            JOptionPane.showMessageDialog(null, "You need to enter a name");

            Globals.Xn = JOptionPane.showInputDialog(null,
                    "Player 'X' please enter your name:",
                    Globals.title,
                    JOptionPane.INFORMATION_MESSAGE);
        }

        Globals.Xl = JOptionPane.showInputDialog(null,
                Globals.Xn + " please enter your letter:",
                Globals.title,
                JOptionPane.INFORMATION_MESSAGE);

        if (Globals.Xl.equals("")) {
            JOptionPane.showMessageDialog(null, "You need to enter a letter");

            Globals.Xn = JOptionPane.showInputDialog(null,
                    Globals.Xn + " please enter your letter:",
                    Globals.title,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Asks the user for their name and a letter
     */
    private static void namesO() {

        Globals.On = JOptionPane.showInputDialog(null,
                "Player 'O' please enter your name:",
                Globals.title,
                JOptionPane.INFORMATION_MESSAGE);

        if (Globals.On.equals("")) {
            JOptionPane.showMessageDialog(null, "You need to enter a name");

            Globals.On = JOptionPane.showInputDialog(null,
                    "Player 'O' please enter your name:",
                    Globals.title,
                    JOptionPane.INFORMATION_MESSAGE);
        }

        Globals.Ol = JOptionPane.showInputDialog(null,
                Globals.On + " please enter your letter:",
                Globals.title,
                JOptionPane.INFORMATION_MESSAGE);

        if (Globals.Ol.equals("")) {
            JOptionPane.showMessageDialog(null, "You need to enter a letter");

            Globals.On = JOptionPane.showInputDialog(null,
                    Globals.On + " please enter your letter:",
                    Globals.title,
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
