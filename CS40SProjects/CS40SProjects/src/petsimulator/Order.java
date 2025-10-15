/** Required package class namespace */
package petsimulator;

/**
 * Order.java - An abstract class representing the concept of an order
 *
 * @author Michelle Galinsky
 * @since May 2, 2024, 9:24:48 a.m.
 */
public abstract class Order {

    protected int orderNumber;

    public abstract void setPrice(double price);

    public abstract double getPrice();

}
