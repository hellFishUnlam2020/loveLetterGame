package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

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
	public void play(Player currentPlayer) {
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		Player targetPlayer = admin.choosePlayer(currentPlayer, false);

		admin.resetElected();

		applyEffect(currentPlayer, targetPlayer);
	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {

		RuleAdmin admin = RuleAdmin.getRuleadmin();

		if (!targetPlayer.isProtected()) {
			admin.showPlayerCards(targetPlayer);

			int n = currentPlayer.getLabel().getNCardSelected();
			
			if(n==1)
				n = 0;
			else
				n = 1;
			
			if (currentPlayer.getCards().get(n).getLevel() > targetPlayer.getCards().get(n).getLevel())
				admin.disablePlayerFromRound(targetPlayer);
			else
				admin.disablePlayerFromRound(currentPlayer);
		}

	}

	@Override
	public String getCardImageName() {
		return "/images/card3Baron.png";
	}
}
