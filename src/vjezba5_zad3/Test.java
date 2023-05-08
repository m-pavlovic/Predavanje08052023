package vjezba5_zad3;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer c1 = new Customer("John");
        Payment p1 = new Payment("PayPal");
        Package pack1 = new Package("Amazon", "Zagreb", c1, p1);
        System.out.println(c1);
        System.out.println(p1);
        pack1.packageInfo();
        //pack1.setScanner(sc);
        pack1.putContent();

    }
}
