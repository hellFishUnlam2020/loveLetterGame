package loveLetter;

import cards.Baron;
import cards.Card;
import cards.Countless;
import cards.Guard;
import cards.King;
import cards.Maid;
import cards.Priest;
import cards.Prince;
import cards.Princess;

public class Deck implements Deckable {
	private Card[] cards;
	private int nextPositionCard;
	private int eliminatedPsition;
	private int remainingCards;
	private static final int CANT_MAX_CARDS = 16;

	public Deck() {
		cards = new Card[CANT_MAX_CARDS];
		nextPositionCard = 0;
		eliminatedPsition = 0;
		remainingCards = CANT_MAX_CARDS;
	}

	public void createCards() {
		// Creamos 5 cartas Guardia
		cards[0] = new Guard();
		cards[1] = new Guard();
		cards[2] = new Guard();
		cards[3] = new Guard();
		cards[4] = new Guard();

		// Creamos 2 cartas Sacerdote
		cards[5] = new Priest();
		cards[6] = new Priest();

		// Creamos 2 cartas Bar�n
		cards[7] = new Baron();
		cards[8] = new Baron();

		// Creamos 2 cartas Mucama
		cards[9] = new Maid();
		cards[10] = new Maid();

		// Creamos 2 cartas Principe
		cards[11] = new Prince();
		cards[12] = new Prince();

		// Creamos 1 carta Rey
		cards[13] = new King();

		// Creamos 1 carta Condesa
		cards[14] = new Countless();

		// Creamos 1 carta Princesa
		cards[15] = new Princess();
	}

	public void mixCards() {
		Card changeCard;
		for (int i = 0; i < cards.length; i++) {
			int randomPosition = (int)(Math.random()*CANT_MAX_CARDS);
			changeCard = cards[i];
			cards[i] = cards[randomPosition];
			cards[randomPosition] = changeCard;
		}
	}
	
	public void discardRandomCard() {
		this.eliminatedPsition = (int)(Math.random()*CANT_MAX_CARDS);
		this.remainingCards--;
	}
	
	public Card popCard() {
		if(eliminatedPsition == nextPositionCard) {
			nextPositionCard++;
		}
		int positionReturn = nextPositionCard;
		nextPositionCard++;
		remainingCards--;
		return cards[positionReturn];
	}
	
	public int getRemainingCards() {
		return this.remainingCards;
	}
	
	public Card[] getCards() {
		Card [] cards = new Card [8];
		cards[0] = new Guard();
		cards[1] = new Priest();
		cards[2] = new Baron();
		cards[3] = new Maid();
		cards[4] = new Prince();
		cards[5] = new King();
		cards[6] = new Countless();
		cards[7] = new Princess();
		
		return cards;
	}
}
