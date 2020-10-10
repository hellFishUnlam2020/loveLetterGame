package loveLetter;

public class Princess extends Card {

	@Override
	public String getName() {
		return "Princesa";
	}

	@Override
	public CardType getType() {
		return CardType.princess;
	}

	@Override
	public int getLevel() {
		return 8;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return false;
	}

	@Override
	public boolean isPlayable() {
		return false;
	}

	@Override
	public void play() {
		//It's not playable, otherwise the player lose
	}
}
