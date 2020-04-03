import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ClockTester {
	Clock clock;
	
	@Before
	public void clockSetUp() {
		this.clock = new Clock();
	}
	
	@Test
	public void clockTest() {
		this.clock.runClock();
		long timeBeforeTest = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
			long timeAfter = System.currentTimeMillis();
			long timeLeft = this.clock.stopClock();
			long timeAfterA = System.currentTimeMillis();
			long timePassed = 180000 - timeLeft;
			long timeBuffer = timeAfterA - timeAfter;
			long timeBetween = timeAfter - timeBeforeTest;
			
			assertTrue((timePassed >= timeBetween && timePassed <= (timeBetween + timeBuffer)));
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
