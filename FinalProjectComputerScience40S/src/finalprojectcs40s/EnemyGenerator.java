
/** Required package class namespace */
package finalprojectcs40s;

/** Required API imports */
import collections.LinkedList;
import gametools.Directions;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import tools.Numbers;

 
/**
 * EnemyGenerator.java - class to generate enemies on the user interface at
 * random times and in random locations
 *
 * @author Michelle Galinsky
 * @since May 16, 2024
 */
public class EnemyGenerator 
{           
    
    public static JPanel panel;                 // Associations with UI elements
    public static JLabel statusLabel;    
    public static Hero   hero;                  // Associations with Hero
    public static int    screenCount;           // Count of enemies on screen
    
    private static LinkedList<Enemy> enemies;   // List of all enemies
    private static Timer             timer;     // Timer to spawn enemies
    
    private final static int MIN_DELAY = 100;   // Constants for timer
    private final static int MAX_DELAY = 1000;    
    public static final int SIZE      = 10;    // Constant for enemy size
    
    private static int trackCount = 0;          // For enemy tracking number
    
    
    /**
     * Starts up the enemy generator
     */
    public static void start() {
        enemies = new LinkedList<>();                       // Instantiate list
        timer = new Timer(MAX_DELAY, new ActionListener() { // Build Timer
            public void actionPerformed(ActionEvent e) {
                spawnEnemy();
            }
        });
        timer.start();                                      // Start timer
    }
    
    /**
     * Generates and spawns an enemy on screen
     */
    private static void spawnEnemy() {
        JLabel label = new JLabel();                // Instantiate Label object
        int x = Numbers.random(1, panel.getWidth()  - SIZE - 1);    // Random x
        int y = Numbers.random(1, panel.getHeight() - SIZE - 1);    // and y
        int red   = Numbers.random(0, 255);             // Random color values
        int green = Numbers.random(0, 255);
        int blue  = Numbers.random(0, 255);
        Color color = new Color(red, green, blue);      // Assign color
        panel.add(label);                               // Add to panel
        label.setBounds(x, y, SIZE, SIZE);              // Position and size
        label.setOpaque(true);                          // Allow for backcolors
        label.setBackground(color);                     // Set color
        int direction = Directions.STOP;                // Initial direction
        Enemy enemy = new Enemy(label, direction, panel, hero);  // Create enemy
        trackCount++;                                   // Increase tracking
        enemy.trackingNumber = trackCount;              // number for this enemy
        enemies.add(enemy);                             // Add enemy to list
        screenCount++;                                  // Add enemies on screen
        statusLabel.setText("Status: Enemies on screen = " + screenCount 
                + "\n Health of Hero = " + Hero.health); 
        int delay = Numbers.random(MIN_DELAY, MAX_DELAY);   // New random delay
        timer.setDelay(delay);                          // Assign to timer
    }

    /**
     * Removes an enemy from the user interface and removes it from the list
     * 
     * @param enemy the enemy to remove
     */
    public static void remove(Enemy enemy) {
        panel.remove(enemy.image);                  // Remove label from UI 
        enemies.remove(enemy);                      // Remove from linked list
        enemy.image.setVisible(false);              // Hide label
        enemy.despawn();                            // Destroy enemy 
        enemy.finalize();
        screenCount--;                              // Decrease count
        statusLabel.setText("Status: Enemies on screen = " + screenCount 
                + "\n Health of Hero = " + Hero.health);         
    }
     
}
