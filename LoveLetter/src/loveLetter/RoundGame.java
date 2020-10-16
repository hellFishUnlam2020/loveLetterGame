package loveLetter;

import java.util.List;

public class RoundGame {

	private List<Player> players;
	private Deck deck;

	public RoundGame(List<Player> players) {
		this.players = players;
		deck = new Deck();
	}

	public void startRound() {
		// Construimos maso de cartas
		deck.createCards();

		// Mezclamos el maso de cartas
		deck.mixCards();

		// Eliminamos una carta del maso al azar
		deck.discardRandomCard();

		// Repartimos una carta a cada uno de los jugadores
		for (Player player : players) {
			player.addCard(deck.popCard());
		}
	}

}
