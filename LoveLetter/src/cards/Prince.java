package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

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
		// TODO check for a Countless
		// Its not playable when the player has a Countless
		return true;
	}

	@Override
	public String getCardImageName() {
		return "/images/card5Principe.png";
	}

	@Override
	public void play(Player currentPlayer) {
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		Player targetPlayer = admin.choosePlayer(currentPlayer, true);

		admin.resetElected();

		applyEffect(currentPlayer, targetPlayer);

	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {

		RuleAdmin admin = RuleAdmin.getRuleadmin();
		
		if (!targetPlayer.isProtected()) {
			admin.discardCardsFromPlayer(targetPlayer);
			admin.dealCardForPlayer(targetPlayer);
		}
	}
}
