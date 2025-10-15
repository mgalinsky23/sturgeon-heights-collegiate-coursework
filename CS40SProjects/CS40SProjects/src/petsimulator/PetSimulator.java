/** Required package class namespace */
package petsimulator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * PetSimulator - the main class that instantiates the two poodle objects
 *
 * @author Michelle Galinsky
 * @since May 2, 2024
 */
public class PetSimulator {

    public static String title = "The Dog-Gone-Fun Pet shop";
    public static Icon icon = new ImageIcon("C:\\Users\\m.galinsky\\Desktop\\dog.png");

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JOptionPane.showMessageDialog(null, "Welcome to " + title + "\n\n"
                + "A local pet shop you worked for 2 years ago\n"
                + "'" + title + "' has contacted you again\n"
                + "to develop a pet simulator. This will simulate the\n"
                + "type of pet to buy and the fact it will count as a\n"
                + "sale order at the store",
                title, JOptionPane.PLAIN_MESSAGE, icon);

        do {
            Poodle fluffy = new Poodle("Fluffy Pants", 101);
            Poodle scooby = new Poodle("Scooby Doo", 102);
        } while (playAgain());

        JOptionPane.showMessageDialog(null, "Thanks for using " + title,
                title, JOptionPane.PLAIN_MESSAGE, icon);

    }

    private static boolean playAgain() {
        int answer = JOptionPane.showConfirmDialog(
                null, "Do you want to play again?", title,
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
        if (answer == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
