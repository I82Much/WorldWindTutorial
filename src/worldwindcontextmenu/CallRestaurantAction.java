package worldwindcontextmenu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * An action representing calling the restaurant.
 * @author ndunn
 */
public class CallRestaurantAction extends AbstractAction {

    private Restaurant restaurant;
    public CallRestaurantAction(Restaurant restaurant) {
        super("Call " + restaurant.getName());
        this.restaurant = restaurant;
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Dialing " + restaurant.getPhoneNumber());
    }
}
