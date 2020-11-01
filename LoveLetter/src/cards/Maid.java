package cards;

import loveLetter.Player;

public class Maid extends Card {
	@Override
	public String getName() {
		return "Mucama";
	}

	@Override
	public CardType getType() {
		return CardType.maid;
	}

	@Override
	public int getLevel() {
		return 4;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return false;
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
		return "images/mucama.jpg";
	}
}
