package loveLetter;

public class King extends Card {
	@Override
	public String getName() {
		return "Rey";
	}

	@Override
	public CardType getType() {
		return CardType.king;
	}

	@Override
	public int getLevel() {
		return 6;
	}

	@Override
	public boolean shouldSelectAPlayer() {
		return true;
	}

	@Override
	public boolean isPlayable() {
		//TODO check for a Countless
		//Its not playable when the player has a Countless
		return true;
	}

	@Override
	public void play() {
		// TODO Add actions
		
	}
}
