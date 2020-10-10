package loveLetter;

public class Guard extends Card {
	@Override
	public String getName() {
		return "Guardia";
	}

	@Override
	public CardType getType() {
		return CardType.guard;
	}

	@Override
	public int getLevel() {
		return 1;
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
