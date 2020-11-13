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
	private JLabel backgroundLabel;

	public BoardPanel(MatchFrame frame) {
		
		screenDim = frame.getSize();

		aspectRelX = (double) screenDim.width / 1920;
		aspectRelY = (double) screenDim.height / 1080;

		setSize(screenDim);
		setLayout(null);
		setBorder(null);
		
		ImageIcon back = new ImageIcon(getClass().getResource("/images/board.png"));
		Image scaledBack = back.getImage().getScaledInstance((int) Math.ceil(aspectRelX * back.getIconWidth()), (int) Math.ceil(aspectRelY * back.getIconHeight()), Image.SCALE_SMOOTH);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		
		add(backgroundLabel);
		
		setVisible(true);
		frame.repaint();
	}
}
