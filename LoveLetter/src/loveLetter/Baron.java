package loveLetter;

public class Baron extends Card {
	@Override
	public String getName() {
		return "Baron";
	}

	@Override
	public CardType getType() {
		return CardType.baron;
	}

	@Override
	public int getLevel() {
		return 3;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return true;
	}

	@Override
	public boolean isPlayable() {
		return true;
	}

	@Override
	public void play() {
		// TODO Add actions
	}
}
