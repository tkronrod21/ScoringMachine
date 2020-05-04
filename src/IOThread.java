import java.util.LinkedList;
import java.util.List;

import com.fazecast.jSerialComm.SerialPort;

public class IOThread extends Thread {
	
	List list; //Queue list of tasks to be displayed
	
	public IOThread(List list) {
		this.list = list;
	}
	
	@Override
	public void run() {
		SerialPort comPort;
		while (true) { // wait for a serial port to be plugged in before running the rest of the thread
			try {
				comPort = SerialPort.getCommPorts()[0];
				break;
			}
			catch(ArrayIndexOutOfBoundsException e) {
				try {
					System.out.println("No serial port found");
					this.sleep(1000); 
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		comPort.setBaudRate(57600);
		comPort.openPort();
		try {
		   while (true) {
		      while (comPort.bytesAvailable() <= 0)
		         Thread.sleep(20);

		      byte[] readBuffer = new byte[comPort.bytesAvailable()];
		      int numRead = comPort.readBytes(readBuffer, readBuffer.length);
		      
		      //System.out.println(new String(readBuffer)); //Prints out info from serial port
		      
		      this.list.add(new String(readBuffer));
		   }
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
		comPort.closePort();
	}
}
