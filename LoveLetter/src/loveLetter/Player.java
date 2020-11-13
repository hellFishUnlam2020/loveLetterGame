package loveLetter;

import java.util.LinkedList;
import java.util.List;

import cards.Card;

public class Player implements Comparable<Player> {
	
	private String name;
	private int matchPoints;
	private Status status;
	private List<Card> cards = new LinkedList<Card>();
	private int cantRoundPlayedCards;
	private Match match;
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Player(String name) {
		this.name = name;
		this.matchPoints = 0;
		this.status = Status.AVAILABLE;
		this.cantRoundPlayedCards = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMatchPoints() {
		return matchPoints;
	}

	public void setMatchPoints(int matchPoints) {
		this.matchPoints = matchPoints;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void increaseMatchPoint() {
		this.matchPoints ++;
	}

	public int getCantRoundPlayedCards() {
		return cantRoundPlayedCards;
	}

	public void setCantRoundPlayedCards(int cantRoundPlayedCards) {
		this.cantRoundPlayedCards = cantRoundPlayedCards;
	}

	public void takeCard(Card card) {
		addCard(card);
	}

	public void playCard() {

		/*
		 * aca deberiamos seleccionar una carta de las 2 que tenemos en mano, por el
		 * momento elegimos siempre la primera
		 */
		cards.get(1).play(null, null);
		this.cantRoundPlayedCards++;
	}

	@Override
	public int compareTo(Player otherPlayer) {
		System.out.println(this);
		System.out.println(otherPlayer);
		System.out.println("");

		// Obtenermos mayor carta en mano del objeto llamador
		int thisMaximunLevel = 0;
		for (Card card : cards) {
			if (thisMaximunLevel < card.getLevel()) {
				thisMaximunLevel = card.getLevel();
			}
		}

		// Obtenemos mayor carta en mano del jugador a comparar
		int otherMaximunLevel = 0;
		for (Card card : otherPlayer.getCards()) {
			if (otherMaximunLevel < card.getLevel()) {
				otherMaximunLevel = card.getLevel();
			}
		}

		// Primero comparamos por mejor carta
		if (thisMaximunLevel > otherMaximunLevel) {
			return 1;
		} else {
			if (thisMaximunLevel < otherMaximunLevel) {
				return -1;
			} else {
				if (this.cantRoundPlayedCards > otherPlayer.getCantRoundPlayedCards()) {
					return 1;
				} else {
					if (this.cantRoundPlayedCards < otherPlayer.getCantRoundPlayedCards()) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		}
	}

}
