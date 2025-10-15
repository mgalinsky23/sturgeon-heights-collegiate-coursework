/** Required package class namespace */
package mccarthy91;

import javax.swing.JOptionPane;

/**
 * McCarthy91 - a program that calls the mcCarthy91() method and displays the
 * results for number sequence starting at a value like 0 and incrementing by a
 * value like 20 up to a number like 300.
 *
 * @author Michelle Galinsky
 * @since Mar 5, 2024
 */
public class McCarthy91 {

    static String title = "McCarthy91 Function";
    
    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        output("Welcome to the " + title);
        
        final int LOW = 0;
        final int HIGH = 300;
        
        String text = "";
        for (int i = LOW; i <= HIGH; i = i + 20) {
            int answer = mcCarthy91(i);
            text += "\nnumber = " + i
                    + "     McCarthy91 value = " + answer;
        }
        
        output("Here are the McCarthy numbers from 0 to 300\n" + text);
        output("Thanks for using the " + title);
    }
    
    /**
     * Outputs the text given in a JOptionPane dialog box
     * 
     * @param text the text given
     */
    private static void output(String text) {
        JOptionPane.showMessageDialog(null, text, title, 
            JOptionPane.PLAIN_MESSAGE);
    }
    
    /**
     * Determines the McCarthy of a number
     * 
     * @param n the number
     * @return the McCarthy of n
     */
    private static int mcCarthy91(int n) {

        if (n > 100) {
            return n - 10;
        } else {
            return mcCarthy91(mcCarthy91(n + 11));
        }

    }

    

}
