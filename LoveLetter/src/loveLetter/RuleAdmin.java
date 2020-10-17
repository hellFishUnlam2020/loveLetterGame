package loveLetter;

public class RuleAdmin {
	
	public static final RuleAdmin ruleAdmin = new RuleAdmin();
	private RoundGame round;
	private Board board;
	
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public RoundGame getRound() {
		return round;
	}
	public void setRound(RoundGame round) {
		this.round = round;
	}
	
	//Methods ejecutables desde las cartas
	
	public Player choosePlayer() {
		//Interfaz visual que nos devuelva lo que el user elije
		return new Player("fake");
	}
	
	public Card chooseCard() {
		//Interfaz visual que nos devuelva lo que el user elije
		return new Guard();
	}

	
	public void applySafeBlock(Player player) {
		
	}
	
	public void showPlayerCards(Player player) {
		
	}
	
	public void eliminatePlayerForCard(Player player, Card card) {
		
	}
}
