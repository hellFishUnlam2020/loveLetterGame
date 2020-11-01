package loveLetter;

import cards.Card;

public interface Deckable {
	public Card popCard();
	public int getRemainingCards();
	public void mixCards();
	public void createCards();
	public void discardRandomCard();
}
