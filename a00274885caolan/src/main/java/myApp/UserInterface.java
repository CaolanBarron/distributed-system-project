package myApp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;



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
	DefaultTableModel tableModel;
	JTable databaseViewer;
	JTextArea databaseOutputLog;
	
	//Menu Elements
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem resetDBMenuButton;
	
	UserInterface(){
		frame = new JFrame();
		DefaultFonts();
				
		InitInputPanel();
		InitOutputPanel();
		InitMenus();
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
		deleteDBButton.addActionListener(this);
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
		putDBButton.addActionListener(this);
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
		postDBButton.addActionListener(this);
		postPanel.add(postDBButton, c);
		inputPanel.add(postPanel);
		
		inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100,30));
		
		frame.add(inputPanel);
	}
	
	private void InitOutputPanel() {
		outputPanel = new JPanel();
		outputPanel.setBounds(600,0,600,800);
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("NAME");
		tableModel.addColumn("DEVELOPER");
		tableModel.addColumn("GENRE");		
		tableModel.addColumn("YEAR");
		databaseViewer = new JTable(tableModel);
		databaseViewer.setBounds(600,0,600,800);
	
		JScrollPane sp = new JScrollPane(databaseViewer);
		outputPanel.add(sp);
		
		databaseOutputLog = new JTextArea();
		databaseOutputLog.setEditable(false);
		outputPanel.add(databaseOutputLog);
		
		outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
		
		frame.add(outputPanel);
	}
	
	private void InitMenus() {
		menuBar = new JMenuBar();
		menu = new JMenu();
		resetDBMenuButton = new JMenuItem("RESET DATABASE");
		resetDBMenuButton.addActionListener(this);
		menuBar.add(resetDBMenuButton);
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}
	
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getAllDBButton) {
			getAllDatabaseContent();
		} else if (e.getSource() == getDBButton) {
			GetGamesByParam(getDBHeaders.getItemAt(getDBHeaders.getSelectedIndex()), getDBInput.getText());
		} else if (e.getSource() == deleteDBButton) {
			DeleteGamesByParam(deleteDBHeaders.getItemAt(deleteDBHeaders.getSelectedIndex()), deleteDBInput.getText());
		} else if (e.getSource() == putDBButton) {
			PutGameByParam(putDBHeaders.getItemAt(putDBHeaders.getSelectedIndex()), putDBIDInput.getText(), putDBInput.getText());
		} else if (e.getSource() == postDBButton) {
			PostGame(postNameInput.getText(), postDeveloperInput.getText(), postGenreInput.getText(), postYearInput.getText());
		} else if(e.getSource() == resetDBMenuButton) {
			ResetDatabase();
		}
		
		getAllDatabaseContent();
	}
	
	//
	// BUTTON INTERACTION METHODS
	//
	
	private void getAllDatabaseContent() {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/all").build();
			System.out.println(uri.toString());
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			String text;
			
			try {
				HttpEntity entity = response.getEntity();
				text = EntityUtils.toString(entity);
				System.out.println(text);
				
				tableModel.setRowCount(0);
				
				List<VideoGame> gameList = new ParseGames().doParseGames(text);
				System.out.println("-------DEBUG: GET ALL REQUEST----------");
				for (VideoGame game : gameList) {
					System.out.println("ID:" + game.getId());
					System.out.println("NAME:" + game.getName());
					System.out.println("DEVELOPER:" + game.getDeveloper());
					System.out.println("GENRE:" + game.getGenre());
					System.out.println("YEAR:" + game.getYear());
					System.out.println("-----------------------------------");
					Object[] row = {game.getId(), game.getName(), game.getDeveloper(), game.getGenre(), game.getYear()};
					tableModel.addRow(row);
				}
			} finally {
				response.close();
			}
			System.out.println("REPLY:" + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void GetGamesByParam(DBIndex index, String input) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		
		String indexString = index.toString().toLowerCase();
		System.out.println(indexString);
		System.out.println(input);
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/" + indexString + "/" + input)
					.build();
			System.out.println(uri.toString());
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			String text;
			
			try {
				HttpEntity entity = response.getEntity();
				text = EntityUtils.toString(entity);
				System.out.println(text);
				
				tableModel.setRowCount(0);
				
				List<VideoGame> gameList = new ParseGames().doParseGames(text);
				System.out.println("-------DEBUG: GET ALL REQUEST----------");
				for (VideoGame game : gameList) {
					System.out.println("ID:" + game.getId());
					System.out.println("NAME:" + game.getName());
					System.out.println("DEVELOPER:" + game.getDeveloper());
					System.out.println("GENRE:" + game.getGenre());
					System.out.println("YEAR:" + game.getYear());
					System.out.println("-----------------------------------");
					Object[] row = {game.getId(), game.getName(), game.getDeveloper(), game.getGenre(), game.getYear()};
					tableModel.addRow(row);
				}
			} finally {
				response.close();
			}
			System.out.println("REPLY:" + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DeleteGamesByParam(DBIndex index, String input) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		
		String indexString = index.toString().toLowerCase();
		System.out.println(indexString);
		System.out.println(input);
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/" + indexString + "/" + input)
					.build();
			System.out.println(uri.toString());
			HttpDelete httpDelete = new HttpDelete(uri);
			httpDelete.setHeader("Accept", "text/html");
			
			httpClient = HttpClients.createDefault();
			System.out.println("Sending DELETE request:");
			response = httpClient.execute(httpDelete);
			System.out.println("Respone: " + response.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void PutGameByParam(DBIndex index, String id, String input) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		
		String indexString = index.toString().toLowerCase();
		System.out.println(indexString);
		System.out.println(input);
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/" + indexString + "/")
					.build();
			System.out.println(uri.toString());
			
			HttpPut httpPut = new HttpPut(uri);
			httpPut.setHeader("Accept", "text/html");
			httpClient = HttpClients.createDefault();
			
			//PUT
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("gameId", id));
			nameValuePairs.add(new BasicNameValuePair("input", input));
			httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			System.out.println("Sending PUT request: ");
			response = httpClient.execute(httpPut);
			System.out.println("Respone: " + response.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void PostGame(String name, String developer, String genre, String year) {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/")
					.build();
			System.out.println(uri.toString());
			
			HttpPost httpPost = new HttpPost(uri);
			httpPost.setHeader("Accept", "text/html");
			httpClient = HttpClients.createDefault();
			
			//PUT
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("gameName", name));
			nameValuePairs.add(new BasicNameValuePair("gameDeveloper", developer));
			nameValuePairs.add(new BasicNameValuePair("gameGenre", genre));
			nameValuePairs.add(new BasicNameValuePair("gameYear", year));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			
			System.out.println("Sending POST request: ");
			response = httpClient.execute(httpPost);
			System.out.println("Respone: " + response.toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void ResetDatabase() {
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/a00274885caolan/rest/videogames/reset").build();
			System.out.println(uri.toString());
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			String text;
			
			try {
				HttpEntity entity = response.getEntity();
				text = EntityUtils.toString(entity);
				System.out.println(text);
				
			} finally {
				response.close();
			}
			System.out.println("REPLY:" + text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
