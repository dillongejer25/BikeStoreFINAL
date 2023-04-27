package IstTeam5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShoppingCartGUI extends JFrame {
    private ShoppingCart cart;
    private JList<Product> productList;
    private DefaultListModel<Product> listModel;
    private JButton addButton;
    private JButton removeButton;
    private JButton checkoutButton;
    private JTextArea cartTextArea;


    public ShoppingCartGUI(ShoppingCart cart) {
        super("Shopping Cart");
        this.cart = cart;


// get the products from the cart
        Product[] products = cart.getAllProducts();

// create a list model to hold the products
        listModel = new DefaultListModel<>();

// add each product to the list model
        for (Product product : products) {
            listModel.addElement(product);
        }


// create a JList to display the products
        productList = new JList<>(listModel);
        productList.setFont(new Font("Arial", Font.PLAIN, 18));

// create buttons for adding products to cart and checking out
        addButton = new JButton("Add to Cart");
        checkoutButton = new JButton("Checkout");
        removeButton = new JButton("Remove from Cart");


// add action listeners to add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductToCart();
            }
        });


// add action listen to remove button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProductFromCart();
            }
        });


// add action listen to check out button
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkout();
            }
        });

// create a JTextArea to display the shopping cart
        cartTextArea = new JTextArea(8, 30);
        cartTextArea.setEditable(false);

// create a JPanel to hold the buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

//Add Button Settings
        buttonPanel.add(addButton);
        addButton.setPreferredSize(new Dimension(250, 50));
        addButton.setFont(new Font("Didot", Font.PLAIN, 20));

        buttonPanel.add(removeButton);
        removeButton.setFont(new Font("Didot", Font.PLAIN, 20));

        buttonPanel.add(checkoutButton);
        checkoutButton.setFont(new Font("Didot", Font.PLAIN, 20));

// create a JPanel to hold the cart text area
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(new JScrollPane(cartTextArea), BorderLayout.CENTER);

// set the layout of the frame
        setLayout(new BorderLayout());

// add the list to the center of the frame
        add(new JScrollPane(productList), BorderLayout.CENTER);

// add the button panel to the south of the frame
        add(buttonPanel, BorderLayout.SOUTH);

// add the cart panel to the east of the frame
        add(cartPanel, BorderLayout.EAST);

// set the size and location of the frame
        setSize(1200, 700);
        setLocationRelativeTo(null);

// set the frame to be visible
        setVisible(true);
    }

    // method to add a product to the cart
// method to add a product to the cart
    private void addProductToCart() {
// get the selected product from the list
        Product selectedProduct = productList.getSelectedValue();

        if (selectedProduct != null) {
// add the selected product to the cart
            cart.addProduct(selectedProduct);

// update the cart text area
            cartTextArea.append(selectedProduct.toString() + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
        }
    }

    private void removeProductFromCart() {
        // get the selected product from the cart
        Product selectedProduct = productList.getSelectedValue();
        System.out.println("Selected Product: " + selectedProduct); // print the selected product

        if (selectedProduct != null) {
            // remove the selected product from the cart
            cart.removeProduct(selectedProduct);
            System.out.println("Product removed from cart: " + selectedProduct); // print the removed product

            // update the cart text area
            cartTextArea.setText(""); // clear the cart text area
            Product[] products = cart.getAllProducts();
            for (Product product : products) {
                // only append products that are not the selected product
                if (!product.equals(selectedProduct)) {
                    cartTextArea.append(product.toString() + "\n");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to remove from the cart.");
        }
    }

    // method to perform the checkout process
    private void checkout() {
        // display a confirmation dialog
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to checkout?");

        // if the user confirms, prompt for payment method
        if (result == JOptionPane.YES_OPTION) {
            // create a payment dialog
            String[] paymentOptions = {"Credit Card", "Cash"};
            String paymentChoice = (String) JOptionPane.showInputDialog(this, "Choose a payment method:",
                    "Payment Method", JOptionPane.QUESTION_MESSAGE, null, paymentOptions, paymentOptions[0]);

            if (paymentChoice != null) {
                Payment payment;
                if (paymentChoice.equals("Credit Card")) {
                    // prompt for credit card information
                    String cardName = JOptionPane.showInputDialog(this, "Enter card name:");
                    String cardNumber = JOptionPane.showInputDialog(this, "Enter credit card number:");
                    String cvv = JOptionPane.showInputDialog(this, "Enter CVV:");
                    String expiryDateString = JOptionPane.showInputDialog(this, "Enter expiry date (MM/YY):");
                    Date expiryDate = null;
                    try {
                        expiryDate = new SimpleDateFormat("MM/yy").parse(expiryDateString);
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(this, "Invalid expiry date. Please enter date in the format MM/YY.");
                        return;
                    }

                    // Check if the card number is valid according to the Luhn algorithm
                    if (!CreditCard.isLuhnValid(cardNumber)) {
                        JOptionPane.showMessageDialog(this, "Invalid credit card number. Please enter a valid credit card number.");
                        return;
                    }

                    // create a credit card payment object
                    payment = new CreditCard(cardName, cardNumber, cvv, expiryDate);
                } else {
                    // prompt for cash tendered
                    double cashTendered = 0;
                    boolean validInput = false;
                    do {
                        String cashTenderedString = JOptionPane.showInputDialog(this, "Enter cash tendered:");
                        try {
                            cashTendered = Double.parseDouble(cashTenderedString);
                            validInput = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                        }
                    } while (!validInput);
                    payment = new Cash(cashTendered);
                }

                // attempt to process the payment
                boolean paymentSuccess = cart.checkout(payment);

                // display appropriate message depending on payment success
                if (paymentSuccess) {
                    JOptionPane.showMessageDialog(this, "Thank you for your purchase!");
                    cartTextArea.setText(cart.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Payment failed. Please try again or choose a different payment method.");
                }
            }
        }
    }
}