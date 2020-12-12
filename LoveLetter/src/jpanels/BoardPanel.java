 package jpanels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 982821929971812735L;
	
	public BoardPanel() {
		
		setSize(GameConstants.screenSize);
		setBorder(null);
		setLayout(null);
		
		addBackground();
	}

	private void addBackground() {
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ScaledIcon("/images/board.png").getScaledIcon());
		backLabel.setSize(backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		add(backLabel);
	}
}
