import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TouchTester {
	TouchRegisterer touches;
	
	@Before
	public void init() {
		touches = new TouchRegisterer();
	}
	
	@Test
	public void someTouch() {
		String touch = "1100000";
		boolean[] wires = new boolean[] {true,true,false,false,false,false,false};
		
		ArrayList<Lights> light = touches.interperate(wires, WeaponBeingUsed.epee);
		assertEquals(light, new ArrayList<Lights>(Arrays.asList(Lights.leftTouch)));
	}
}
