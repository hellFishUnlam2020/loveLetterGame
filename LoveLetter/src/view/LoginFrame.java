package view;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewCommunication.UserLoggable;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2468719791156400022L;
	private JPanel contentPane;
	private JTextField nameTextField;
	private UserLoggable userLoggable;
	private JLabel loginErrorLabel;
	
	public void setUserLoggable(UserLoggable userLoggable) {
		this.userLoggable = userLoggable;
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setTitle("Antes de arrancar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 416, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(177, 6, 61, 16);
		contentPane.add(titleLabel);
		
		JLabel nameLabel = new JLabel("Ingresa tu nombre:");
		nameLabel.setBounds(50, 89, 130, 16);
		contentPane.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(222, 84, 173, 26);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JButton enterButton = new JButton("Entrar");
		enterButton.setBounds(149, 146, 117, 29);
		contentPane.add(enterButton);
		
		loginErrorLabel = new JLabel("New label");
		loginErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginErrorLabel.setVisible(false);
		loginErrorLabel.setForeground(Color.RED);
		loginErrorLabel.setBounds(6, 118, 404, 16);
		contentPane.add(loginErrorLabel);
		
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isValidUserName()) {
					userLoggable.userLogged(nameTextField.getText());
					dispose();					
				}
			}
		});
	}
	
	private boolean isValidUserName() {
		boolean validName = true;
		
		if(nameTextField.getText().isEmpty()) {
			loginErrorLabel.setText("No podes tener un nombre vacío");
			loginErrorLabel.setVisible(true);
			validName = false;
		}
		
		return validName;
	}
}
