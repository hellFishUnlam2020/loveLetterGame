package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import interfaces.GameConstants;
import jpanels.BackgroundLabel;
import jpanels.CreateButton;
import jpanels.GameFont;
import jpanels.ScaledBounds;
import jpanels.ScaledIcon;
import jpanels.TextLabel;
import loveLetter.Player;

public class LoginFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private Dimension componentSize;
	private int xComponentAlligment;

	private JTextField userField;
	private JPasswordField passField;

	private JButton enterButton;
	private JLabel backgroundLabel;
	private Font font = new GameFont().getFont().deriveFont(35f);

	private JLabel errorBack;
	private TextLabel errorText1;
	private TextLabel errorText2;

	private JLabel userBack;
	private JLabel passBack;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/login.jpg"));
		
		setTitle("Login");
		setIconImage(GameConstants.logo);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		addBackground();
		setSize(icon.getIconWidth(), icon.getIconHeight());

		componentSize = new Dimension(200, 50);
		xComponentAlligment = (getWidth() - componentSize.width) /2;
				
		addUserField();
		addPassField();
		addEnterButton();
		addLoginError();
		
		addUserTiny();
		addPassTiny();

		getContentPane().setComponentZOrder(backgroundLabel, getContentPane().getComponentCount() - 1);
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					dispose();
				}
			}
		});
		
		setSize(backgroundLabel.getWidth(), backgroundLabel.getHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
		
	}

	// ---------------------------------------------------------------
	// Screen config
	// BackgroundLabel

	public void addBackground() {
		backgroundLabel = new BackgroundLabel(new ScaledIcon("/images/login.jpg").getScaledIcon());
		getContentPane().add(backgroundLabel);
	}

	// UserField

	public void addUserField() {

		userField = new JTextField();
		userField.setOpaque(false);
		userField.setForeground(Color.white);
		userField.setFont(font.deriveFont(20f));
		userField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
		userField.setBounds(new ScaledBounds(xComponentAlligment, 15 , componentSize.width, componentSize.height).getScaledRect());
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					validUserName();
			}
		});
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userBack.setFont(userBack.getFont().deriveFont(20f));
					userBack.setSize(componentSize.width, componentSize.height);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				userBack.setFont(userBack.getFont().deriveFont(13f));
				userBack.setSize(componentSize.width / 3, componentSize.height / 4);
				errorBack.setVisible(false);
				errorText1.setText("");
				errorText2.setText("");
			}
		});
		getContentPane().add(userField);

	}

	public void addUserTiny() {
		userBack = new TextLabel(new Rectangle(xComponentAlligment, 15, componentSize.width, componentSize.height),
				Color.white, 20f);
		userBack.setText("Username");
		userBack.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(userBack);
	}

	// PassField

	public void addPassField() {
		passField = new JPasswordField();
		passField.setFont(font.deriveFont(20f));
		passField.setForeground(Color.white);
		passField.setOpaque(false);
		passField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
		passField.setBounds(new ScaledBounds(xComponentAlligment, componentSize.height+15, componentSize.width, componentSize.height).getScaledRect());
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					validUserName();
			}
		});
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0) {
					passBack.setFont(passBack.getFont().deriveFont(20f));
					passBack.setSize(componentSize.width, componentSize.height);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				passBack.setFont(passBack.getFont().deriveFont(13f));
				passBack.setSize(componentSize.width / 3, componentSize.height / 4);
				errorBack.setVisible(false);
				errorText1.setText("");
				errorText2.setText("");
			}
		});
		getContentPane().add(passField);
	}

	public void addPassTiny() {

		passBack = new TextLabel(new Rectangle(xComponentAlligment, componentSize.height +15, componentSize.width, componentSize.height),
				Color.white, 20f);
		passBack.setText("Password");
		passBack.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(passBack);
	}

	// EnterButton

	public void addEnterButton() {
		enterButton = new CreateButton(xComponentAlligment, componentSize.height*2 + 40, componentSize.width, componentSize.height);
		enterButton.setText("Ingresar");
		enterButton.setFont(font);
		enterButton.setForeground(new Color(238, 222, 155));
		enterButton.setFocusPainted(false);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				validUserName();
			}
		});
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterButton.setFont(enterButton.getFont().deriveFont(40f));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				enterButton.setFont(enterButton.getFont().deriveFont(35f));
			}
		});
		getContentPane().add(enterButton);
	}

	// LoginErrorLabel

	public void addLoginError() {
		errorBack = new JLabel();
		errorBack.setIcon(new ScaledIcon("/images/loginAlert.png").getScaledIcon());
		errorBack.setBounds(new ScaledBounds(getWidth() - errorBack.getIcon().getIconWidth(), 0, errorBack.getIcon().getIconWidth(), errorBack.getIcon().getIconHeight()).getScaledRect());
		errorBack.setVisible(false);

		errorText1 = new TextLabel(
				new Rectangle(getWidth()-errorBack.getWidth(), userField.getY(), 200, 30),
				Color.white, 22f);
		errorText2 = new TextLabel(
				new Rectangle(getWidth()-errorBack.getWidth()-10, errorText1.getY() + errorText1.getHeight(), 200, 30), Color.white,
				22f);

		getContentPane().add(errorText1);
		getContentPane().add(errorText2);
		getContentPane().add(errorBack);
	}

	// ---------------------------------------------------------------
	// Event methods

	private void validUserName() {

		if (userField.getText().isEmpty() || userField.getText().equals("Username")) {
			errorBack.setVisible(true);
			errorText1.setText("Invalid");
			errorText2.setText("Username");
		} else {
			userLogged(userField.getText());
			dispose();
		}
	}

	// ---------------------------------------------------------------
	// Main

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void userLogged(String name) {
		new GameFrame(new Player(name)).setVisible(true);
	}
}
