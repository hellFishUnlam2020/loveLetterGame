package jpanels;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.GameConstants;
import loveLetter.Player;
import view.MatchFrame;

public class LobbyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2816319407817472061L;

	private JButton invalidButton;
	private JButton validButton;
	private JLabel backgroundLabel;
	private List<Player> players;

	public LobbyPanel() {

		players = new ArrayList<Player>(3);

		setSize(GameConstants.screenSize);
		setLayout(null);
		setBorder(null);

		addInvalidStart();
		addValidStart();
		addBackButton();
		addConfigButton();
		addButtonAddPlayer(1254, 530);
		addBackgroundLabel();
	}

	private void addBackgroundLabel() {
		backgroundLabel = new JLabel();
		backgroundLabel.setIcon(new ScaledIcon("/images/lobby.png").getScaledIcon());
		backgroundLabel.setSize(backgroundLabel.getIcon().getIconWidth(), backgroundLabel.getIcon().getIconHeight());
		add(backgroundLabel);
	}

	private void addInvalidStart() {
		invalidButton = new CreateButton("/images/lobbyinvalid.png", 860, 820, null);
		add(invalidButton);
	}

	private void addValidStart() {
		validButton = new CreateButton("/images/lobbyValid.png", 860, 820, null);
		validButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MatchFrame(players, 5);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		add(validButton);
	}

	private void addBackButton() {
		JButton backButton = new CreateButton("/images/back.png", 606, 262, null);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) getTopLevelAncestor();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new CreateGame());
				frame.repaint();
			}
		});
		add(backButton);
	}

	private void addConfigButton() {
		JButton configButton = new CreateButton("/images/config2.png", 1254, 268, null);
		configButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
			}
		});
		add(configButton);
	}

	private void addButtonAddPlayer(int x, int y) {
		String[] nombres = { "Matias", "Gabriel", "Mauro" };

		int i = 0;
		for (String nombre : nombres) {
			JButton addButton = new CreateButton("/images/back.png", x, y, null);
			addButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					addPlayer(new Player(nombre));
				}
			});
			addButton.setLocation(addButton.getX(), addButton.getY() + (addButton.getIcon().getIconHeight() + 35) * i);
			add(addButton);
			i++;
		}
	}

	private void addPlayer(int nro) {

		int gap = 94;
		JLabel backLabel = new JLabel();
		backLabel.setIcon(new ScaledIcon("/images/lobbyP"+(nro+1)+".png").getScaledIcon());
		backLabel.setBounds((int) Math.ceil(759 * GameConstants.aspectRelX),
				(int) Math.ceil(412 + gap*nro * GameConstants.aspectRelY), backLabel.getIcon().getIconWidth(),
				backLabel.getIcon().getIconHeight());

		JLabel nombreLabel = new TextLabel(new Rectangle(858, 436 + gap*nro, 288, 37), Color.black, 30f);
		nombreLabel.setText(players.get(nro).getName());

		add(nombreLabel);
		add(backLabel);

	}

	public void refresh() {

		switch (players.size()) {
		case 1:
			addPlayer(0);
			break;
		case 2:
			addPlayer(1);
			validButton.setVisible(true);
			invalidButton.setVisible(false);
			break;
		case 3:
			addPlayer(2);
			break;
		case 4:
			addPlayer(3);
			break;
		}
		setComponentZOrder(backgroundLabel, getComponentCount() - 1);
		repaint();
		((JFrame) getTopLevelAncestor()).repaint();
	}

	public void addPlayer(Player player) {
		players.add(player);
		refresh();
	}
}
