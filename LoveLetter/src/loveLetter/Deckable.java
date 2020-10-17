package loveLetter;

public interface Deckable {
	public Card popCard();
	public int getRemainingCards();
	public void mixCards();
	public void createCards();
	public void discardRandomCard();
}
