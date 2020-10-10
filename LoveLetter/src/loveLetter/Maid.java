package loveLetter;

public class Maid extends Card {
	@Override
	public String getName() {
		return "Mucama";
	}

	@Override
	public CardType getType() {
		return CardType.maid;
	}

	@Override
	public int getLevel() {
		return 4;
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
	public void play() {
		// TODO Add actions		
	}

}
