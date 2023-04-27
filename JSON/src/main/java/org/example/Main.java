package org.example;
import com.google.gson.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try
        {
            Customer custs [] = {new Customer(1, "Jim", "jone", "jj@idk.com", "111-456-3333"),
                    new Customer(2, "joe", "patel","j.pat@idk.com","111-789-3333"),
                    new Customer(3,"been","patel","bpatel@idk.com","111-282-3333")};

            try (FileWriter writer = new FileWriter("Customer.json")){
                writer.write(new Gson().toJson(custs));
            }

            Customer[] cust2 = new Gson().fromJson(new FileReader("Customer.json"), Customer[].class);
            for (Customer cust : cust2){
                System.out.println(cust.getID() +"," + " " + "Name: " + cust.getFirst_name() + " " + cust.getLast_name());
                System.out.println("Email : " + cust.getEmail());
                System.out.println("Phone : " + cust.getPhone());
            }
        }catch(Exception e){ }
    }
}