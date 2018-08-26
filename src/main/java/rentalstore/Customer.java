package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public Enumeration getRentals() {
        return rentals.elements();
    }

    public String statement(){
        return new TextStatement().value(this);
    }
    public String htmlStatement(){
        return new HtmlStatement().value(this);
    }
    double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRentalPoints();
        }
        return result;

    }
}
