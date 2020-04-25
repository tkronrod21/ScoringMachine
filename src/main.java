import java.io.IOException;
import java.io.InputStream;

import com.fazecast.jSerialComm.SerialPort;

public class main {
	
	public static void main(String[] args) {
		for(SerialPort s : InputReader.availableSerPorts()) {
			s.openPort();
			InputStream stream = s.getInputStream();
			try {
				System.out.println(Byte.toString((byte) stream.read()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
