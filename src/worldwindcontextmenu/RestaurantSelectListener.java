/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package worldwindcontextmenu;

import gov.nasa.worldwind.event.SelectEvent;
import gov.nasa.worldwind.event.SelectListener;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.Action;
import javax.swing.JPopupMenu;

/**
 * Handles popping up a context menu when a restaurant icon is right clicked
 * @author ndunn
 */
public class RestaurantSelectListener implements SelectListener {
    private Component wwdComponent;

    public RestaurantSelectListener(Component parentComponent) {
        wwdComponent = parentComponent;
    }

    public void selected(SelectEvent se) {
        if (se.getEventAction().equals(SelectEvent.RIGHT_CLICK)) {
            Object topObject = se.getTopObject();
            // They right clicked on one of the restaurant icons.
            if (topObject != null & topObject instanceof RestaurantIcon) {
                RestaurantIcon icon = (RestaurantIcon) topObject;
                Restaurant restaurant = icon.getRestaurant();

                Action callRestaurant = new CallRestaurantAction(restaurant);
                Action getDirectionsToRestaurant = new GetDirectionsAction(restaurant);
                JPopupMenu menu = createPopupMenu(Arrays.asList(callRestaurant, getDirectionsToRestaurant));
                menu.show(wwdComponent, se.getMouseEvent().getX(), se.getMouseEvent().getY());
            }
        }
    }

    private JPopupMenu createPopupMenu(List<? extends Action> actions) {
        JPopupMenu menu = new JPopupMenu();
        for (Action action : actions) {
            if (action == null) {
                menu.addSeparator();
            }
            else {
                menu.add(action);
            }
        }
        return menu;
    }
}
