
/** Required package class namespace */
package finalprojectcs40s;

/** Required API imports */
import gametools.Directions;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Hero.java - class represents the hero moving on the user interface, the 
 * users will choose the hero type they want from these descriptions
 *
 * @author Michelle Galinsky
 * @since May 16, 2024
 */
public class Hero extends Character implements HeroType 
{
    
    public static int health;
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param image the label associated with the image for the game character
     * @param boundry 
     */
    public Hero(JLabel image, JPanel boundry) {
        super(image, Directions.STOP, boundry);     // Construct parent class
        final int MOVE_AMOUNT = 5;                  // Move amount
        coordinates.amount = MOVE_AMOUNT;           // set to character
    }
    
    public int fight;
    public int magic;
    public int stealth;
    public int speed;

    /**
     * Sets the fighter properties
     *
     * @return the string version of the properties
     */
    @Override
    public String fighter() {
        //fight enemy with weapons?
        fight = 15;
        magic = 0;
        speed = 10;
        stealth = 5;
        return toString(fight, speed, magic, stealth);
    }

    /**
     * Sets the wizard properties
     *
     * @return the string version of the properties
     */
    @Override
    public String wizard() {
        //kill enemy with bomb where they stand and disappear from where they 
        //were to end up somewhere else on the screen
        fight = 5;
        magic = 15;
        speed = 5;
        stealth = 0;
        return toString(fight, speed, magic, stealth);
    }

    /**
     * Sets the superhero properties
     *
     * @return the string version of the properties
     */
    @Override
    public String superhero() {
        //fly over enemy, enemy will slowly die off by trying to get the hero
        fight = 15;
        magic = 10;
        speed = 5;
        stealth = 10;
        return toString(fight, speed, magic, stealth);
    }

    /**
     * Creates a String version of the hero types
     *
     * @param fight the fight property
     * @param speed the speed property
     * @param magic the magic property
     * @param stealth the stealth property
     * @return
     */
    public String toString(int fight, int speed, int magic, int stealth) {
        String title = Controller.title;
        String output = "Fight = " + fight;
        output += "     Speed = " + speed;
        output += "     Magic = " + magic;
        output += "     Stealth = " + stealth;
        return output;
    }
 
}
