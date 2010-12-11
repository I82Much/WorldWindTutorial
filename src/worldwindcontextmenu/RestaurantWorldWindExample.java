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

    private static final BufferedImage MCDONALDS_ICON = createIcon(MCDONALDS_ICON_PATH, ICON_WIDTH, -1);
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
            RestaurantIcon icon = new RestaurantIcon(r.getLogo(), r.getPosition(), r);
            restaurantLayer.addIcon(icon);
        }

        wwd.getModel().getLayers().add(restaurantLayer);

        RestaurantSelectListener listener = new RestaurantSelectListener(wwd);
        wwd.addSelectListener(listener);
    }

    private static List<Restaurant> createDefaultRestaurants() {
        Restaurant chipotle = new Restaurant("Chipotle", "213 Maple Ave. E, Vienna, VA 22180", "703.255.1100", 
                Position.fromDegrees(38.9038999, -77.2622599), CHIPOTLE_ICON);
        Restaurant mcdonalds = new Restaurant("McDonald's", "2912 CHAINBRIDGE RD, OAKTON, VA 22124", "(703)319-0617",
                Position.fromDegrees(38.8827459,-77.2990347),
                MCDONALDS_ICON);
        return Arrays.asList(chipotle, mcdonalds);
    }

    /**
     * Given the path to an image file on disk, creates a BufferedImage out of
     * that object, scaling it to be size (width, height).
     *
     * If width or height is negative, then that dimension is calculated
     * automatically in order to maintain the aspect ratio.  In other words,
     * if the original image has an aspect ratio of 2:1 (twice as wide as tall),
     * and the width is given to be 40, and the height -1, the height will be
     * calculated as 20.
     * @param path
     * @param width
     * @param height
     * @return
     */
    private static BufferedImage createIcon(String path, int width, int height) {
        if (width < 0 && height < 0) {
            throw new IllegalArgumentException("At least one dimension must be non-negative");
        }

        try {
            BufferedImage buff = ImageIO.read(new File(path));
            double aspectRatio = (double) buff.getWidth() / (double) buff.getHeight();

            // calculate the width based on passed in height
            if (width < 0) {
                width = (int) (height * aspectRatio);
            }
            // Calculate the height based on the passed in width
            else if (height < 0) {
                height = (int) (width / aspectRatio);
            }


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
