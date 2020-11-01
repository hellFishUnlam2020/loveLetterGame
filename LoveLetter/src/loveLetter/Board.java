package loveLetter;

import java.util.ArrayList;
import java.util.List;

import cards.Card;

public class Board{
	
	private List<Card> playedCards;

	public Board(){
		
		playedCards = new ArrayList<Card>();
		
	}
	
	public List<Card> getPlayedCards() {
		return playedCards;
	}

	public void addPlayedCard( Player player, Card card){
		
			playedCards.add(card);	//el player para qu� lo usar�amos?	
		
	}
}
