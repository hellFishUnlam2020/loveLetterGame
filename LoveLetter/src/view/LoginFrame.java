package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

import viewCommunication.UserLoggable;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private JPanel panel;
	private UserLoggable userLoggable;
	private JLabel loginErrorLabel;
	JTextField userField;
	
	public void setUserLoggable(UserLoggable userLoggable) {
		this.userLoggable = userLoggable;
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		ImageIcon back = new ImageIcon(LoginFrame.class.getResource("/Images/login_main/login.jpg"));
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		Dimension dim = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
		
		setSize(dim);
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/login_main/logo.png")));
		setBackground(new Color(0,0,0,90));
		getContentPane().setLayout(null);
		
		
		panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(getBackground());
		panel.setSize(dim);
		
		getContentPane().add(panel);

		JLabel backgroundLabel = new JLabel();
		backgroundLabel.setIcon(back);
		backgroundLabel.setBounds(panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
		backgroundLabel.setBackground(getBackground());
		backgroundLabel.setSize(back.getIconWidth(), back.getIconHeight());
		backgroundLabel.setLocation(new Point((dim.width-back.getIconWidth())/2, (dim.height-back.getIconHeight())/2));

		Dimension size = new Dimension(200, 50);
		
		userField = new JTextField();
		userField.setForeground(Color.white);
		userField.setText("Username");
		userField.setOpaque(false);
		userField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		userField.setBounds(dim.width/2-size.width/2, backgroundLabel.getY()+15, size.width, size.height);
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("Username");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				loginErrorLabel.setVisible(false);
				if (userField.getText().equals("Username"))
					userField.setText("");
			}
		});
		panel.add(userField);
		
		JPasswordField passField = new JPasswordField();
		passField.setForeground(Color.white);
		passField.setText("contraseña");
		passField.setOpaque(false);
		passField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		passField.setBounds(userField.getX(), userField.getY()+size.height+10, size.width, size.height);
		panel.add(passField);
		
		
		JButton enterButton = new JButton("Ingresar");
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
				if(isValidUserName()) {
					userLoggable.userLogged(userField.getText());
//					JOptionPane.showConfirmDialog(null, "Bienvendo "+ userField.getText());
					dispose();					
				}
			}
		});
		panel.add(enterButton);
		
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
		
		getRootPane().setDefaultButton(enterButton);
		panel.add(backgroundLabel);
		
		setVisible(true);
		enterButton.requestFocus();
	}
	
	private boolean isValidUserName() {
		boolean validName = true;
		
		if(userField.getText().isEmpty()||userField.getText().equals("Username")) {
			loginErrorLabel.setText("Nombre de Usuario Incorrecto");
			loginErrorLabel.setVisible(true);
			validName = false;
		}
		
		return validName;
	}
}

