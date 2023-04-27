package IstTeam5;

/** Class to be used to create Product object for the BikeStore
 * @author parth
 */

/**Class Product Properties
 */public class Product {
    public int id;
    private String name;
    private String brand;
    private String description;
    private double price;
    private String condition;
    private int year;

    public Product(int id, String name, String brand, String description, double price, String condition, int year) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.condition = condition;
        this.year = year;
    }
    public static void add(Product pro) {
    }


    /** Getter Method for Name
     * @return name
     */
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     * Setter Method for Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**  Getter Method for Description
     * @return Desc
     */

    public String getDescription() {
        return description;
    }

    /** Getter Method for Brand
     * @return brand
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Setter Method for Brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /** Getter Method for Price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter Method for Price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**  Getter Method for Condition
     * @return condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Setter Method for Condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }


    /**  Getter Method for Year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter Method for Year
     */
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Brand: " + brand +
                ", Description: " + description +
                ", Price: $" + price +
                ", Condition: " + condition +
                ", Year: " + year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    // Below Str Method representation returns of String value
    public String str() {
        return "ID = " + getId() + "name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }

}


