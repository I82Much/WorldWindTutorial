/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package worldwindcontextmenu;

import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.IconLayer;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author ndunn
 */
public class RestaurantWorldWindExample extends JFrame
{
    private WorldWindowGLCanvas wwd;
    private IconLayer restaurantLayer;

    private static final String MCDONALDS_ICON_PATH = "resources/zzmicheytds.jpg";
    private static final String CHIPOTLE_ICON_PATH = "resources/chipotle_logo.png";

    private static final int ICON_WIDTH = 32;
    private static final int ICON_HEIGHT = 32;

    private static final BufferedImage MCDONALDS_ICON = createIcon(MCDONALDS_ICON_PATH, ICON_WIDTH, ICON_HEIGHT);
    private static final BufferedImage CHIPOTLE_ICON = createIcon(CHIPOTLE_ICON_PATH, ICON_WIDTH, ICON_HEIGHT);

    public RestaurantWorldWindExample()
    {
        wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
        wwd.setModel(new BasicModel());

        restaurantLayer = new IconLayer();
        // Create some restaurants,
        for (Restaurant r : createDefaultRestaurants()) {
            RestaurantIcon icon = new RestaurantIcon(r.getLogo(), Position.ZERO, r);
            restaurantLayer.addIcon(icon);
        }

        wwd.getModel().getLayers().add(restaurantLayer);
    }

    private static List<Restaurant> createDefaultRestaurants() {
        Restaurant chipotle = new Restaurant("Chipotle", "213 Maple Ave. E, Vienna, VA 22180", "703.255.1100", CHIPOTLE_ICON);
        Restaurant mcdonalds = new Restaurant("McDonald's", "2912 CHAINBRIDGE RD, OAKTON, VA 22124", "(703)319-0617", MCDONALDS_ICON);
        return Arrays.asList(chipotle, mcdonalds);
    }

    private static BufferedImage createIcon(String path, int width, int height) {
        try {
            BufferedImage buff = ImageIO.read(new File(path));
            BufferedImage scaled = new BufferedImage(width, height, buff.getType());
            Graphics2D scaledGraphics = scaled.createGraphics();
            // Copy the icon, but scale it to the desired dimensions
            scaledGraphics.drawImage(buff, 0, 0, width, height, null);
            return scaled;
        } catch (IOException ex) {
            Logger.getLogger(RestaurantWorldWindExample.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new RestaurantWorldWindExample();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
