package worldwindcontextmenu;

import gov.nasa.worldwind.geom.Position;
import java.awt.Image;

/**
 * Represents a restaurant.
 * @author ndunn
 */
public class Restaurant {
    private String name;
    private String address;
    private String phoneNumber;
    private Position position;
    private Image logo;

    public Restaurant(String name, String address, String phoneNumber, Position position, Image logo) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.logo = logo;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    
}
