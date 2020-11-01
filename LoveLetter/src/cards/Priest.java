package cards;

import loveLetter.Player;

public class Priest extends Card {
	@Override
	public String getName() {
		return "Sacerdote";
	}

	@Override
	public CardType getType() {
		return CardType.priest;
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return true;
	}

	@Override
	public boolean isPlayable() {
		return true;
	}

	@Override
	public void play(Player player, Card card) {
		// TODO Add actions		
	}

	@Override
	public String getCardImageName() {
		return "images/sacerdote.jpg";
	}
}
