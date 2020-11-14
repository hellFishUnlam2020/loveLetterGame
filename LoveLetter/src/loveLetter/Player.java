package loveLetter;

import java.util.LinkedList;
import java.util.List;

import cards.Card;
import cards.CardType;
import jpanels.PlayerLabel;

public class Player implements Comparable<Player> {

	private String name;
	private int matchPoints;
	private Status status;
	private List<Card> cards = new LinkedList<Card>();
	private int cantRoundPlayedCards;
	private Match match;
	private PlayerLabel label;
	private boolean isTurn = false;
	private boolean isProtected = false;
	
	public Player(String name) {
		
		this.name = name;
		this.matchPoints = 0;
		this.status = Status.AVAILABLE;
		this.cantRoundPlayedCards = 0;
	}
	
	public void setTurn(Boolean turn) {
		isTurn = turn;
		setCardsVisible(turn);
	}
	
	public void setCardsVisible(boolean val) {
		label.setCardsVisible(val);
	}
	
	public boolean getTurn() {
		return isTurn;
	}
	
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
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
		if(status == Status.DISABLE)
			label.setProtected("Disable", true);
		if(status == Status.PROTECTED)
			label.setProtected("Protected", true);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
		label.setCard(card);
	}

	public void increaseMatchPoint() {
		this.matchPoints++;
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

	public void discardCard(Card card) {

		this.getCards().remove(card);
	}

	public void playCard() {

		// Un approach

		Card card;
		RuleAdmin admin = RuleAdmin.getRuleadmin();

		// se chequea si se posee Condesa+Rey o Condesa+Principe
		if (admin.playerHasCountessCard(this) && admin.playerHasToPlayCountessCard(this)) {
			card = getCardOfType(CardType.countess);
			card.play(this);

		} else {

			while(label.getCardSelected() == null) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			card = label.getCardSelected();
			removeCard(label.getNCardSelected());
			label.resetCardSelected();

			card.play(this); // Agrego el jugador que debe la juega

		}

		// ---------------------------------------------

		// otro approach

		/*
		 * aca deberiamos seleccionar una carta de las 2 que tenemos en mano, por el
		 * momento elegimos siempre la primera
		 */

		// RuleAdmin admin = RuleAdmin.getRuleadmin();
		// Card cardChoosed = admin.chooseCard(this);
		// cardChoosed.play(this); //el metodo play recibe el currentPlayer

		// ---------------------------------------------

		this.cantRoundPlayedCards++;
	}

	public Card getCardOfType(CardType type) {

		Card cardResult = null;

		for (Card card : this.getCards()) {

			if (card.getType().equals(type))
				cardResult = card;
		}

		return cardResult;
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
	
	public void removeCard(int n) {
		cards.remove(n);
	}

	public PlayerLabel getLabel() {
		return label;
	}

	public void setLabel(PlayerLabel label) {
		this.label = label;
	}
	
	public boolean isProtected() {
		return isProtected;
	}
	
	public void setProteced(boolean val) {
		isProtected = val;
		label.setProtected("Protected", val);
	}
	
	public void setAsWinner() {
		label.setProtected("Winner", true);
	}
}
