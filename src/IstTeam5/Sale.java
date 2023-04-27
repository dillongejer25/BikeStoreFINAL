package IstTeam5;
/** Sale Class consist of total Sale, Discount, and Tax in different State
 * @author DIllon Gejer
 * NOT WORKING - at this time
 */

public class Sale {
    public static double getPATax(double saleTotal){
        return .06121 * saleTotal;
    }
    public static double getNJTax(double saleTotal){
        return .06625 * saleTotal;
    }

    public static double getDiscount(double saleTotal){
        return saleTotal *= .03;
    }
    public static double getTax(double saleTotal, StateCode state){
        double total = 0.0;
        if (state == StateCode.PA)
            total = saleTotal * .06121;
        if (state == StateCode.DE)
            total = saleTotal * 0.0;
        else if (state == StateCode.NJ)
            total = saleTotal * .06625;
        else if (state == StateCode.NY)
            total = saleTotal * .0535;
        else if (state == StateCode.NC)
            total = saleTotal * .0745;
        return total;
    }
}
