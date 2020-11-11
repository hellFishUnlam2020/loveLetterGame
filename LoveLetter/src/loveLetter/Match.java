package loveLetter;

import java.util.ArrayList;
import java.util.List;

public class Match {

	private List<Player> players = new ArrayList<Player>();
	private int affectionTokens; // la cantidad configurada que se debe tener para ganar la partida
	private static final int MIN_TOKENS = 2;
	private static final int MAX_TOKENS = 10; // que limite ponemos?

	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;
	private Deck deck = new Deck();
	
	

	private RoundGame roundGame;

	public Match(List<Player> playersList, int affecTok) { //obligatorios para comenzar la partida
																
		try {

			validateAffectionTokens(affecTok);
			setAffectionTokens(affecTok);
			setPlayers(playersList);

		} catch (Exception exception) {
			exception.getMessage();
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getAffectionTokens() {
		return affectionTokens;
	}

	public void setAffectionTokens(int affectionTokens) {
		this.affectionTokens = affectionTokens;
	}

	public static int getMinTokens() {
		return MIN_TOKENS;
	}

	public static int getMaxTokens() {
		return MAX_TOKENS;
	}
	
	public Deck getDeck() {
		return deck;
	}

	private void addPlayerToMatch(Player player) {

		players.add(player);
	}
	
	private void removePlayerFromMatch(Player player) {

		players.remove(player);
	}
	
	public void changeAffectionTokens(int affectionTokens) {
		setAffectionTokens(affectionTokens);
	}
	
	private void validateAffectionTokens(int affecTok) throws Exception {

		if (affecTok < MIN_TOKENS || affecTok > MAX_TOKENS)
			throw new Exception("La cantidad de tokens ingresada es invalida");
	}

	private void validateStartMatch() throws Exception {

		if (getPlayers().size() < MIN_PLAYERS || getPlayers().size() > MAX_PLAYERS) {
			throw new Exception("La cantidad de jugadores es insuficiente o excede el límite");
		}

	}
	
	public void startRound() {
		
		roundGame = new RoundGame(players, this.deck);	
		roundGame.startRound();
		System.out.println(roundGame.getRoundWinner());
	}
	
	public void startMatch() {
		
	/*	try {
			
			validateStartMatch(); */
			for (Player player : players)
				player.setMatch(this);
			
	/*	}catch(Exception exception) {
			exception.getMessage();
		}*/
	}
	
}
