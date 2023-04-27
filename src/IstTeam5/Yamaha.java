package IstTeam5;
/**Class Yamaha inherits from Product class
 * @author Parth Patel
 */
public class Yamaha extends Product{
    private String name;
    private String desc;
    /**Calls the Super Class
     * @param name
     * @param desc
     */
    public Yamaha(String name, String desc){
        super(1,"YZF-R1","Yamaha","SportBike More Horse Power",4000,"New",2022);
    }
    // Below Str Method representation returns of String value
    public String str() {
        return "ID = " + getId() + "\n" +"name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }
}


