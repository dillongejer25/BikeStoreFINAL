package IstTeam5;
/**Class kawasaki_Ninja inherits from Product class
 * @author Parth Patel
 */

public class Kawasaki_Ninja extends Product{
    private String name;
    private String desc;

    /**Calls the Super Class
     * @param name
     * @param desc
     */

    public Kawasaki_Ninja(String name, String desc){
        super(3,"ZX-10R","Kawasaki Ninja","Racing Bike",6000,"New",2023);

    }
    // Below Str Method representation returns of String value
    public String str() {
        return "ID = " + getId() + "\n" +"name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }
}
