package loveLetter;

import java.util.ArrayList;
import java.util.List;

public class Board{
	
	private List<Card> playedCards;

	public Board(){
		
		playedCards = new ArrayList<Card>();
		
	}
	
	public List<Card> getPlayedCards() {
		return playedCards;
	}

	public void addPlayedCard( Player player, Card card){
		
			playedCards.add(card);	//el player para qué lo usaríamos?	
		
	}
}
