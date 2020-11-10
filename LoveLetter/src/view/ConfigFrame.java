package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConfigFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6764734868046151564L;

	private JPanel panel;
	private JButton resButton;
	private JButton fullScreenButton;
	private JButton soundButton;
	private JButton volverButton;
	
	public ConfigFrame() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		setTitle("Configuracion");
		setSize(new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight()));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfigFrame.class.getResource("/images/login_main/logo.png")));
		
//		setOpacity(0.7f);
		setBackground(new Color(0,0,0,70));
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0 ,0, 70));
		
		getContentPane().add(panel);
		
		resButton = new JButton("Resolucion");
		resButton.setBounds(0,0,300,50);
		resButton.setOpaque(true);
		resButton.setBackground(new Color(0,0,0));
		fullScreenButton = new JButton("Pantalla Completa");
		fullScreenButton.setBounds(0,50,300,50);
		soundButton = new JButton("Sonido");
		soundButton.setBounds(0,100,300,50);
		volverButton = new JButton("volver");
		volverButton.setBounds(0,150,300,50);
		volverButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		
		panel.add(resButton);
		panel.add(fullScreenButton);
		panel.add(soundButton);
		panel.add(volverButton);

		
		setLocationRelativeTo(null);
	}
}
