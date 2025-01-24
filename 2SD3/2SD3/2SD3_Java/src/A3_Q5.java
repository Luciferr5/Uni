
public class A3_Q5 {

	static class Ticket {
		final int MAX = 100;
		private int next = 0;
		
		public synchronized int ticket() {
			next = next % MAX + 1;
			return next;
		}
	}
	
	static class Counter {
		final int MAX = 100;
		private int serve = 1;
		
		public synchronized void getcheese(int ticket) throws InterruptedException {
			while(ticket != serve)
				wait();
			serve = serve % MAX + 1;
			notifyAll();
			
		}
	}
	
	 public static class Customer extends Thread {
	        private final int id;
	        private final Ticket ticket;
	        private final Counter counter;

	        public Customer(int id, Ticket t, Counter c) {
	            this.id = id;
	            this.ticket = t;
	            this.counter = c;
	        }

	        @Override
	        public void run() {
	            try {
	                int curr_ticket = ticket.ticket();
	                System.out.println("Ticket " + curr_ticket + " will now be served.");
	                System.out.println("Customer " + id + " has ticket #" + curr_ticket + ".");
	                counter.getcheese(curr_ticket);
	                System.out.println("Customer " + id + " is being served.");
	                Thread.sleep(1000);
	            } catch (InterruptedException ignored) {
	            }
	        }
	    }
	 
	 public static void main(String []args) {
		Ticket t = new Ticket();
		Counter c = new Counter();
		Customer c1 = new Customer(1, t, c);
		Customer c2 = new Customer(5, t, c);
		Customer c3 = new Customer(10, t, c);

		c1.start();
		c2.start();
		c3.start();
		
	 }
	
}
