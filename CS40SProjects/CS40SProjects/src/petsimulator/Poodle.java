/** Required package class namespace */
package petsimulator;

import javax.swing.JOptionPane;

/**
 * Poodle.java - the subclass of dog
 *
 * @author Michelle Galinsky
 * @since May 3, 2024, 8:14:09 a.m.
 */
public class Poodle extends Dog {

    public final double price = 99.99;

    private static int poodlesSold;

    /**
     * Increases the number of poodles sold, calls the super class, mutates the
     * name and calls the method sold()
     *
     * @param name the new name
     * @param orderNumber the orderNumber passed to the super class
     */
    public Poodle(String name, int orderNumber) {
        poodlesSold++;
        super.sell(price, orderNumber);
        super.setName(name);
        sold();
    }

    /**
     * Calls the super class and outputs the number of poodles sold
     */
    @Override
    public String sold() {
        String text = super.sold();
        text += " and we have sold " + poodlesSold + " poodles\n";
        JOptionPane.showMessageDialog(null, text, PetSimulator.title,
                JOptionPane.PLAIN_MESSAGE, PetSimulator.icon);
        return null;
    }
}
