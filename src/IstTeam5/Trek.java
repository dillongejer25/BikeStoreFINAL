package IstTeam5;
/**Class Trek inherits from Product class
 * @author Dillon Gejer
 */
public class Trek extends Product{
    private String name;
    private String desc;
    /**Calls the Super Class
     * @param name
     * @param desc
     */
    public Trek(String name, String desc){
        super(2,"Fuel Ex 5","Trek","Dirt Bike With Broken Headlight",2000,"Used",2021);
    }
    // Below Str Method representation returns of String value
    public String str() {
        return "name = " + getName() + "\n" + "Brand = " + getBrand() + "\n" + "Desc = " + getDescription() + "\n" + "Price = " + getPrice() + "\n" +
                "Condition = " + getCondition() + "\n" + "Year = " + getYear()+ "\n";
    }
}
