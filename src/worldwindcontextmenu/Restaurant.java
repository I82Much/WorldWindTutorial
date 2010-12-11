/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package worldwindcontextmenu;

import java.awt.Image;

/**
 *
 * @author ndunn
 */
public class Restaurant {
    private String name;
    private String address;
    private String phoneNumber;
    private Image logo;

    public Restaurant(String name, String address, String phoneNumber, Image logo) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
}
