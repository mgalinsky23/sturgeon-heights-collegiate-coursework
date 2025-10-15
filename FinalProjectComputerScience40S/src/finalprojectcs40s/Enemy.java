
/** Required package class namespace */
package finalprojectcs40s;

/** Required API imports */
import javax.swing.JLabel;
import javax.swing.JPanel;

 
/**
 * Enemy.java - class represents the blocks of moving objects towards the hero
 *
 * @author Michelle Galinsky
 * @since May 16, 2024
 */
public class Enemy extends Character
{

    public  int    trackingNumber;              // Individual number for each
    public  JLabel image;                       // Associations with UI elements
    private Hero   hero;                        // Association with hero object
    private JPanel boundary;
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param image the label associated with the image for the game character
     * @param direction
     * @param boundary the panel acting as a boundary
     * @param hero 
     */
    public Enemy(JLabel image, int direction, JPanel boundary, Hero hero) {
        super(image, direction, boundary);
        this.hero    = hero;                // Connect (associate) parameters
        this.image   = image;               // with class properties
        this.boundary = boundary; 
    }
    
    /**
     * The action this character does in it's timer
     */
    @Override
    public void action() {
        trackHero();                    // Track location of hero and adjust
        if (this.detector.isOverLapping(hero)) {        // Collison with Hero
            if (MainUI.isFighterMode) {                
                hero.health += 3;
            }
            else if (MainUI.isSuperheroMode) {
                hero.health += 2;
            }
            else{
                hero.health -= 1;
            }
            boundary.remove(image);                     // Remove label from UI 
            EnemyGenerator.remove(this);
        }
        super.action();                 // Perform enemy movement
    }
        
    /**
     * Tracks the location of the hero and adjust movement towards hero
     */
    private void trackHero() {
        if (detector.isAbove(hero)) {
            if      (detector.isLeftOf(hero))  mover.moveSouthEast();
            else if (detector.isRightOf(hero)) mover.moveSouthWest();
            else                               mover.moveSouth();
        }
        else if (detector.isBelow(hero)) {
            if      (detector.isLeftOf(hero))  mover.moveNorthEast();
            else if (detector.isRightOf(hero)) mover.moveNorthWest();
            else                               mover.moveNorth();
        }
        else {
            if      (detector.isLeftOf(hero))  mover.moveEast();
            else if (detector.isRightOf(hero)) mover.moveWest();
        }
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        Enemy that = (Enemy)object;             // Cast into enemy
        int tract1 = this.trackingNumber;       // Get each tracking number
        int tract2 = that.trackingNumber;
        if (tract1 == tract2) return true;      // Compare numbers
        else                  return false;     // Tracking numbers different
    }

    /**
     * Destroy this object and free up memory resources
     */
    @Override
    public void finalize() {
        timer.stop();                   // Stop the movement fighterTimer
        image          = null;          // Nullify the objects
        boundary       = null;          
        hero           = null;
        trackingNumber = 0;
        super.finalize();               // Parent class wipes memory
        System.gc();                    // Call system garbage collector
    }
    
}
