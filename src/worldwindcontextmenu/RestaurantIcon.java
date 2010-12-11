/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package worldwindcontextmenu;

import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.render.UserFacingIcon;

/**
 *
 * @author ndunn
 */
public class RestaurantIcon extends UserFacingIcon {

    private Restaurant restaurant;

    public RestaurantIcon(Object image, Position pos, Restaurant restaurant) {
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
