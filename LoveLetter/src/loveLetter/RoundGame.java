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
			player.setCantRoundPlayedCards(0);
		}
	}

	public Player getRoundWinner() {

		Player winnerPlayer = null;

		for (int i = 0; i < players.size(); i++) {
			if(players.get(i).getStatus().equals(Status.AVAILABLE)) {
				for (int j = 0; j < players.size(); j++) {
					if(i!=j && players.get(j).getStatus().equals(Status.AVAILABLE)) {
						winnerPlayer = players.get(i).compareTo(players.get(j)) == 1 ? players.get(i) : players.get(j);
					}
				}
			}
				
		}

		return winnerPlayer;
	}
}
