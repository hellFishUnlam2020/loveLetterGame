package cards;

import loveLetter.Player;

public class Countess extends Card {

	@Override
	public String getName() {
		return "Condesa";
	}

	@Override
	public CardType getType() {
		return CardType.countess;
	}

	@Override
	public int getLevel() {
		return 7;
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
	public String getCardImageName() {
		return "/images/card7Condesa.png";
	}
	
	@Override
	public void play(Player currentPlayer) {

		applyEffect(currentPlayer, null);
		
	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {
		
		
	}
}
