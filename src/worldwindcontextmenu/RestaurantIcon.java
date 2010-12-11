package worldwindcontextmenu;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.render.UserFacingIcon;
import java.awt.Image;

/**
 * A graphical representation of the restaurant
 * @author ndunn
 */
public class RestaurantIcon extends UserFacingIcon {

    private Restaurant restaurant;

    public RestaurantIcon(Image image, Position pos, Restaurant restaurant) {
        super(image, pos);
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
