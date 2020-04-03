
public class Cards {
	private CardTypes leftCard;
	private CardTypes rightCard;
	
	/**
	 * Default constructor, sets both sides with no cards
	 */
	public Cards() {
		this.leftCard = CardTypes.none;
		this.rightCard = CardTypes.none;
	}
	
	/**
	 * Sets starting card values by given values at the start of the bout
	 * @param left card types that left side has
	 * @param right card types that right side has
	 */
	public Cards(CardTypes left, CardTypes right) {
		this.leftCard = left;
		this.rightCard = right;
	}
	
	/**
	 * Returns the card that the left side currently has
	 * @return the card types that the left side currently has
	 */
	public CardTypes getLeft() {
		return this.leftCard;
	}
	
	/**
	 * Returns the card that the right side currently has
	 * @return the card that the right side currently has
	 */
	public CardTypes getRight() {
		return this.rightCard;
	}
	
	/**
	 * Sets a new card value for the right side
	 * @param newCard the new card for the right side
	 */
	public void setRightCard(CardTypes newCard) {
		this.rightCard = newCard;
	}
	
	/**
	 * Sets a new card value for the left side
	 * @param newCard the new card value for the left side
	 */
	public void setLeftCard(CardTypes newCard) {
		this.leftCard = newCard;
	}
	
	/**
	 * Increments the card value of the left side
	 */
	public void incrementLeft() {
		if(this.leftCard == CardTypes.none)
			this.leftCard = CardTypes.yellow;
		else if(this.leftCard == CardTypes.yellow) 
			this.leftCard = CardTypes.red;
		else if(this.leftCard == CardTypes.red)
			this.leftCard = CardTypes.black;
	}
	
	/**
	 * Increments the card value of the right side
	 */
	public void incrementRight() {
		if(this.rightCard == CardTypes.none)
			this.rightCard = CardTypes.yellow;
		else if(this.rightCard == CardTypes.yellow)
			this.rightCard = CardTypes.red;
		else if(this.rightCard == CardTypes.red)
			this.rightCard = CardTypes.black;
	}
}
