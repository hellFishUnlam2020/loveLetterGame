package loveLetter;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class RoundGameTest {

	RoundGame roundGame;
	CardRemovable deck;
	List<Player> players;
 
    @AfterEach
    public void finalize() {
    	deck = null;
    	roundGame = null;
    	players = null;
    }

	@Test
	public void testThatStarRoundGaveCards() {
		createPlayerListOfTwoWithoutCards();
		Card expectedCard = new Guard();
    	deck = new CardRemovableMock(expectedCard, 4);
    	roundGame = new RoundGame(players, deck);

    	roundGame.startRound();
    	Card card = players.get(0).getCards().get(0);
    	
    	Assert.assertEquals(card.getType(), expectedCard.getType());
	}
	
	@Test
	public void testThatGetRoundWinnerGaveFirstAsWinner() {
		createPlayerListOfTwoWithCards();
    	deck = new CardRemovableMock(null, 4);
    	roundGame = new RoundGame(players, deck);

    	Player winner =  roundGame.getRoundWinner();
    	
    	Assert.assertEquals(players.get(0) , winner);
	}

	@Test
	public void testThatGetRoundWinnerGaveSecondAsWinnerWithEqualsCards() {
		createPlayerListOfTwoWithEqualsCards();
    	deck = new CardRemovableMock(null, 4);
    	roundGame = new RoundGame(players, deck);

    	Player winner =  roundGame.getRoundWinner();
    	
    	Assert.assertEquals(players.get(1) , winner);
	}

	@Test
	public void testThatGetRoundWinnerForTheSameCardButMoreDiscards() {
		
		// Jugador con carta Guardia y con 3 descartes
		Player player1 =  new Player("Sergio");
		player1.addCard(new Guard());
		player1.setCantRoundPlayedCards(3);
		
		// Jugador con carta Guardia y con 4 descartes (Ganador)
		Player player2 =  new Player("Sebastian");
		player2.addCard(new Guard());
		player2.setCantRoundPlayedCards(4);
		
		players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		
    	deck = new CardRemovableMock(null, 4);
    	roundGame = new RoundGame(players, deck);

    	Player winner =  roundGame.getRoundWinner();
    	
    	Assert.assertEquals(players.get(1) , winner);
	}
	
	@Test
	public void testIncreasePoints() {
		createPlayerListOfTwoWithCards();
		
		deck = new CardRemovableMock(null, 4);
		
		RoundGame round = new RoundGame(players, deck);
		round.startRound();
		
		Assert.assertEquals(1, round.getRoundWinner().getMatchPoints());
		
	}
	
	
	
	public void createPlayerListOfTwoWithCards() {
		players = new ArrayList<Player>();
		
		Player juan =  new Player("Juan");
		juan.addCard(new King());
		Player jose =  new Player("Jose");
		jose.addCard(new Priest());

		players.add(juan);
		players.add(jose);
	}
	
	public void createPlayerListOfTwoWithEqualsCards() {
		players = new ArrayList<Player>();
		
		Player juan =  new Player("Juan");
		juan.addCard(new Guard());
		Player jose =  new Player("Jose");
		jose.addCard(new Guard());

		players.add(juan);
		players.add(jose);
	}

	
	public void createPlayerListOfTwoWithoutCards() {
		players = new ArrayList<Player>();
		
		Player juan =  new Player("Juan");
		Player jose =  new Player("Jose");
		
		players.add(juan);
		players.add(jose);
	}

}
