package IstTeam5;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    static String BikeStore;

    public static void main(String[] args) {

        Store store = new Store("Bike Store");
        System.out.println(store.Str());

        CustomersDatabase cuDatabase = new CustomersDatabase();
        ArrayList<Customer> customers = new ArrayList<>();

        ShoppingCart catalog = new ShoppingCart();

        // create a new instance of the CustomerForm
        CustomerForm customerForm = new CustomerForm();

        // add an action listener to the "Create" button
        customerForm.getsubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide the customer form
                customerForm.setVisible(false);

                // create a new instance of the ShoppingCartGUI
                ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI(catalog);

                // display the shopping cart GUI
                shoppingCartGUI.setVisible(true);
            }
        });

        // display the customer form
        customerForm.setVisible(true);

        // print the details of all Bike in the catalog
        for (Product product : catalog.getAllProducts()) {
            System.out.println("ID = " + product.getId() + ", " + "Name = " + product.getName()  + "\n======\n" + "Brand =" + product.getBrand() + ", " + "Description = " +
                    product.getDescription() +  " Price = " + product.getPrice() + ", " + " Condition = " +
                    product.getCondition() + "\n");
        }
    }
}
