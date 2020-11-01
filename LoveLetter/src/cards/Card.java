package cards;

import loveLetter.Player;

public abstract class Card {
		
	public abstract String getName();
	
	public abstract CardType getType();
	
	public abstract int getLevel();

	public abstract boolean shouldSelectAPlayer();
	
	public abstract boolean isPlayable();
	
	public abstract void play(Player player, Card card);
}
