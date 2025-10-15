
/** Required package class namespace */
package testing;

 
/**
 * Tester.java - tests the concepts learned in all the units.
 *
 * @author Michelle Galinsky
 * @since March 4, 2021
 */
public class Tester 
{

    /**
     * Default constructor, sets class properties
     */
    public Tester() {
        System.out.println("\nTesting begins...\n");
        
        RecursionTest unit1 = new RecursionTest();
        // Later we will add code here for unit 2 and 3...
        
        //Class name        object      constructor method
        AdvancedClassesTest unit2 = new AdvancedClassesTest();
        
        System.out.println("\nTesting complete!\n");
    }
        
}
