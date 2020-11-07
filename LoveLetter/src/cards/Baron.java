package cards;

import loveLetter.Player;

public class Baron extends Card {
	@Override
	public String getName() {
		return "Baron";
	}

	@Override
	public CardType getType() {
		return CardType.baron;
	}

	@Override
	public int getLevel() {
		return 3;
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
		return "/images/Baron.png";
	}
}
