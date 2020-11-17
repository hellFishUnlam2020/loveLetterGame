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

import interfaces.ScreenConstants;
import jpanels.CreateButton;
import jpanels.GameFont;
import jpanels.ScaledIcon;
import jpanels.TextLabel;
import loveLetter.Player;
import viewCommunication.UserLoggable;

public class LoginFrame extends JFrame implements UserLoggable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private JTextField userField;
	private JPasswordField passField;
	private Dimension size;

	private JButton enterButton;
	private JLabel backgroundLabel;
	private Font font = new GameFont().getFont().deriveFont(35f);
	private Player player;

	private JLabel errorBack;
	private TextLabel errorText1;
	private TextLabel errorText2;

	private JLabel userBack;
	private JLabel passBack;

	/**
	 * Create the frame.
	 */
	public LoginFrame() {

		setTitle("Login");
		setSize(ScreenConstants.width, ScreenConstants.height);
		setIconImage(ScreenConstants.logo);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(new Color(0, 0, 0, 90));
		getContentPane().setLayout(null);

		size = new Dimension(200, 50);

		addBackground();
		addUserField();
		addPassField();
		addEnterButton();
		addLoginError();
		addUserTiny();
		addPassTiny();

		getContentPane().setComponentZOrder(backgroundLabel, getContentPane().getComponentCount() - 1);
		setVisible(true);
		enterButton.requestFocus();
	}

	// ---------------------------------------------------------------
	// Screen config
	// BackgroundLabel

	public void addBackground() {
		backgroundLabel = new JLabel();

		backgroundLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/Images/login.jpg")));
		backgroundLabel.setBackground(getBackground());
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		backgroundLabel.setLocation((ScreenConstants.width - backgroundLabel.getIcon().getIconWidth()) / 2,
				(ScreenConstants.height - backgroundLabel.getIcon().getIconHeight()) / 2);

		getContentPane().add(backgroundLabel);
	}

	// UserField

	public void addUserField() {

		userField = new JTextField();
		userField.setForeground(Color.white);
		userField.setOpaque(false);
		userField.setFont(font.deriveFont(20f));
		userField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
		userField.setBounds((ScreenConstants.width - size.width) / 2, backgroundLabel.getY() + 15, size.width,
				size.height);
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					isValidUserName();
			}
		});
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userBack.setFont(userBack.getFont().deriveFont(20f));
					userBack.setSize(size.width, size.height);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				userBack.setFont(userBack.getFont().deriveFont(13f));
				userBack.setSize(size.width / 3, size.height / 4);
				errorBack.setVisible(false);
				errorText1.setText("");
				errorText2.setText("");
			}
		});
		getContentPane().add(userField);

	}

	public void addUserTiny() {
		userBack = new TextLabel(new Rectangle(userField.getX(), userField.getY(), size.width, size.height),
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
		passField.setBounds(userField.getX(), userField.getY() + size.height + 10, size.width, size.height);
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					isValidUserName();
			}
		});
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (passField.getPassword().length == 0) {
					passBack.setFont(passBack.getFont().deriveFont(20f));
					passBack.setSize(size.width, size.height);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				passBack.setFont(passBack.getFont().deriveFont(13f));
				passBack.setSize(size.width / 3, size.height / 4);
				errorBack.setVisible(false);
				errorText1.setText("");
				errorText2.setText("");
			}
		});
		getContentPane().add(passField);
	}

	public void addPassTiny() {

		passBack = new TextLabel(new Rectangle(passField.getX(), passField.getY(), size.width, size.height),
				Color.white, 20f);
		passBack.setText("Password");
		passBack.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(passBack);
	}

	// EnterButton

	public void addEnterButton() {
		enterButton = new CreateButton(passField.getX(), passField.getY() + size.height + 25, size.width, size.height);
		enterButton.setText("Ingresar");
		enterButton.setFont(font);
		enterButton.setForeground(new Color(238, 222, 155));
		enterButton.setFocusPainted(false);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isValidUserName();
			}
		});
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterButton.setFont(enterButton.getFont().deriveFont(Font.BOLD));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				enterButton.setFont(enterButton.getFont().deriveFont(Font.PLAIN));
			}
		});
		getContentPane().add(enterButton);
	}

	// LoginErrorLabel

	public void addLoginError() {
		errorBack = new JLabel();
		errorBack.setIcon(new ScaledIcon("/images/loginAlert.png").getScaledIcon());
		errorBack.setBounds(backgroundLabel.getX() + backgroundLabel.getWidth() - errorBack.getIcon().getIconWidth(),
				backgroundLabel.getY(), errorBack.getIcon().getIconWidth(), errorBack.getIcon().getIconHeight());
		errorBack.setVisible(false);

		errorText1 = new TextLabel(
				new Rectangle(backgroundLabel.getX() + backgroundLabel.getWidth() - 200, userField.getY(), 200, 30),
				Color.white, 22f);
		errorText2 = new TextLabel(
				new Rectangle(errorText1.getX(), errorText1.getY() + errorText1.getHeight(), 200, 30), Color.white,
				22f);

		getContentPane().add(errorText1);
		getContentPane().add(errorText2);
		getContentPane().add(errorBack);
	}

	// ---------------------------------------------------------------
	// Event methods

	private boolean isValidUserName() {
		boolean validName = true;

		if (userField.getText().isEmpty() || userField.getText().equals("Username")) {
			errorBack.setVisible(true);
			errorText1.setText("Nombre de Usuario");
			errorText2.setText("Incorrecto");
			validName = false;
		} else {
			userLogged(userField.getText());
			dispose();
		}
		return validName;
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

	@Override
	public void userLogged(String name) {
		player = new Player(name);
		new GameScreen(player).setVisible(true);
	}
}
