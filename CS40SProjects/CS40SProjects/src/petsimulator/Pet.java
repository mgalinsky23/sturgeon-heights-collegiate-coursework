package petsimulator;

/**
 * Pet.java - parent class of dog and poodle
 *
 * @author m.galinsky
 * @since May 2, 2024
 */
public interface Pet {

    /**
     * Implemented in it's subclass to change/mutate the property name
     *
     * @param name the property to be set
     */
    void setName(String name);

    /**
     * Implemented in it's subclass to get/access and return the name property
     *
     * @return the name
     */
    String getName();

    /**
     * Implemented in it's sub class to output the orderNumber, name and price
     *
     * @return the orderNumber, name and price
     */
    String sold();
}
