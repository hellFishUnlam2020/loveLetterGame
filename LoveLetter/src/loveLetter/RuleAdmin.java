package loveLetter;

import cards.Card;
import cards.CardType;
import cards.Guard;

public class RuleAdmin {

	public static final RuleAdmin ruleAdmin = new RuleAdmin();
	private RoundGame round;
	private Board board;

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

	// Methods ejecutables desde las cartas

	public Player choosePlayer() {
		// Interfaz visual que nos devuelva lo que el user elije
		return new Player("fake");
	}

	public Card chooseCard(Player player) {

		Card card = player.getCards().get(0); // cartas a mostrar por UI y que se elija una
		return card;
	}

	public String chooseCardName(Player currentPlayer) {

		/*
		 * String cardName = getCardsNamesWithoutGuard(); -> mostrarle a currentPlayer y
		 * que seleccione. Se podrian mostrar los type de cartas tambien, enves de
		 * strings. los nombres de cartas en la UI y que seleccione uno
		 * 
		 * return cardName;
		 */

		return "Rey";
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
		player.setStatus(Status.PROTECTED);
	}

	public void showPlayerCards(Player player) {

		player.getCards(); // mostrar las cartas por UI

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

			if( card.getType().equals(CardType.countess))
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

}
