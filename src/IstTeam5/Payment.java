package IstTeam5;

/** Payment Class defines Payment for all Products
 *  Every payment type will have a payment charge defined in the constructor
 *  The abstract method handlePayment is defined which will be implemented by all payment types.
 *  This method will return the amount to be charged to the customer
 *  The processPayment method is now defined in the Payment class, which accepts the amount to be paid and calls the handlePayment method
 */

public abstract class Payment {

    /**Property
     *
     */
    private double paymentCharge;

    /**Constructor Method
     *
     * @param payCharge
     */

    public Payment(double payCharge)
    {
        this.paymentCharge = payCharge;
    }

    /**Getter Method
     *
     * @return
     */
    public double getPaymentCharge() {
        return paymentCharge;
    }

    /**Method Signature
     *
     * @param pay
     * @return
     */
    public abstract double handlePayment(double pay);

    /**Method to process payment
     *
     * @param amount
     * @return
     */
    public boolean processPayment(double amount) {
        double paymentAmount = handlePayment(amount);
        // Code to process the payment goes here
        return true; // Payment successful for the purpose of the demo
    }
}
