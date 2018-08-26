package rentalstore;
import java.util.Enumeration;
public class TextStatement {
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            //show figures for this rental
            result += eachRentalString(each);
        }
        //add footer lines
        result +=footerString(aCustomer);
        return result;
    }
    public String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }
    public String eachRentalString (Rental aRental) {
        return "\t"
                + aRental.getMovie().getTitle()
                + "\t"
                + String.valueOf(aRental.getCharge()) + "\n";
    }

    public String footerString (Customer aCustomer) {
        return "Amount owed is "
                + String.valueOf(aCustomer.getTotalCharge())
                + "\n"
                + "You earned "
                + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
                + " frequent renter points";
    }
}