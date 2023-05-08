package vjezba5_zad3;

public abstract class Item {

    protected float itemPrice;
    protected int numItems;

    protected Item(float itemPrice, int numItems) {
        this.itemPrice = itemPrice;
        this.numItems = numItems;
    }

    protected float getItemPrice() {
        return itemPrice;
    }

    protected int getNumItems() {
        return numItems;
    }

    protected abstract float calculatePrice();

    protected void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }
}
