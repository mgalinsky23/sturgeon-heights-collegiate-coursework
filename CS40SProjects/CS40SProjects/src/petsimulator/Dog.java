/** Required package class namespace */
package petsimulator;

/**
 * Dog.java - the super class of poodle and subclass of pet
 *
 * @author Michelle Galinsky
 * @since May 3, 2024, 8:05:42 a.m.
 */
public class Dog implements Pet {

    private String name;

    private Sale sale;

    /**
     * Mutates the name
     *
     * @param name the new name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accesses and returns the name
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Instantiates a sale object and sets the price
     *
     * @param price the new price
     * @param orderNumber the new order number
     */
    public void sell(double price, int orderNumber) {
        sale = new Sale(this, orderNumber);
        sale.setPrice(price);
    }

    /**
     * Outputs the orderNumber, name and price
     *
     * @return the orderNumber, name and price
     */
    public String sold() {
        String text = "Order " + sale.getOrderNumber() + " "
                + name + " is worth $" + sale.getPrice();
        return text;
    }

}
