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
public class GetDirectionsAction extends AbstractAction {
    private Restaurant restaurant;

    public GetDirectionsAction(Restaurant restaurant) {
        super("Get directions");
        this.restaurant = restaurant;
    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Getting directions to " + restaurant.getAddress());
    }

}
