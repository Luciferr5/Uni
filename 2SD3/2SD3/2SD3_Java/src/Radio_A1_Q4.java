
import java.util.Scanner;

public class Radio_A1_Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int currentState = 1;
		//1:off, 2:top_freq, 3:scanning 4:middle_freq 5: bottom_freq 6:break
		
		while(true) {
			if(currentState==1) {
				System.out.println("CURRENT STATE: OFF");
				System.out.println("Type '2' to turn on, '6' to exit the program");
				currentState=scan.nextInt();
			}
			else if(currentState==2) {
				System.out.println("CURRENT STATE: TOP_FREQ");
				System.out.println("Type '1' to turn off, '2' to reset, '3' to scan");
				currentState=scan.nextInt();
			}
			else if(currentState==3) {
				System.out.println("CURRENT STATE: SCANNING");
				System.out.println("Type '1' to turn off, '2' to reset, '3' to scan,\n'4' to lock on to a middle frequency, '5' to go to the bottom frequency.");
				currentState=scan.nextInt();
			}
			
			else if(currentState==4) {
				System.out.println("CURRENT STATE: MIDDLE_FREQ");
				System.out.println("Type '1' to turn off, '2' to reset, '3' to scan");
				currentState=scan.nextInt();
			}
			
			else if(currentState==5) {
				System.out.println("CURRENT STATE: BOTTOM_FREQ");
				System.out.println("Type '1' to turn off, '2' to reset, '5' to scan");
				currentState=scan.nextInt();
			}
			
			else if(currentState==6) {
				break;
			}
			
			else {
				System.out.println("Invalid Entry");
			}
			
		}
		
		
	}

}
