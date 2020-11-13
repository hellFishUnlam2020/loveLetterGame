package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

public class Maid extends Card {
	@Override
	public String getName() {
		return "Sirvienta";
	}

	@Override
	public CardType getType() {
		return CardType.maid;
	}

	@Override
	public int getLevel() {
		return 4;
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
	public void play(Player currentPlayer) {

		applyEffect(currentPlayer, null);

	}

	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {

		RuleAdmin admin = RuleAdmin.getRuleadmin();
		admin.applySafeBlock(currentPlayer);

	}

	@Override
	public String getCardImageName() {
		return "/images/card4Sirvienta.png";
	}
}
