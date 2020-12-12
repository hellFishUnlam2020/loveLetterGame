package loveLetter;

import javax.swing.JFrame;

import cards.Card;
import cards.CardType;
import jpanels.CardPickerPanel;
import view.MatchFrame;
import viewCommunication.CardElegible;
import viewCommunication.PlayerElegible;

public class RuleAdmin implements PlayerElegible, CardElegible{

	public static final RuleAdmin ruleAdmin = new RuleAdmin();
	private RoundGame round;
	private Board board;
	private Player playerElected;
	private Card cardEleceted;
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public RoundGame getRound() {
		return round;
	}

	public void setRound(RoundGame round) {
		this.round = round;
	}

	public static RuleAdmin getRuleadmin() {
		return ruleAdmin;
	}
	
	public void resetElected() {
		playerElected = null;
	}
	
	public void resetCardElected() {
		cardEleceted = null;
	}

	// Methods ejecutables desde las cartas

	public Player choosePlayer(Player player, boolean val) {
		
		((MatchFrame)player.getLabel().getTopLevelAncestor()).setPickPlayer(true);
		for(Player playerRound : player.getMatch().getPlayers()) {
			if(player!=playerRound) {
				playerRound.getLabel().setMouseListener();
				playerRound.getLabel().setPlayerElegible(this);
			}
		}
		
		while(playerElected == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		((MatchFrame)player.getLabel().getTopLevelAncestor()).setPickPlayer(false);
		return playerElected;
	}

	public Card chooseCard(Player player) {

		Card card = player.getCards().get(0); // cartas a mostrar por UI y que se elija una
		return card;
	}

	public Card chooseCardName(Player currentPlayer) {

		/*
		 * String cardName = getCardsNamesWithoutGuard(); -> mostrarle a currentPlayer y
		 * que seleccione. Se podrian mostrar los type de cartas tambien, enves de
		 * strings. los nombres de cartas en la UI y que seleccione uno
		 * 
		 * return cardName;
		 */

		JFrame frame = (JFrame) currentPlayer.getLabel().getTopLevelAncestor();
		CardPickerPanel cfp = new CardPickerPanel();
		cfp.setCardElegible(this);
		
		frame.getContentPane().add(cfp);
		frame.getContentPane().setComponentZOrder(cfp, 0);
		frame.getContentPane().repaint();
		
		while(cardEleceted == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		frame.getContentPane().remove(cfp);
		frame.repaint();
		return cardEleceted;
	}

	public void swapCardsBetweenPlayers(Player currentPlayer, Player targetPlayer) {

		Card cardCurrentPlayer = currentPlayer.getCards().get(0);
		Card cardTargetPlayer = targetPlayer.getCards().get(0);

		currentPlayer.getCards().remove(0);
		targetPlayer.getCards().remove(0);

		currentPlayer.addCard(cardTargetPlayer);
		targetPlayer.addCard(cardCurrentPlayer);
	}

	public String[] getCardsNamesWithoutGuard() {

		String[] cardsNames = { "Baron", "Countess", "King", "Maid", "Priest", "Prince", "Princess" };

		return cardsNames;
	}

	public void applySafeBlock(Player player) {
		player.setProteced(true);
	}

	public void showPlayerCards(Player player) {

		player.setCardsVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		player.setCardsVisible(false);

	}

	public void eliminatePlayerForCard(Player player, Card card) {

	}

	public void discardCardsFromPlayer(Player player) {

		for (Card card : player.getCards()) {
			player.discardCard(card);
		}
	}

	public void disablePlayerFromRound(Player player) {
		// se deshabilita el player de la ronda actual
		player.setStatus(Status.DISABLE);
	}

	public void dealCardForPlayer(Player player) {
		// el jugador toma una carta del mazo
		Card card = player.getMatch().getDeck().popCard();
		player.takeCard(card);

	}

	public boolean playerHasCountessCard(Player player) {

		boolean result = false;

		for (Card card : player.getCards()) {

			if( card.getType().equals(CardType.countless))
				result = true;
		}

		return result;
	}

	public boolean playerHasToPlayCountessCard(Player player) {
		// cuando se tiene condesa+rey o condesa+principe se debe jugar la condesa obligatoriamente

		boolean result = false;

		for (Card card : player.getCards()) {

			if( card.getType().equals(CardType.prince) || card.getType().equals(CardType.king))
				result = true;
		}

		return result;
	}

	@Override
	public void playerElected(Player player) {
		this.playerElected = player;
	}

	@Override
	public void cardElected(Card card) {
		this.cardEleceted = card;
	}
}
