package funcoes;

import java.net.InetAddress;
import java.util.GregorianCalendar;

public class Rtt implements Runnable{
	
	private String ipAddress;
	
	public Rtt(String ip){
		this.ipAddress = ip;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			
			InetAddress inet = InetAddress.getByName(this.ipAddress);

			//System.out.println("Sending Ping Request to " + this.ipAddress);

			long finish = 0;
			long start = new GregorianCalendar().getTimeInMillis();

			if (inet.isReachable(5000)){
				finish = new GregorianCalendar().getTimeInMillis();
				System.out.println("RTT: " + (finish - start + "ms"));
			} else {
				System.out.println(this.ipAddress + " NOT reachable.");
			}
		} catch ( Exception e ) {
			System.out.println("Exception:" + e.getMessage());
		}			
	}

}
