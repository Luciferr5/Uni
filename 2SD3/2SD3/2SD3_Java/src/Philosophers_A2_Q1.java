import java.util.Scanner;
public class Philosophers_A2_Q1 {

	static Scanner scan = new Scanner(System.in);
	static int cookies = 0;
	static int colas = 0;
	static int maxCookies = 0;
	static int maxColas = 0;
	static int phils = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println("Input the number for the philosophers.");
			phils = scan.nextInt();
			if(phils > 0) 
				break;
		}

		while(true) {
			System.out.println("Input the capacity for the cookie dispenser.");
			maxCookies = scan.nextInt();
			if(maxCookies > 0) 
				break;
		}
		
		while(true) {
			System.out.println("Input the capacity for the cola dispenser.");
			maxColas = scan.nextInt();
			if(maxColas > 0) 
				break;
		}
		
		while(true) {
			System.out.println("Input the philosopher that will perform an action(Number of Philosophers = " + phils + ").\n");
			int phil = scan.nextInt();
			
			if(phil > 0 && phil<=phils) 
				action(phil);
			else 
				System.out.println("Invalid Input\n");
		}
	}
	
	
	public static void action(int phil) {
		while(true) {
			System.out.println("Philosopher " + phil + " is being used.\n\nSelect 1 to think, 2 to get and eat cookie, or 3 to get and drink cola.\n");
			int act = scan.nextInt();
			if(act == 1) {
				System.out.println("Philosopher " + phil + " thinks.\n");
				break;
			}
			else if(act == 2) {
				System.out.println("Philosopher " + phil + " gets and eats a cookie.\n");
				cookies++;
				if(cookies==maxCookies) {
					System.out.println("The servant refills the cookie dispenser with " + maxCookies + " cookie(s).\n");
				}
				break;

			}
			else if(act == 3){
				System.out.println("Philosopher " + phil + " gets and drinks a cola.\n");
				colas++;
				if(colas==maxColas) {
					System.out.println("The servant refills the cola dispenser with " + maxColas + " cola(s).\n");
				}
				break;		
			}
			
			else {
				System.out.println("Invalid Input");
			}
		}
		
	}

}
