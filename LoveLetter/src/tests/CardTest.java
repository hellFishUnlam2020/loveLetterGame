package tests;

import cards.*;
import loveLetter.*;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class CardTest {

	
	public PlayerFake createPlayer(String name) {
		
		PlayerFake player = new PlayerFake(name);		
		return player;
	}
	
	
	@Test
	public void playerPredictCardTest() { //Testeo de Guard
	 	
		PlayerFake pOne = createPlayer("player one");
		PlayerFake pTwo = createPlayer("player two");
		
		assertEquals(pTwo.getStatus(),Status.AVAILABLE);
		
		pOne.addCard( new Guard());
		pTwo.addCard( new King());
		
		//se adivina la carta del rival
		pOne.getCards().get(0).applyEffect(pOne, pTwo);
		
		assertEquals(pTwo.getStatus(),Status.DISABLE);
	}

	@Test
	public void playerNotPredictCardTest() { //Testeo de Guard
	 	
		PlayerFake pOne = createPlayer("player one");
		PlayerFake pTwo = createPlayer("player two");
		
		assertEquals(pTwo.getStatus(),Status.AVAILABLE);
		
		pOne.addCard( new Guard());
		pTwo.addCard( new Princess());
	
		//no se adivina la carta del rival
		pOne.getCards().get(0).applyEffect(pOne, pTwo);
		
		assertEquals(pTwo.getStatus(),Status.AVAILABLE);
	}
	
	@Test
	public void playerCardLevelTest() { //Test Baron
	 	
		PlayerFake pOne = createPlayer("player one");
		PlayerFake pTwo = createPlayer("player two");
		
		assertEquals(pOne.getStatus(),Status.AVAILABLE);
		assertEquals(pTwo.getStatus(),Status.AVAILABLE);
		
		pOne.addCard( new Baron()); 	//Fuerza 3
		pTwo.addCard( new Prince());	//Fuerza 5
		
		//se comparan los niveles de las cartas
		pOne.getCards().get(0).applyEffect(pOne, pTwo);
		
		assertEquals(pOne.getStatus(),Status.DISABLE);
	}

	@Test
	public void playerSwapCardsTest() { //Test King
	 	
		PlayerFake pOne = createPlayer("player one");
		PlayerFake pTwo = createPlayer("player two");
		Card kingCard = new King();
		
		pOne.addCard( new Guard());
		pTwo.addCard( new Prince());
		
		//se realiza el intercambio de cartas
		kingCard.applyEffect(pOne, pTwo);
	
		assertEquals(pOne.getCards().get(0).getType(),CardType.prince);
		assertEquals(pTwo.getCards().get(0).getType(),CardType.guard);
		
	}
	
	@Test
	public void playerProtectedTest() { //Test Maid
	 	
		PlayerFake pOne = createPlayer("player one");
		assertEquals(pOne.getStatus(),Status.AVAILABLE);
		
		pOne.addCard(new Maid());
		
		//el player queda protegido
		pOne.getCards().get(0).applyEffect(pOne, null);
	
		assertEquals(pOne.getStatus(),Status.PROTECTED);
	}

//	@Test
//	public void playerDiscardCardsTest() { //Test Prince
//	 	
//		PlayerFake pOne = createPlayer("player one");
//		Card princeCard = new Prince();
//		Match match = new Match(new ArrayList<Player>(),4 );
//		match.getDeck().createCards();
//		
//		pOne.addCard(new Maid());
//		pOne.setMatch(match);
//		
//		assertEquals(pOne.getCards().get(0).getType(),CardType.maid);
//		
//		princeCard.applyEffect(null, pOne);
//			
//		assertNotEquals(pOne.getCards().get(0).getType(),CardType.maid);
//	}
	
	
}
