package cards;

import loveLetter.Player;

public class Countless extends Card {

	@Override
	public String getName() {
		return "Condesa";
	}

	@Override
	public CardType getType() {
		return CardType.countless;
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

		//habria que controlar que cada carta que se levanta
		
	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {
		
	}
}
