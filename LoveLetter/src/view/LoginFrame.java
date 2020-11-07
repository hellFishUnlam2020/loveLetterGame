package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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
import javax.swing.border.MatteBorder;

import viewCommunication.UserLoggable;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private JPanel panel;
//	private JTextField nameTextField;
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

//		setTitle("Antes de arrancar");
		
		setPreferredSize(new Dimension(back.getIconWidth(), back.getIconHeight()));
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(back.getIconWidth(), back.getIconHeight());
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, getWidth(), getHeight());
		panel.setLayout(null);
		getContentPane().add(panel);
		

//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(null);
//		setContentPane(contentPane);
		Dimension size = new Dimension(200, 50);
		
		userField = new JTextField();
		userField.setForeground(Color.white);
		userField.setText("UserName");
		userField.setOpaque(false);
		userField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		userField.setBounds(panel.getWidth()/2-size.width/2, 5, size.width, size.height);
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (userField.getText().isEmpty()) {
					userField.setText("UserName");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (userField.getText().equals("UserName"))
					userField.setText("");
			}
		});
		panel.add(userField);
		
		JPasswordField passField = new JPasswordField();
		passField.setForeground(Color.white);
		passField.setText("contraseña");
		passField.setOpaque(false);
		passField.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255,255,255)));
		passField.setBounds(panel.getWidth()/2-size.width/2, size.height+5, size.width, size.height);
		panel.add(passField);
		
//		JLabel titleLabel = new JLabel("Login");
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		titleLabel.setBounds(177, 6, 61, 16);
//		contentPane.add(titleLabel);
		
//		JLabel nameLabel = new JLabel("Ingresa tu nombre:");
//		nameLabel.setBounds(50, 89, 130, 16);
//		contentPane.add(nameLabel);
		
//		nameTextField = new JTextField();
//		nameTextField.setBounds(222, 84, 173, 26);
//		contentPane.add(nameTextField);
//		nameTextField.setColumns(10);
		
//		JButton enterButton = new JButton("Entrar");
//		enterButton.setBounds(149, 146, 117, 29);
//		contentPane.add(enterButton);
		
//		loginErrorLabel = new JLabel("New label");
//		loginErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		loginErrorLabel.setVisible(false);
//		loginErrorLabel.setForeground(Color.RED);
//		loginErrorLabel.setBounds(6, 118, 404, 16);
//		contentPane.add(loginErrorLabel);
		
		JButton enterButton = new JButton("Ingresar");
		enterButton.setOpaque(false);
		enterButton.setContentAreaFilled(false);
		enterButton.setBorder(null);
		enterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		enterButton.setBounds(panel.getWidth()/2-size.width/2, size.height*2+25, size.width, size.height);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isValidUserName()) {
					userLoggable.userLogged(userField.getText());
//					JOptionPane.showConfirmDialog(null, "Bienvendo "+ userField.getText())
					dispose();					
				}
			}
		});
		panel.add(enterButton);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(back);
		backgroundLabel.setBounds(0, 0, back.getIconWidth(), back.getIconHeight());
		panel.add(backgroundLabel);
		
		pack();
		setVisible(true);
	}
	
	private boolean isValidUserName() {
		boolean validName = true;
		
		if(userField.getText().isEmpty()) {
			loginErrorLabel.setText("No podes tener un nombre vacio");
			loginErrorLabel.setVisible(true);
			validName = false;
		}
		
		return validName;
	}
}
