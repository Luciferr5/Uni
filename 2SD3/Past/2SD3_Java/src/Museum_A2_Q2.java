import java.util.Scanner;
public class Museum_A2_Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Director m = new Director();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter the capacity of the museum.");
			m.c.n = scan.nextInt();
			if(m.c.n>0)
				break;
		}
		
		while(true) {
			System.out.println("Presss 1 to open the museum or 2 to exit program");
			int check = scan.nextInt();
			if(check==1)
				manageMuseum(m);
			else if(check==2)
				break;
			else
				System.out.println("Invalid Input");
				
		}
	
	}
	
	public static void manageMuseum(Director m) {
		Scanner s = new Scanner(System.in);
		m.openMuseum();
		int x = 0;
		
		while(m.c.east.open || m.c.west.open) {
			System.out.println("Press 1 to have visitor enter, 2 to have visitor exit, 3 to start closing, 4 to fully close the museum.");
			x=s.nextInt();
			
			if(x==1)
				m.c.enter();
			else if(x==2)
				m.c.exit();
			else if(x==3)
				m.closing();
			else if(x==4)
				m.closeMuseum();
			else
				System.out.println("Invalid Input");
		}
	}

}

class Door {
	
	boolean open;
	
	public Door() {
		open = false;
	}
	
	public void closeDoor() {
		if(open==true)
			open = false;
	}
	
	public void openDoor() {
		if(open==false)
			open = true;
	}
	
}

class Control {
	int n;
	int curr;
	Door west;
	Door east;
	
	public Control() {
		n = 0;
		curr = 0;
		west = new Door();
		east = new Door();
		
	}
	
	public void enter() {
		
		if(!east.open && west.open) {
			System.out.println("Museum is Closing! No more entries");
			return;
		}
		
		else if(!east.open) {
			System.out.println("Museum is Closing!");
			return;
		}
		
		if(curr==n) {
			System.out.println("Museum is Full!");
			return;
		}
		
		curr++;
		System.out.println("Visitor has entered! Number of people in museum: " + curr);	
	}
	
	public void exit() {

		if(curr==0) {
			System.out.println("Museum is Empty");
			return;
		}
		
		curr--;
		System.out.println("Visitor has exited! Number of people in museum: " + curr);	
	}
}

class Director {
	Control c;
	
	public Director() {
		c = new Control();
	}
	
	public void openMuseum() {
		if(!c.west.open && !c.east.open) {
			System.out.println("Museum is now open!");
			c.east.open = true;
			c.west.open = true;
		}
	}
	
	public void closing() {
		if(c.west.open && c.east.open) {
			System.out.println("Museum is closing!");
			c.east.open = false;
		}
	}
	
	public void closeMuseum() {
		if (c.east.open)
			System.out.println("East door still open! Close it and empty museum to fully close!");
		if(c.west.open && !c.east.open) {
			System.out.println("Museum is now closed!");
			c.west.open = false;
		}
	}
}
