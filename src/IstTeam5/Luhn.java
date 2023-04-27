package IstTeam5;

/** Check on the Credit Card number
 * @author Dillon Gejer
 */
public class Luhn {


    public static boolean Check(String ccnumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccnumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccnumber.substring(i, i + 1));
            if (alternate)
            {
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


