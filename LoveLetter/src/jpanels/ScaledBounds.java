package jpanels;

import java.awt.Dimension;
import java.awt.Rectangle;

import interfaces.GameConstants;

public class ScaledBounds {

	public Rectangle r;
	public Dimension d;
	
	public ScaledBounds(int x, int y, int width, int height) {
		this.r = new Rectangle((int) Math.ceil(x * GameConstants.aspectRelX),
				(int) Math.ceil(y * GameConstants.aspectRelY), (int) Math.ceil(width * GameConstants.aspectRelX),
				(int) Math.ceil(height * GameConstants.aspectRelY));
	}

	public ScaledBounds(int x, int y) {
		this.d = new Dimension((int) Math.ceil(x * GameConstants.aspectRelX),
				(int) Math.ceil(y * GameConstants.aspectRelY));
	}
	
	public Dimension getScaledDim() {
		return d;
	}
	public Rectangle getScaledRect() {
		return r;
	}
}
