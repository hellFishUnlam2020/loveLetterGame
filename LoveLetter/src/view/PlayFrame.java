package view;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4329582399066939716L;
	
	private JLabel backgroundLabel;
	public PlayFrame() {		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Dimension screen = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		ImageIcon back = new ImageIcon(PlayFrame.class.getResource("/images/board.png"));
		
		Image scaledBack = back.getImage().getScaledInstance(screen.width, screen.height, Image.SCALE_SMOOTH);

		setUndecorated(true);
		setSize(screen.width, screen.height);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PlayFrame.class.getResource("/images/login_main/logo.png")));
		setTitle("Love Letter");
		setLayout(null);
		
		JButton button = new JButton("HOLA BOTON");
		button.setBounds(0,0,100,100);
		button.setSize(new Dimension(100, 100));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(button);
		
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ImageIcon(scaledBack));
		backgroundLabel.setSize(getSize());
		getContentPane().add(backgroundLabel);
	}
}
