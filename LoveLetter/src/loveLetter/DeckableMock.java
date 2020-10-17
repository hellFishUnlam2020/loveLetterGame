package loveLetter;

public class DeckableMock implements Deckable {
	
	public Card cardToReturn = null;
	public int remainingCardsToReturn = 0;
	
	public DeckableMock(Card cardToReturn, int remainingCardsToReturn) {
		this.cardToReturn = cardToReturn;
		this.remainingCardsToReturn = remainingCardsToReturn;
	}
	
	public Card popCard() {
		return cardToReturn;
	};
	
	public int getRemainingCards() {
		return remainingCardsToReturn;
	};
	
	public void mixCards() {};
	
	public void createCards() {};
	
	public void discardRandomCard() {};
}
