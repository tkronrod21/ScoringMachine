
public class Score {
	
	private int leftScore;
	private int rightScore;
	
	/**
	 * Default constructor, sets scores at 0 for both sides
	 */
	public Score() {
		this.leftScore = 0;
		this.rightScore = 0;
	}
	
	/**
	 * Constructor allowing to set score at start of bout
	 * @param left starting score for left side at start of the bout
	 * @param right starting score for right side at the start of the bout
	 */
	public Score(int left, int right) {
		this.leftScore = left;
		this.rightScore = right;
	}
	
	/**
	 * Returns the score on the right side
	 * @return score on the right side
	 */
	public int getRightScore() {
		return this.rightScore;
	}
	
	/**
	 * Returns the score on the left side
	 * @return score on the left side
	 */
	public int getLeftScore() {
		return this.leftScore;
	}
	
	/**
	 * Increments the score on the right
	 */
	public void incrementRight() {
		this.rightScore++;
	}
	
	/**
	 * Increments the score on the left
	 */
	public void incrementLeft() {
		this.leftScore++;
	}
	
	/**
	 * Sets the score of both sides to 0
	 */
	public void resetScore() {
		this.leftScore = 0;
		this.rightScore = 0;
	}
}
