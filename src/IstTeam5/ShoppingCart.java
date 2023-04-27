package IstTeam5;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
        addProduct(new Product(1, "YZF-R1", "Yamaha", "SportBike More Horse Power", 4000, "New", 2022));
        addProduct(new Product(2, "Fuel Ex 5", "Trek", "Dirt Bike With Broken Headlight", 2000, "Used", 2021));
        addProduct(new Product(3, "ZX-10R", "Kawasaki Ninja", "Racing Bike", 6000, "New", 2023));
        addProduct(new Product(4, "Permio E8", "Pegasus", "SportBike", 2000, "Used", 2018));
        addProduct(new Product(5, "Hightower", "Santa cruz", "Dirt Bike", 4700, "Used", 2022));
    }

    public void addProduct(Product product) {
        if (items.containsKey(product)) {
            int quantity = items.get(product);
            items.put(product, quantity + 1);
        } else {
            items.put(product, 1);
        }
    }

    public void removeProduct(Product product) {
        if (items.containsKey(product)) {
            int quantity = items.get(product);
            if (quantity == 1) {
                items.remove(product);
            } else {
                items.put(product, quantity - 1);
            }
        }
    }

    public void clear() {
        items.clear();
    }

    public int getItemCount() {
        int count = 0;
        for (int quantity : items.values()) {
            count += quantity;
        }
        return count;
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }

    public Product[] getAllProducts() {
        return items.keySet().toArray(new Product[0]);
    }

    public boolean containsProduct(Product selectedProduct) {
        return items.containsKey(selectedProduct);
    }

    public int getQuantity(Product product) {
        return items.getOrDefault(product, 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping Cart:\n");

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice() * quantity;
            sb.append(product.getName() + " (x" + quantity + ") - $" + price + "\n");
        }

        sb.append("Total: $" + getTotalPrice());

        return sb.toString();
    }

    public void addProduct(Product selectedProduct, int quantity) {
        if (selectedProduct != null) {
            if (containsProduct(selectedProduct)) {
                int currentQuantity = getQuantity(selectedProduct);
                items.put(selectedProduct, currentQuantity + quantity);
            } else {
                items.put(selectedProduct, quantity);
            }
        }
    }

    public boolean checkout(Payment payment) {
        // get the total price of the cart
        double totalPrice = getTotalPrice();

        // process the payment
        boolean paymentSuccess = payment.processPayment(totalPrice);

        // if the payment is successful, clear the cart
        if (paymentSuccess) {
            clear();
            System.out.println("Payment successful. Your order has been placed.");
        }
        return paymentSuccess;
    }
        }
