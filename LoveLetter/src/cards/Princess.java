package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

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
	public void play(Player currentPlayer) {
		
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		admin.disablePlayerFromRound(currentPlayer);
	}
	
	@Override
	public void applyEffect(Player currentPlayer, Player targePlayer) {
		
	}
	
	@Override
	public String getCardImageName() {
		return "/images/card8Princesa.png";
	}


}
