package vjezba5_zad3;

import java.util.ArrayList;
import java.util.List;

public class Package {

    private int id;
    private static int cntID = 100;
    private String webShop;
    private String destination;
    private Customer customer;
    private float packagePrice;
    private int totalItems; //totalKom
    private List<Item> items;


    public Package(String shop, String destination, Customer customer) {
        this.id = cntID++;
        this.items = new ArrayList<>();
        this.webShop = shop;
        this.destination = destination;
        this.customer = customer;
    }


    class T_Shirt extends Item {

        protected T_Shirt(float itemPrice, int numItems) {
            super(itemPrice, numItems);
        }

        @Override
        protected float calculatePrice() {

            return this.itemPrice * this.numItems;

        }
    }


    class Sneakers extends Item {

            protected Sneakers(float itemPrice, int numItems) {
                super(itemPrice, numItems);
            }

            @Override
            protected float calculatePrice() {

                return 0.9f*this.itemPrice * this.numItems;

            }
    }
}
