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
		Player targetPlayer = admin.choosePlayer();
	
		applyEffect(currentPlayer,targetPlayer);
	}
	
	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer){
	
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		admin.showPlayerCards(currentPlayer);
		admin.showPlayerCards(targetPlayer);
		
		if(currentPlayer.getCards().get(0).getLevel() > targetPlayer.getCards().get(0).getLevel())
			admin.disablePlayerFromRound(targetPlayer);
		else
			admin.disablePlayerFromRound(currentPlayer);
		
	}

	@Override
	public String getCardImageName() {
		return "/images/Baron.png";
	}
}
