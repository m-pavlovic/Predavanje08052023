package vjezba5_zad3;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Package {

    private int id;
    private static int cntID = 100;
    private String webShop;
    private String destination;
    private Customer customer;
    private float packagePrice;
    private int totalItems; //totalKom
    private List<Item> items;
    private static final float MINF = 10;
    private static final float MAXF = 150;
    private static final int KOMS = 10;
    private String[] typeItems = {"T_Shirt", "Sneakers"};
    private Set<Payment> payments;
    private Scanner sc;



    public Package(String shop, String destination, Customer customer, Payment payment) {
        this.id = cntID++;
        this.items = new ArrayList<>();
        this.payments = new HashSet<>();
        this.webShop = shop;
        this.destination = destination;
        this.customer = customer;
        this.payments.add(payment);
    }

    public void setScanner(Scanner sc) {
        this.sc = sc;
    }

    public boolean checkPayment() {
        System.out.println("Enter payment type: ");
        boolean status = false;
        String payment = sc.nextLine();
        for (Payment p : payments) {
            if (p.getPayment().equals(payment)) {
                status = true;
                break;
            }
        }
        return status;
    }

    private float randItemPrice() {
        return ThreadLocalRandom.current().nextFloat(MINF, MAXF);
    }

    private int randNumItems() {
        return ThreadLocalRandom.current().nextInt(KOMS);
    }

    public void putContent() {
        int numItems = randNumItems();
        int[] indx = new int[numItems];
        for (int i = 0; i < numItems; i++) {
            indx[i] = ThreadLocalRandom.current().nextInt(typeItems.length);
        }
        for (int i = 0; i < numItems; i++) {
            if (indx[i] == 0) {
                T_Shirt t_shirt = new T_Shirt(randItemPrice(), randNumItems());
                items.add(t_shirt);
            } else {
                Sneakers sneakers = new Sneakers(randItemPrice(), randNumItems());
                items.add(sneakers);
            }
        }
        System.out.println("Content added to package.");
        calculateTotalPackagePrice();
        calculateTotalPackageItems();

    }

    public void calculateTotalPackagePrice() {
        for (Item item : items) {
            this.packagePrice += item.calculatePrice();
        }
        System.out.println("Price is calculated...");
    }

    public void calculateTotalPackageItems() {
        for (Item item : items) {
            this.totalItems += item.getNumItems();
        }
        System.out.println("Items are counted...");
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", webShop='" + webShop + '\'' +
                ", destination='" + destination + '\'' +
                ", customer=" + customer +
                ", packagePrice=" + packagePrice +
                ", totalItems=" + totalItems +
                ", items=" + items +
                '}';
    }

    public void packageInfo() {
        System.out.println(this);
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
