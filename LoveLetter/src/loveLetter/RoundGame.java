package loveLetter;

import java.util.List;

public class RoundGame {

	private List<Player> players;
	private CardRemovable deck;
	private int playersInRound;
	private int playerPlaying = 0;

	public RoundGame(List<Player> players, CardRemovable deck) {
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

	public void nextTurn() {
		while( playersInRound > 1 && deck.getRemainingCards() > 0) {
			playTurn();
		}
		finishRound();
	}

	private void playTurn() {
		Player turnPlayer = peekAPlayer();
		
		turnPlayer.addCard(deck.popCard());
		
		//askToPeekCard
		//Play  it
	} 
	
	private void finishRound() {
		//check that  is the only player
		
		//otherwise getRoundWinner
	} 
	
	
	private Player peekAPlayer() {
		playerPlaying++;
		if( playerPlaying >= this.players.size() ) {
			playerPlaying = 0;
		}
		return this.players.get(playerPlaying);	
	}
	
	public void eliminatePlayerFromRound(Player player) {
		//update player
		playersInRound--;
	}
	
}
