package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import loveLetter.Player;
import viewCommunication.UserLoggable;

public class LoginFrame extends JFrame implements UserLoggable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private JPanel panel;
	private JTextField userField;
	private JPasswordField passField;
	private JButton enterButton;
	private JLabel loginErrorLabel;
	private Dimension size;
	private Dimension screen;
	private JLabel backgroundLabel;
	private ImageIcon back;
	
	private Player player;
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		screen = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());

		back = new ImageIcon(LoginFrame.class.getResource("/Images/login.jpg"));
		size = new Dimension(200,50);
		
		setSize(screen);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/logo.png")));
		setBackground(new Color(0,0,0,90));
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(getBackground());
		panel.setSize(screen);
		
		getContentPane().add(panel);
		
		addBackground();
		addUserField();
		addPassField();
		addEnterButton();
		addLoginError();
		
		panel.add(backgroundLabel);
		setVisible(true);
		enterButton.requestFocus();
	}
	
	//---------------------------------------------------------------
	//Screen config
	
	// UserField
	
	public void addUserField() {
		userField = new JTextField();
		userField.setForeground(Color.white);
		userField.setText("Username");
		userField.setOpaque(false);
		userField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		userField.setBounds(screen.width/2-size.width/2, backgroundLabel.getY()+15, size.width, size.height);
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					isValidUserName();
			}
		});
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("Username");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals("Username"))
					userField.setText("");
			}
		});
		panel.add(userField);
		
	}
	
	// PassField
	
	public void addPassField() {
		passField = new JPasswordField();
		passField.setForeground(Color.white);
		passField.setText("contraseña");
		passField.setOpaque(false);
		passField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		passField.setBounds(userField.getX(), userField.getY()+size.height+10, size.width, size.height);
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					isValidUserName();
			}
		});
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).isEmpty()) {
					passField.setText("contraseña");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passField.getPassword()).equals("contraseña"))
					passField.setText("");
			}
		});
		
		panel.add(passField);
	}
	
	// EnterButton
	
	public void addEnterButton() {
		enterButton = new JButton("Ingresar");
		enterButton.setOpaque(false);
		enterButton.setContentAreaFilled(false);
		enterButton.setBorder(null);
		enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		enterButton.setBounds(passField.getX(), passField.getY()+size.height+25, size.width, size.height);
		enterButton.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 35));
		enterButton.setForeground(Color.white);
		enterButton.requestFocusInWindow();
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				isValidUserName();
			}
		});
		panel.add(enterButton);
	}
	
	// LoginErrorLabel
	
	public void addLoginError() {
		loginErrorLabel = new JLabel();
		loginErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginErrorLabel.setVisible(false);
		loginErrorLabel.setFont(new Font("Vivaldi", Font.BOLD | Font.ITALIC, 30));
		loginErrorLabel.setForeground(Color.white);
		loginErrorLabel.setBounds(enterButton.getX()-size.width/2, backgroundLabel.getHeight()+backgroundLabel.getY(), size.width*2, size.height);
		loginErrorLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				loginErrorLabel.setVisible(false);
			}
		});
		panel.add(loginErrorLabel);
	}
	
	// BackgroundLabel
	
	public void addBackground() {
		backgroundLabel = new JLabel();
		
		backgroundLabel.setIcon(back);
		backgroundLabel.setBackground(getBackground());
		backgroundLabel.setSize(back.getIconWidth(), back.getIconHeight());
		backgroundLabel.setLocation(new Point((screen.width-back.getIconWidth())/2, (screen.height-back.getIconHeight())/2));
	}
	
	//---------------------------------------------------------------
	// Event methods
	
	private boolean isValidUserName() {
		boolean validName = true;
		
		if(userField.getText().isEmpty()||userField.getText().equals("Username")) {
			loginErrorLabel.setText("Nombre de Usuario Incorrecto");
			loginErrorLabel.setVisible(true);
			validName = false;
		}
		else {
			userLogged(userField.getText());
			dispose();
		}
		return validName;
	}
	
	//---------------------------------------------------------------
	//Main

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void userLogged(String name) {
		player = new Player(name);
		new GameScreen(player).setVisible(true);;
	}
}

