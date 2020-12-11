package loveLetter;

import java.util.List;

public class RoundGame {

	private List<Player> players;
	private Deckable deck;
	private int playersInRound;
	private int playerPlaying = 0;
	
	public RoundGame(List<Player> players, Deckable deck) {
		
		this.players = players;
		this.deck = deck;
		
	}

	public void startRound() {
		playersInRound = this.players.size();

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

		nextTurn();
	}

	public Player getRoundWinner() {

		Player winnerPlayer = null;

		if (playersInRound == 1)
			winnerPlayer = players.get(0);
		else {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getStatus().equals(Status.AVAILABLE)) {
					for (int j = 0; j < players.size(); j++) {
						if (i != j && players.get(j).getStatus().equals(Status.AVAILABLE)) {
							winnerPlayer = players.get(i).compareTo(players.get(j)) == 1 ? players.get(i)
									: players.get(j);
						}
					}
				}

			}
		}

		return winnerPlayer;
	}

	public List<Player> getPlayers(){
		return players;
	}
	
	private void nextTurn() {
		
		while (playersInRound > 1 && deck.getRemainingCards() > 0) {
			playTurn();
		}
		finishRound();
		
	}

	private void playTurn() {
		int index = peekAPlayer();
		
		players.get(index).setTurn(true);
		
		for(int i = 0; i < players.size(); i++) {
			if(i != index) {
				players.get(i).setTurn(false);
			}
		}
		
		// TODO: El jugador debe elegir la carta. Fake
		players.get(index).addCard(deck.popCard());
		players.get(index).playCard();

		for(int i = 0; i < players.size(); i++) {
			if(i != index) {
				players.get(i).setProteced(false);
			}
			if(players.get(i).getStatus() == Status.DISABLE) {
				eliminatePlayerFromRound(players.get(i));
			}
		}
		
		/*Por cada carta que se levanta del mazo deberia comprobarse si el jugador posee
		 * la Condesa+Principe o Condesa+Rey. De ser asi, se juega la Condesa obligatoriamente.
		 * 
		 * RuleAdmin admin = RuleAdmin.getRuleadmin();
		 * if( admin.playerHasCountessCard(turnPlayer) )
		 * 		if(admin.playerHasToPlayCountessCard(turnPlayer)){
		 * 						
		 * 				card.play();
		 * 			}	
		 * 		}
		 */

		//cardChoosed.play();
//		eliminatePlayerFromRound(turnPlayer); // Despues de jugar se elimina(Solo para Tests)
	}

	private void finishRound() {
		Player winner;
//		if (playersInRound == 1) {
//			winner = this.players.get(0);
//		} else {
//			winner = getRoundWinner();
//		}
		winner = getRoundWinner();
		// TODO: actualizarle los puntos.
		winner.increaseMatchPoint();
		winner.setAsWinner();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private int peekAPlayer() {
		playerPlaying++;
		if (playerPlaying >= this.players.size()) {
			playerPlaying = 0;
		}
		return playerPlaying;
	}

	public void eliminatePlayerFromRound(Player player) {
		 players.remove(player);
		playersInRound--;
	}

}
