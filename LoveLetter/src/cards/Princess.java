package cards;

import loveLetter.Player;

public class Princess extends Card {

	@Override
	public String getName() {
		return "Princesa";
	}

	@Override
	public CardType getType() {
		return CardType.princess;
	}

	@Override
	public int getLevel() {
		return 8;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return false;
	}

	@Override
	public boolean isPlayable() {
		return false;
	}

	@Override
	public void play(Player player, Card card) {
		//It's not playable, otherwise the player lose
	}
}
