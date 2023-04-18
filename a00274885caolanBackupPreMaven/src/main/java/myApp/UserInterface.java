package myApp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;



enum DBIndex{
	ID,
	NAME,
	DEVELOPER,
	GENRE,
	YEAR
}

public class UserInterface implements ActionListener {

	// UI Containers
	JFrame frame;
	JPanel inputPanel;
	JPanel outputPanel;
	
	
	//UI Elements
	// Input Elements
	// GET ALL
	JButton getAllDBButton;
	// GET
	JLabel getLabel;
	JComboBox<DBIndex> getDBHeaders;
	JTextField getDBInput;
	JButton getDBButton;
	
	// DELETE Elements
	JLabel deleteLabel;
	JComboBox<DBIndex> deleteDBHeaders;
	JTextField deleteDBInput;
	JButton deleteDBButton;
	
	// PUT Elements
	JLabel putLabel;
	JTextField putDBIDInput;
	JComboBox<DBIndex> putDBHeaders;
	JTextField putDBInput;
	JButton putDBButton;
	
	// POST Elements
	JLabel postLabel;
	JTextField postNameInput;
	JTextField postDeveloperInput;
	JTextField postGenreInput;
	JTextField postYearInput;
	JButton postDBButton;
	
	//Output Elements
	JTable databaseViewer;
	JTextArea databaseOutputLog;
	
