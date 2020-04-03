
/**
 * A Clock object that keeps track of time remaining in the bout
 * 
 * @author Tal Kronrod
 * @version 1.0
 */
public class Clock {
	private long startTime;
	private long timeLeft;
	/**
	 * 3 min
	 */
	private long DEFAULT_TIME = 180000;
	private long stopTime;
	
	/**
	 * Creates a clock with 3 minutes left
	 */
	public Clock() {
		this.timeLeft = this.DEFAULT_TIME;
	}
	
	/**
	 * Creates a clock with a designated amount of time left,
	 * in milliseconds
	 * 
	 * @param timeLeftOnTimer The start value of the timer, in milliseconds
	 */
	public Clock(long timeLeftOnTimer) {
		this.timeLeft = timeLeftOnTimer;
	}
	
	/**
	 * Sets a start time for the timer
	 */
	public void runClock() {
		this.startTime = System.currentTimeMillis();
	}
	
	/**
	 * Sets a stop time for the timer
	 * 
	 * @return amount of time left on the timer
	 */
	public long stopClock() {
		this.stopTime = System.currentTimeMillis();
		this.timeLeft = this.timeLeft - (this.stopTime - this.startTime);
		
		return this.timeLeft;
	}
	
	/**
	 * Returns the amount of time left on the clock
	 * @return amount of time left on the clock
	 */
	public long getTimeLeft() {
		return this.timeLeft;
	}
}
