package jpanels;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class GameFont {

	private Font font;
	
	public GameFont() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/Minion Pro Bold Cond Caption.otf"));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public Font getFont() {
		return font;
	}
}
