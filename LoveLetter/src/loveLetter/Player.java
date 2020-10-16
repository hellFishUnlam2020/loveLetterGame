package loveLetter;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private int matchPoints;
	private Status status;
	private List<Card> cards = new LinkedList<Card>();

	public Player(String name) {
		this.name = name;
		this.matchPoints = 0;
		this.status = Status.AVAILABLE;
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

	public List<Card> getCartas() {
		return cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void increaseMatchPoint(int points) {
		this.matchPoints += points;
	}

	public void takeCard() {

	}

	public void playCard() {

	}

}
