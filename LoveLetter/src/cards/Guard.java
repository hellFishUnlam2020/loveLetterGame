package cards;

import loveLetter.Player;
import loveLetter.RuleAdmin;

public class Guard extends Card {
	@Override
	public String getName() {
		return "Guardia";
	}

	@Override
	public CardType getType() {
		return CardType.guard;
	}

	@Override
	public int getLevel() {
		return 1;
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
	public void applyEffect(Player currentPlayer, Player targetPlayer) {

		RuleAdmin admin = RuleAdmin.getRuleadmin();
		String cardName = admin.chooseCardName(currentPlayer);	//enves de elegir un nombre de carta, podria ser elegir un type de carta
		
		if( targetPlayer.getCards().get(0).getName().contentEquals(cardName)) //verificamos si adivino la carta 
			admin.disablePlayerFromRound(targetPlayer); //se deshabilita el player en la ronda

	}
	
	@Override
	public String getCardImageName() {
		return "/images/card1Guardia.png";
	}
}
