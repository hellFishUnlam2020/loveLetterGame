package cards;

import loveLetter.Player;

public class Prince extends Card {
	@Override
	public String getName() {
		return "Principe";
	}

	@Override
	public CardType getType() {
		return CardType.prince;
	}

	@Override
	public int getLevel() {
		return 5;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return true;
	}

	@Override
	public boolean isPlayable() {
		//TODO check for a Countless
		//Its not playable when the player has a Countless
		return true;
	}

	@Override
	public void play(Player player, Card card) {
		// TODO Add actions
		
	}

	@Override
	public String getCardImageName() {
		return "/images/Principe.png";
	}
}
