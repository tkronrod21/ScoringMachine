import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputReader implements KeyListener{

	private char LA, LB, LC, G, RA, RB, RC; //represent char place holders for actual wire inputs. 
	/**
	 * An array of the time the last received input from each wire occured
	 */
	private long[] lastRecievedSignal;
	
	/**
	 * Constructor that reads wires as inputs from a keyboard
	 * @param wireCodes charachters that represent each wire. MUST be entered in order: LA, LB, LC, G, RA, RB, RC
	 */
	public InputReader(char[] wireCodes) {
		this.LA = wireCodes[0];
		this.LB = wireCodes[1];
		this.LC = wireCodes[2];
		this.G = wireCodes[3];
		this.RA = wireCodes[4];
		this.RB = wireCodes[5];
		this.RC = wireCodes[6];
		this.lastRecievedSignal = new long[7];
		for(int i = 0; i < 7; i++)
			this.lastRecievedSignal[i] = (Long) null;	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
