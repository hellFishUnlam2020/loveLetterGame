package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

public class King extends Card {
	@Override
	public String getName() {
		return "Rey";
	}

	@Override
	public CardType getType() {
		return CardType.king;
	}

	@Override
	public int getLevel() {
		return 6;
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
	public void play(Player currentPlayer) {
		
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		Player targetPlayer = admin.choosePlayer(); //seleccionamos el targetPlayer mediante la UI
		
		applyEffect(currentPlayer, targetPlayer);
		
	}
	
	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {
		
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		admin.swapCardsBetweenPlayers(currentPlayer,targetPlayer);
	}
	
	
	@Override
	public String getCardImageName() {
		return "/images/Rey.png";
	}
}
