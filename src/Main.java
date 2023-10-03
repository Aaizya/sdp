public class Main {
    public static void main(String[] args) {
        // Create a Singleton Shopping Cart
        ShoppingCartSingleton shoppingCart = ShoppingCartSingleton.getInstance();

        // Add items to the cart
        shoppingCart.addItem(new Item("TV", 25.0));
        shoppingCart.addItem(new Item("laptop", 15.0));
        shoppingCart.addItem(new Item("washing machine", 10.0));

        // Display items in the cart
        shoppingCart.displayItems();

        // Set the payment strategy (Choose one)
         // PaymentStrategy paymentStrategy = new CreditCardPayment();
         PaymentStrategy paymentStrategy = new PayPalPayment();
        // PaymentStrategy paymentStrategy = new BitcoinPayment();

        // Checkout and process payment
        shoppingCart.checkout(paymentStrategy);
    }
}