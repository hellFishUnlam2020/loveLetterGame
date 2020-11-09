package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

public class Priest extends Card {
	@Override
	public String getName() {
		return "Sacerdote";
	}

	@Override
	public CardType getType() {
		return CardType.priest;
	}

	@Override
	public int getLevel() {
		return 2;
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
	public String getCardImageName() {
		return "/images/Espia.png";
	}

	@Override
	public void play(Player currentPlayer) {
		
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		Player targetPlayer = admin.choosePlayer();
	
		applyEffect(currentPlayer,targetPlayer);
	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {
	
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		admin.showPlayerCards(targetPlayer);
		
	}
}
