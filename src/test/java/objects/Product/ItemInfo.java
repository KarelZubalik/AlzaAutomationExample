package objects.Product;

public class ItemInfo {
    public ItemInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String name;
    int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
