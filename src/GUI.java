import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener{
	
	private JPanel masterPanel, rightPanel, leftPanel, clockPanel;
	
	private JLabel rightScoreJLabel, leftScoreJLabel, timeJLabel, leftCardsJLabel,
					rightCardsJLabel, clockJLabel;
	
	private JButton quitButton;
	
	private IOThread ioThread;
	
	private InputReader inputReader;
	private List queue;
	private HashMap<String, String> inputTranslator;
	
	private Score score;
	private Cards cards;
	private Clock clock;
	
	private Font scoreFont;
	private Dimension cardDimension;
	
	public GUI() {
		this.setLayout(new BorderLayout()); //sets layout type for swing GUI
		
		this.inputReader = new InputReader();
		this.queue = this.inputReader.list;
		this.inputTranslator = this.inputReader.inputTranslator;
		
		this.ioThread = new IOThread(this.queue);
		this.ioThread.start();
		
		this.clock = new Clock();
		
		this.setUpPanels(); //sets up GUI components
	}

	private void setUpPanels() {
		this.scoreFont = new Font("Verdana", Font.BOLD, 100);
		this.cardDimension = new Dimension(100, 200); //size of card box
		
		this.score = new Score();
		this.cards = new Cards();
		
		//Setting up right score
		this.rightScoreJLabel = new JLabel(Integer.toString(this.score.getRightScore()));
		this.rightScoreJLabel.setBackground(Color.BLACK);
		this.rightScoreJLabel.setOpaque(true);
		this.rightScoreJLabel.setFont(this.scoreFont);
		
		//Setting up right cards
		this.rightCardsJLabel = new JLabel();
		if(this.cards.getRightColor() != null)
			this.rightCardsJLabel.setBackground(this.cards.getRightColor()); //set card color
		else
			this.rightCardsJLabel.setBackground(Color.BLUE);
		this.rightCardsJLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE)); //set card border
		this.rightCardsJLabel.setOpaque(true);
		this.rightCardsJLabel.setPreferredSize(this.cardDimension);
		
		//adding score and cards to right fencer's panel
		this.rightPanel = new JPanel();
		this.rightPanel.setBackground(Color.BLACK);
		this.rightPanel.setOpaque(true);
		this.rightPanel.add(this.rightScoreJLabel);
		this.rightPanel.add(this.rightCardsJLabel);
		
		//setting up left score
		this.leftScoreJLabel = new JLabel(Integer.toString(this.score.getLeftScore()));
		this.leftScoreJLabel.setBackground(Color.BLACK);
		this.leftScoreJLabel.setOpaque(true);
		this.leftScoreJLabel.setFont(this.scoreFont);
		
		//setting up left cards
		this.leftCardsJLabel = new JLabel();
		if(this.cards.getLeftColor() != null) //if a fencer has a card then display that card
			this.leftCardsJLabel.setBackground(this.cards.getLeftColor());
		else
			this.leftCardsJLabel.setBackground(Color.BLUE);
		this.leftCardsJLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.leftCardsJLabel.setOpaque(true);
		this.leftCardsJLabel.setPreferredSize(this.cardDimension);
		
		//adding score and cards to left panel
		this.leftPanel = new JPanel();
		this.leftPanel.setBackground(Color.BLACK);
		this.leftPanel.setOpaque(true);
		this.leftPanel.add(this.leftCardsJLabel);
		this.leftPanel.add(this.leftScoreJLabel);
		
		//setting up clock panel
		this.clockJLabel = new JLabel(this.clock.getDisplayTime());
		this.clockJLabel.setBackground(Color.BLACK);
		this.clockJLabel.setOpaque(true);
		this.clockJLabel.setFont(this.scoreFont);
		
		//adding clock JLabel to panel
		this.clockPanel = new JPanel();
		this.clockPanel.setBackground(Color.BLACK);
		this.clockPanel.setOpaque(true);
		this.clockPanel.add(this.clockJLabel);
		
		
		//adding all panels to main panel
		this.add(this.rightPanel, BorderLayout.WEST);
		this.add(this.leftPanel, BorderLayout.EAST);
		this.add(this.clockPanel, BorderLayout.CENTER);
		
		//setting up master panel
		this.setTitle("Virtual Scoring Machine Display");
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
