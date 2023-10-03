import java.util.ArrayList;
import java.util.List;
public class ShoppingCartSingleton {
    private static ShoppingCartSingleton instance;
    private List<Item> items;

    private ShoppingCartSingleton() {
        items = new ArrayList<>();
    }

    public static ShoppingCartSingleton getInstance() {
        if (instance == null) {
            instance = new ShoppingCartSingleton();
        }
        return instance;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalAmount = calculateTotalAmount();
        paymentStrategy.pay(totalAmount);
        items.clear();
    }

    private double calculateTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void displayItems() {
        System.out.println("Products in the shopping cart:");
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
    }
}
