package cards;

import loveLetter.Player;

public abstract class Card {
	
	public abstract String getCardImageName();
		
	public abstract String getName();
	
	public abstract CardType getType();
	
	public abstract int getLevel();

	public abstract boolean shouldSelectAPlayer();
	
	public abstract boolean isPlayable();
	
	public abstract void play(Player currentPlayer); //currentPlayer es quien jugo la carta

	public abstract void applyEffect(Player currentPlayer, Player targetPlayer);

}
