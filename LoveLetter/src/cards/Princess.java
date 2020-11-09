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
		Player targetPlayer = admin.choosePlayer(); //en este caso se puede elegir el jugador a sí mismo
	
		applyEffect(currentPlayer,targetPlayer);
	}
	
	@Override
	public void applyEffect(Player currentPlayer, Player targetPlayer) {
		
		RuleAdmin admin = RuleAdmin.getRuleadmin();
		//mostrar mediante UI que se jugo la carta princesa y el jugador fue deshabilitado de la ronda
		admin.disablePlayerFromRound(currentPlayer);
		
	}
	
	@Override
	public String getCardImageName() {
		return "/images/Princesa.png";
	}


}
