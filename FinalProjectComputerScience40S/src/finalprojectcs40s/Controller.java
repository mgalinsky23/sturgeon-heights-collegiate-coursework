/** Required package class namespace */
package finalprojectcs40s;

/** Required API imports */
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

 
/**
 * Controller.java - a class launched from main that start the application
 *
 * @author Michelle Galinsky
 * @since May 16, 2024
 */
public class Controller 
{

    public static String title = "Hero Battle";

    public static MainUI mainUI;
    public static Countdown countdown;
    public static WelcomeForm welcomeForm;
    

    /**
     * Default constructor, set class properties
     */
    public Controller() {
        // Get user password input
        String pass1 = input("Please create a password (without numbers):");
        // Verify input
        while (!(pass1 instanceof String) || pass1.equals("")) {
            pass1 = input("Try again:");
        }
        // Confirm password with user input
        String pass2 = input("Please rewrite your password to confirm:");
        // Verify input
        while (!pass1.equals(pass2)) {
            pass2 = input("The passwords don't match, retry here:");
        }
        // Display instructions
        output("Game Instructions:\n"
                + "1)When pressing a button that applies to your hero type, "
                + "the action will only last for 15 seconds','\n"
                + "2)You can use your mouse to press the buttons, or use the "
                + "keyboard\n (f for fighter, w for wizard, etc.)\n"
                + "3)Your hero will only move according to the number pads (1-8)\n"
                + "4)To win, you must gain your hero's health to 100\n"
                + "5)Finally, have fun!");
        // Launch countdown form
        countdown = new Countdown();
        countdown.setVisible(true);
    }

    /**
     * Displays the text in an input message dialog box
     *
     * @param text the text displayed
     * @return the input of the user
     */
    public static String input(String text) {
        String out = JOptionPane.showInputDialog(null, text,
                title, JOptionPane.PLAIN_MESSAGE);
        return out;
    }
    
    /**
     * Displays the text in an input message dialog box with a drop down
     *
     * @param choices the text displayed in the drop down
     * @return the input of the user
     */
    public static String input(String[] choices) {
        String choice = JOptionPane.showInputDialog(null, "Select:", "",
                JOptionPane.PLAIN_MESSAGE, null, choices, 
                choices[0]).toString();
        return choice;
    }
    
    /**
     * Displays the text in a message dialog box 
     * 
     * @param text the text to display
     */
    public static void output(String text) {
        JOptionPane.showMessageDialog(null, text, 
                title, JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Sets a random color to be displayed in the background
     * 
     * @param frame the form to change the background color
     */
    public static void randomColor(JFrame frame) {
        Random random = new Random();
        int r = random.nextInt(0, 256);
        int g = random.nextInt(0, 256);
        int b = random.nextInt(0, 256);
        frame.setBackground(new Color(r, g, b));
        frame.getContentPane().setBackground(new Color(r, g, b));
    }
    
}