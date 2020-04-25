import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class WireReaderTester {
	TouchRegisterer toucher = new TouchRegisterer();

	/*
	@Test
	public void runEpee() {
		WireReader wireReaderEpee = new WireReader(toucher, WeaponBeingUsed.epee);
		
		long currentTime = System.currentTimeMillis();
		long[] wireTimes = new long[7];
		boolean[] expected = new boolean[7];
		int random = (int) (Math.random() * 7);
		boolean[] actual = new boolean[7];
		
		for(int i = 0; i < 7; i++) {
			if(i == random) {
				actual = wireReaderEpee.wireTripped(Wires.getWire(i), currentTime);
				expected[i] = true;
			}
			else {
				int randomTime = (int) (Math.random() * 100);
				actual = wireReaderEpee.wireTripped(Wires.getWire(i), currentTime - randomTime);
				if(randomTime <= 40)
					expected[i] = true;
				else
					expected[i] = false;
			}
		}
		
		assertArrayEquals(expected, actual);
	}
	*/
	WireReader wireReaderEpee;
	WireReader wireReaderFoil;
	WireReader wireReaderSabre;
	
	@Before
	public void setUp() {
		wireReaderEpee = new WireReader(toucher, WeaponBeingUsed.epee);
		wireReaderFoil = new WireReader(toucher, WeaponBeingUsed.foil);
		wireReaderSabre = new WireReader(toucher, WeaponBeingUsed.sabre);
	}
	
	
	@Test
	public void runEpeeLeftWin1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.LB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, false, false, false, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeRightWin1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.RA, currentTime);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, false, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeLeftFloor1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.G, currentTime + 3);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.LB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, true, false, false, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeLeftHitsBell1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.RC, currentTime + 3);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.LB, currentTime + 41);
		boolean[] expected = new boolean[] {false, true, false, false, false, false, true};
		
		assertArrayEquals(expected, actual);
	}

	@Test
	public void runEpeeRightFloor1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.G, currentTime);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 3);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, false, true, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeRightBell1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LC, currentTime);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 3);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, true, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeDouble1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.LB, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeLeftRightGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.LB, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.LC, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, true, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeRightLeftGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.LB, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RC, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, false, true, true, true};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runEpeeBothBell() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderEpee.wireTripped(Wires.LA, currentTime);
		wireReaderEpee.wireTripped(Wires.LB, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.LC, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RA, currentTime + 1);
		wireReaderEpee.wireTripped(Wires.RC, currentTime + 1);
		boolean[] actual = wireReaderEpee.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, true, false, true, true, true};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilLeftOffTarget1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LB, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RC, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, false, false, false, true};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilLeftGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LB, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.G, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, true, false, false, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilTouch1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LB, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RA, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, false, true, false, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilDouble1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LA, currentTime);
		wireReaderFoil.wireTripped(Wires.LB, currentTime + 1);
		wireReaderFoil.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilLeftTouchRightOff1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LC, currentTime);
		wireReaderFoil.wireTripped(Wires.LB, currentTime + 1);
		wireReaderFoil.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, true, false, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRightOff1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LC, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, true, false, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRight1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LA, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, false, false, false, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRightGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.G, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, false, true, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRightLeftOff1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LA, currentTime);
		wireReaderFoil.wireTripped(Wires.LB, currentTime + 1);
		wireReaderFoil.wireTripped(Wires.RC, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, false, false, true, true};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRightLeftGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LA, currentTime);
		wireReaderFoil.wireTripped(Wires.LB, currentTime + 1);
		wireReaderFoil.wireTripped(Wires.G, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {true, true, false, true, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilLeftRightGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.G, currentTime);
		wireReaderFoil.wireTripped(Wires.LB, currentTime + 1);
		wireReaderFoil.wireTripped(Wires.RA, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, true, true, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilBothOff1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LB, currentTime);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, false, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilLeftOff1() {
		
		long currentTime = System.currentTimeMillis();
		boolean[] actual = wireReaderFoil.wireTripped(Wires.LB, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, false, false, false, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilRightOff2() {
		
		long currentTime = System.currentTimeMillis();
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, false, false, false, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void runFoilBothGround1() {
		
		long currentTime = System.currentTimeMillis();
		wireReaderFoil.wireTripped(Wires.LB, currentTime);
		wireReaderFoil.wireTripped(Wires.G, currentTime + 1);
		boolean[] actual = wireReaderFoil.wireTripped(Wires.RB, currentTime + 21);
		boolean[] expected = new boolean[] {false, true, false, true, false, true, false};
		
		assertArrayEquals(expected, actual);
	}
}
