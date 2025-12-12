package Grouping;

import org.testng.annotations.Test;

public class PaymentTests 
{
	
	 @Test(priority = 1,groups= {"sanity","regression","functional"})
	    void paymentInRupees() {
	        System.out.println("Payment in rupees...");
	    }

	    @Test(priority = 2,groups= {"sanity","regression","functional"})
	    void paymentInDollar() {
	        System.out.println("Payment in dollars...");
	    }
}
