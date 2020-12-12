 package loveLetter;

import java.util.List;

import jpanels.MainMenu;
import view.MatchFrame;

public class Match extends Thread{

	private List<Player> players;
	private int affectionTokens; // la cantidad configurada que se debe tener para ganar la partida
	private static final int MIN_TOKENS = 2;
	private static final int MAX_TOKENS = 10; // que limite ponemos?

	private static final int MIN_PLAYERS = 2;
	private static final int MAX_PLAYERS = 4;
	private Deck deck = new Deck();

	private MatchFrame frame;

	private RoundGame roundGame;
	
	public Match(List<Player> players, int affecTok, MatchFrame frame) { //obligatorios para comenzar la partida	
		
		this.frame = frame;
		this.affectionTokens = affecTok;
		this.players = players;
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
		
	}
	
	public void run() {

		for (Player player : players)
			player.setMatch(this);
		startRound();
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new MainMenu());
		frame.repaint();
	}
	
}
