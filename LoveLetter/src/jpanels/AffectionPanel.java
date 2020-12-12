package jpanels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;

public class AffectionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086485304897456634L;

	public AffectionPanel(int x, int y, int cant, int offset, String path) {
		
		setLayout(null);
		setBorder(null);
		
		ImageIcon affection = new ScaledIcon(path).getScaledIcon();
		for(int i = 0; i < cant; i++) {
			JLabel label = new JLabel();
			label.setIcon(affection);
			label.setSize(affection.getIconWidth(), affection.getIconHeight());
			label.setLocation(affection.getIconWidth()*i, 0);
			add(label);
		}
		
		setSize(affection.getIconWidth()*cant, affection.getIconHeight());
		setLocation((int) (x + offset - (cant+0.1)/2*affection.getIconWidth()), y);
	}
}
