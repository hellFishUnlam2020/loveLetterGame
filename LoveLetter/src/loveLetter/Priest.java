package loveLetter;

public class Priest extends Card {
	@Override
	public String getName() {
		return "Sacerdote";
	}

	@Override
	public CardType getType() {
		return CardType.priest;
	}

	@Override
	public int getLevel() {
		return 2;
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
