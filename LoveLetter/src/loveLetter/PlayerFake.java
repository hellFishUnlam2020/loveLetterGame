package loveLetter;

import cards.Card;

public class PlayerFake extends Player {

	public PlayerFake(String name) {
		super(name);
	}

	@Override
	public void addCard(Card card) {
		this.getCards().add(card);
	}
	
	
}
