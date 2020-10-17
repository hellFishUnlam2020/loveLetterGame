package loveLetter;

public interface CardRemovable {
	public Card popCard();
	public int getRemainingCards();
	public void mixCards();
	public void createCards();
	public void discardRandomCard();
}
