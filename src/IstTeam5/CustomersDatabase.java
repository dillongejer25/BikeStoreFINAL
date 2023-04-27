package IstTeam5;

import java.sql.*;
import java.util.*;

public class CustomersDatabase {

    public static void main(String[] args) {


        readAllSQL();
        readByIdSQL(1);
        Customer cust = new Customer("Dillon", "Gejer", "dillongej2340@gmail.com", "444-324-2344");
        createSQL(6, cust);
        updateSQL(6, cust);
        deleteSQL(6);
        readAllSQL();
    }





    private static void readAllSQL() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            // Here, "BikeStore" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                Customer cust = new Customer(rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"));
                customers.add(cust);
            }
            for (Customer cust : customers) {
                System.out.println( cust.getFirst_name() + ", " + cust.getLast_name() + ", " +
                        cust.getEmail() + ", " + cust.getPhone());
            }
        } catch (Exception e) {

        }
    }

    private static void readByIdSQL(int id) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Customer cust = null;
            while (rs.next()) {
                cust = new Customer( rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone"));

            }
            System.out.println( cust.getFirst_name() + ", " + cust.getLast_name() + ", " +
                    cust.getEmail() + ", " + cust.getPhone());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void createSQL(int id, Customer cust) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            PreparedStatement ps = con.prepareStatement("INSERT INTO customers (id, first_name, last_name, email, phone) " +
                    "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, cust.getFirst_name());
            ps.setString(2, cust.getLast_name());
            ps.setString(3, cust.getEmail());
            ps.setString(4, cust.getPhone());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void updateSQL(int id, Customer cust) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            PreparedStatement ps = con.prepareStatement("UPDATE customers SET first_name = ?, last_name = ?, email = ?, " +
                    "phone = ? WHERE id = ?");
            ps.setString(1, cust.getFirst_name());
            ps.setString(2, cust.getLast_name());
            ps.setString(3, cust.getEmail());
            ps.setString(4, cust.getPhone());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static boolean saveCustomer(Customer customer) {
        try {
            // Here, "BikeStore" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            PreparedStatement ps = con.prepareStatement("INSERT INTO customers (first_name, last_name, email, phone) " +
                    "VALUES ( ?, ?, ?, ?)");
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhone());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }



    private static void deleteSQL(int id) {
        try {
            // Here, "Bike Store" is the database name, "root" is the username and "password" is the password
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BkStores4", "root", "Classic23$");
            PreparedStatement ps = con.prepareStatement("DELETE FROM customers WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}