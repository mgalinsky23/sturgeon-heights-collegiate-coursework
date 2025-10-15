/** Required package class namespace */
package petsimulator;

/**
 * Sale.java - the subclass of order.
 *
 * @author Michelle Galinsky
 * @param <T> Sale objects
 * @since May 2, 2024, 9:28:07 a.m.
 */
public class Sale<T> extends Order {

    private T saleItem;

    private double price;

    /**
     * Passes the orderNumber to the superclass
     *
     * @param saleItem the item being sold
     * @param orderNumber the number being passed to the super class
     */
    public Sale(T saleItem, int orderNumber) {
        super.orderNumber = orderNumber;
        this.saleItem = saleItem;
    }

    /**
     * Mutates the price
     *
     * @param price the new price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Accesses and returns the price
     *
     * @return the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Accesses the orderNumber and return it
     *
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }
}
