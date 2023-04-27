package IstTeam5;
/**Class Pegasus inherits from Product class
 * @author Parth Patel
 */

public class Pegasus extends Product{
    private String name;
    private String desc;

    /**Calls the Super Class
     * @param name
     * @param desc
     */
    public Pegasus(String name, String desc){
        super(4,"Permio E8","Pegasus","SportBike",2000,"Used",2018);
    }
    // Below Str Method representation returns of String value
    public String str() {
        return "ID = " + getId() + "\n" +"name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }
}
