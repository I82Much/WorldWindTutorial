/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package worldwindcontextmenu;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author ndunn
 */
public class CallRestaurantAction extends AbstractAction {

    private Restaurant restaurant;
    public CallRestaurantAction(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Dialing " + restaurant.getPhoneNumber());
    }
}
