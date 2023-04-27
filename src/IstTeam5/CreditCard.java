package IstTeam5;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreditCard extends Payment {

    private String cardName;
    private String cardNumber;
    private String cvv;
    private Date expiryDate;
    /**

     Constructs a CreditCard object with the specified card name, card number, cvv, and expiry date.
     The payment charge for credit card payments is 0.0%.
     @param cardName The name on the credit card.
     @param cardNumber The credit card number.
     @param cvv The security code on the credit card.
     @param expiryDate The expiration date of the credit card.
     */

    public CreditCard(String cardName, String cardNumber, String cvv, Date expiryDate) {
        super(0.0);
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    /**

     Overrides the handlePayment method to return 0, as the payment is handled in the processPayment method.
     @param pay The payment amount.
     @return Returns 0.
     */

    @Override
    public double handlePayment(double pay) {
        return 0;
    }

    /**
     Processes the payment by checking if the credit card is valid and has sufficient balance, and charging
     the payment to the credit card.
     @param amount The payment amount.
     @return Returns true if the payment was successful, false otherwise.
     */
    public boolean processPayment(double amount) {
        // Check if the card is valid and has sufficient balance
        if (isValid() && hasSufficientBalance(amount) && isLuhnValid(cardNumber)) {
            // Charge the payment to the credit card
            // ...
            return true; // Payment successful
        } else {
            return false; // Payment failed
        }
    }

    /**
     Checks if the credit card is valid by comparing the expiry date to the current date.
     @return Returns true if the credit card is valid, false otherwise.
     */
    private boolean isValid() {
        // Check if the credit card is not expired
        return expiryDate.after(new Date());
    }

    /**
     Checks if the credit card has sufficient balance to make the payment.
     @param amount The payment amount.
     @return Returns true if the credit card has sufficient balance, false otherwise.
     */
    private boolean hasSufficientBalance(double amount) {
        // Check if the credit card has sufficient balance to make the payment
        // ...
        return true; // Assume the card has sufficient balance for the demo
    }

    // Getters and setters for the credit card properties
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Luhn check implementation
    static boolean isLuhnValid(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
