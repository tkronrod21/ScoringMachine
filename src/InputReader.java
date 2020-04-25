import com.fazecast.jSerialComm.*;

public class InputReader{
	
	/**
	 * Returns all available active serial ports
	 * @return available serial ports
	 */
	public static SerialPort[] availableSerPorts() {
		
		 SerialPort[] thePorts = SerialPort.getCommPorts();
		 
		 return thePorts;
	}
	
}
