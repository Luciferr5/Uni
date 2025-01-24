import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Gas_Station_A3_Q2 {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Integer> taken = new ArrayList<Integer>();
	static ArrayList<Integer> prepaid = new ArrayList<Integer>();
	static ArrayList<Integer> notpaid = new ArrayList<Integer>();
	static ArrayList<Integer> available = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2 customers, 3 pumps
		int temp;
		for(int i=1; i<4; i++)
			available.add(i);

		for(int i=1; i<3; i++)
			notpaid.add(i);		
		
		while(true) {
			System.out.println("Press 1 to prepay for gas, 2 to pump gas, 3 to exit program");
			temp = scan.nextInt();
			
			if(temp == 1)
				if (notpaid.isEmpty())
					System.out.println("All customers have prepaid. Customers need to pump gas.");
				else
					pumpPrepay();
			
			else if(temp == 2)
				if (available.isEmpty())
					System.out.println("All pumps are taken. Customers need to pump gas.");
				else if(prepaid.isEmpty())
					System.out.println("No customers have prepaid yet.");
				else
					pumpGas();
			else if(temp == 3)
				break;
			else
				System.out.println("Invalid Input");
			}
			
	}
	
	public static void pumpPrepay() {
		int curr_customer, pump;
		double prepay;
		while(true) {
			System.out.println("Which customer is prepaying: 1 or 2");
			curr_customer = scan.nextInt();
			if(curr_customer>0 && curr_customer<3 && notpaid.contains(curr_customer))
				break;
			else
				System.out.println("Invalid Input/Customer already paid");
		}
		
		notpaid.remove(Integer.valueOf(curr_customer));
		prepaid.add(curr_customer);
		
		while(true) {
			System.out.println("How much is customer " + curr_customer + " prepaying?");
			prepay = scan.nextDouble();
			if(prepay<=0)
				System.out.println("Invalid Input");
			else
				break;
		}
		
		while(true) {
			System.out.println("Which pump is the customer using: 1, 2 or 3");
			pump = scan.nextInt();
			if(pump>0 && pump<4 && available.contains(pump))
				break;
			else
				System.out.println("Invalid Input/Pump is taken");
		}
		
		available.remove(Integer.valueOf(pump));
		taken.add(pump);
		
		System.out.println("Customer " + curr_customer + " has prepaid at pump " + pump + " for $"  + prepay + "." );
		
	}
	
	public static void pumpGas() {
		int curr_customer, pumpNumber;
		while(true) {
			System.out.println("Which customer is pumping gas: 1 or 2");
			curr_customer = scan.nextInt();
			if(curr_customer>0 && curr_customer<3 && prepaid.contains(curr_customer))
				break;
			else
				System.out.println("Invalid Input/Customer has not paid");
		}
		
		pumpNumber = prepaid.indexOf(curr_customer);
		prepaid.remove(Integer.valueOf(curr_customer));
		notpaid.add(curr_customer);
		pumpNumber = taken.get(pumpNumber);
		taken.remove(Integer.valueOf(pumpNumber));
		available.add(pumpNumber);
		
		
		System.out.println("Customer " + curr_customer + " has finished pumping at pump " + pumpNumber);
	}

}




