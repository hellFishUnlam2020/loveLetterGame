package jpanels;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.MatchFrame;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 982821929971812735L;

	private double aspectRelX;
	private double aspectRelY;
	private Dimension screenDim;
	
	public BoardPanel(MatchFrame frame) {
		
		screenDim = frame.getSize();

		aspectRelX = (double) screenDim.width / 1920;
		aspectRelY = (double) screenDim.height / 1080;
		
		setBorder(null);
		setLayout(null);
		setSize(screenDim);
		
		ImageIcon back = new ImageIcon(getClass().getResource("/images/board.png"));
		Image scaledBack = back.getImage().getScaledInstance((int) Math.ceil(aspectRelX * back.getIconWidth()), (int) Math.ceil(aspectRelY * back.getIconHeight()), Image.SCALE_SMOOTH);

		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ImageIcon(scaledBack));
		backLabel.setSize(backLabel.getIcon().getIconWidth(), backLabel.getIcon().getIconHeight());
		
		add(backLabel);
		frame.getContentPane().add(this);
	}

}
