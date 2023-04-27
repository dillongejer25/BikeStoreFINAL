package IstTeam5;

/**Class Cash inherits from Payment class
 * @author Parth Patel
 */
public class Cash extends Payment {

    /**
     * Constructor Method
     * @param payCharge
     */
    public Cash(double payCharge) {
        super(payCharge); // payment charge for cash payments is 0%
    }

    /**Method signature was defined in the Payment class
     * @param pay
     * @return
     */
    public double handlePayment(double pay){
        return pay * super.getPaymentCharge();
    }
}