	UserInterface(){
		frame = new JFrame();
		DefaultFonts();
				
		InitInputPanel();
		InitOutputPanel();
		frame.setSize(1200,800);
		frame.setLocation(600, 300);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	private void DefaultFonts() {
		Font defaultFont = new Font("Dialog", Font.PLAIN, 20);
		UIManager.put("Button.font", defaultFont);
		UIManager.put("TextArea.font", defaultFont);
		UIManager.put("TextField.font", defaultFont);
		UIManager.put("Label.font", defaultFont);
		UIManager.put("ComboBox.font", defaultFont);
		UIManager.put("Table.font", defaultFont);
		UIManager.put("ScrollPane.font", defaultFont);
	}
	
	private void InitInputPanel() {
		inputPanel = new JPanel();
		
		inputPanel.setBounds(0,0,600,800);
		
		// GETALL Inputs
		JPanel getAllPanel = new JPanel();
		getAllDBButton = new JButton("GET ALL");
		getAllDBButton.addActionListener(this);
		getAllPanel.add(getAllDBButton);
		inputPanel.add(getAllPanel);
		
		// GET inputs
		JPanel getPanel = new JPanel();
		getLabel = new JLabel("GET game by: ");

		getPanel.add(getLabel);
		getDBHeaders = new JComboBox<DBIndex>();		
		getDBHeaders.addItem(DBIndex.ID);
		getDBHeaders.addItem(DBIndex.NAME);
		getDBHeaders.addItem(DBIndex.DEVELOPER);
		getDBHeaders.addItem(DBIndex.GENRE);
		getDBHeaders.addItem(DBIndex.YEAR);
		getPanel.add(getDBHeaders);
		getDBInput = new JTextField("Input");
		getDBInput.setPreferredSize(new Dimension(150,35));
		getPanel.add(getDBInput);
		getDBButton = new JButton("GET");
		getDBButton.addActionListener(this);
		getPanel.add(getDBButton);
		getPanel.setLayout(new BoxLayout(getPanel, BoxLayout.X_AXIS));

		inputPanel.add(getPanel);
		
		// DELETE inputs
		JPanel deletePanel = new JPanel();
		deleteLabel = new JLabel("DELETE game/s by: ");
		deletePanel.add(deleteLabel);
		deleteDBHeaders = new JComboBox<DBIndex>();		
		deleteDBHeaders.addItem(DBIndex.ID);
		deleteDBHeaders.addItem(DBIndex.NAME);
		deleteDBHeaders.addItem(DBIndex.DEVELOPER);
		deleteDBHeaders.addItem(DBIndex.GENRE);
		deleteDBHeaders.addItem(DBIndex.YEAR);
		deletePanel.add(deleteDBHeaders);
		deleteDBInput = new JTextField("Input");
		deleteDBInput.setPreferredSize(new Dimension(150,35));
		deletePanel.add(deleteDBInput);
		deleteDBButton = new JButton("DELETE");
		deletePanel.add(deleteDBButton);
		deletePanel.setLayout(new BoxLayout(deletePanel, BoxLayout.X_AXIS));

		inputPanel.add(deletePanel);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		
		// PUT inputs
		JPanel putPanel = new JPanel();
		putPanel.setLayout(new GridBagLayout());
		putLabel = new JLabel("UPDATE game by: ");
		c.gridx = 0;
		c.gridheight = 2;
		putPanel.add(putLabel, c);
		putDBIDInput = new JTextField("ID");
		c.gridx = 1;
		c.gridheight = 1;
		putPanel.add(putDBIDInput, c);
		putDBHeaders = new JComboBox<DBIndex>();		
		putDBHeaders.addItem(DBIndex.NAME);
		putDBHeaders.addItem(DBIndex.DEVELOPER);
		putDBHeaders.addItem(DBIndex.GENRE);
		putDBHeaders.addItem(DBIndex.YEAR);
		putPanel.add(putDBHeaders, c);
		putDBInput = new JTextField("Input");
		putDBInput.setPreferredSize(new Dimension(150,35));
		c.gridx = 2;
		c.gridheight = 2;
		putPanel.add(putDBInput, c);
		putDBButton = new JButton("PUT");
		c.gridx = 3;
		putPanel.add(putDBButton, c);		
		inputPanel.add(putPanel);
		
		// POST inputs
		JPanel postPanel = new JPanel();
		postPanel.setLayout(new GridBagLayout());
		postLabel = new JLabel("Create new game by: ");
		c.gridx = 0;
		c.gridheight = 4;
		postPanel.add(postLabel, c);
		c.gridx = 1;
		c.gridheight = 1;
		postNameInput = new JTextField("Name");
		postNameInput.setPreferredSize(new Dimension(150,35));
		postPanel.add(postNameInput, c);
		postDeveloperInput = new JTextField("Developer");
		postDeveloperInput.setPreferredSize(new Dimension(150,35));
		postPanel.add(postDeveloperInput, c);
		postGenreInput = new JTextField("Genre");
		postGenreInput.setPreferredSize(new Dimension(150,35));
		postPanel.add(postGenreInput, c);
		postYearInput = new JTextField("Year");
		postYearInput.setPreferredSize(new Dimension(150,35));
		postPanel.add(postYearInput, c);
		c.gridx = 2;
		c.gridheight = 4;
		postDBButton = new JButton("POST");
		postPanel.add(postDBButton, c);
		inputPanel.add(postPanel);
		
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100,30));
		
		frame.add(inputPanel);
	}
	
	private void InitOutputPanel() {
		outputPanel = new JPanel();
		outputPanel.setBounds(600,0,600,800);
		
		String data[][]= {{"","","","",""}};
		String column[]= {"ID", "NAME", "DEVELOPER", "GENRE", "YEAR"};
		databaseViewer = new JTable(data,column);
		databaseViewer.setBounds(600,0,600,800);
	
		JScrollPane sp = new JScrollPane(databaseViewer);
		outputPanel.add(sp);
		
		databaseOutputLog = new JTextArea();
		databaseOutputLog.setEditable(false);
		outputPanel.add(databaseOutputLog);
		
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		
		frame.add(outputPanel);
	}
	
	private void getAllDatabaseContent() {
		/*URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/a00274885caolan/rest/videogames/all").build();
		System.out.println(uri.toString());
				*/
	}
	
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getAllDBButton) {
			System.out.println("GET ALL button");
		} else if (e.getSource() == getDBButton) {
			System.out.println("GET button");
		}
	}
}
