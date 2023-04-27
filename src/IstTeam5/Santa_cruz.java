package IstTeam5;
/**Class Santa_cruz inherits from Product class
 * @author Parth Patel
 */
public class Santa_cruz extends Product{
    private String name;
    private String desc;
    /**Calls the Super Class
     * @param name
     * @param desc
     */
    public Santa_cruz(String name, String desc){

        super(5,"Hightower","Santa cruz","Dirt Bike",4700,"Used",2022);
    }
    // Below Str Method representation returns of String value
    public String str() {
        return "ID = " + getId() + "\n" +"name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }
}
