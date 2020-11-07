package cards;

import loveLetter.Player;

public class Guard extends Card {
	@Override
	public String getName() {
		return "Guardia";
	}

	@Override
	public CardType getType() {
		return CardType.guard;
	}

	@Override
	public int getLevel() {
		return 1;
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
		return "/images/Guardia.png";
	}
}
