package loveLetter;

public class Countless extends Card {
	@Override
	public String getName() {
		return "Condesa";
	}

	@Override
	public CardType getType() {
		return CardType.countless;
	}

	@Override
	public int getLevel() {
		return 7;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return false;
	}

	@Override
	public boolean isPlayable() {
		return true;
	}

	@Override
	public void play(Player player, Card card) {
		// TODO Add actions
	}
}
