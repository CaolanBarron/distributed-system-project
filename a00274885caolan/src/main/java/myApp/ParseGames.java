package myApp;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class ParseGames {
	boolean inGames = false;
	boolean inGame = false;
	boolean inId = false;
	boolean inName = false;
	boolean inDeveloper = false;
	boolean inGenre = false;
	boolean inYear = false;
	
	VideoGame currentGame;
	List<VideoGame> currentGameList;
	
	public List<VideoGame> doParseGames(String s) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return currentGameList;
	}
	
	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End document");
			} else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}

	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("videoGames")) {
			inGames = true;
			currentGameList = new ArrayList<VideoGame>();
		} else if (name.equals("videogame")) {
			inGame = true;
			currentGame = new VideoGame();
		} else if(name.equals("id")) {
			inId = true;
		} else if (name.equals("name")) {
			inName = true;
		} else if (name.equals("developer")) {
			inDeveloper = true;
		} else if(name.equals("genre")) {
			inGenre = true;
		} else if (name.equals("year")) {
			inYear = true;
		}
	}
	
	public void processText(XmlPullParser event) throws
	XmlPullParserException {
		String s = event.getText();
		if (inId) {
			currentGame.setId(Integer.parseInt(s));
		}
		if (inName) {
			currentGame.setName(s);
		}
		if (inDeveloper) {
			currentGame.setDeveloper(s);
		}
		if (inGenre) {
			currentGame.setGenre(s);
		}
		if (inYear) {
			currentGame.setYear(Integer.parseInt(s));
		}
	}
	
	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		
		if (name.equals("videoGames")) {
			inGames = false;
		} else if (name.equals("videogame")) {
			inGame = false;
			currentGameList.add(currentGame);
		} else if (name.equals("id")) {
			inId = false;
		} else if (name.equals("name")) {
			inName = false;
		} else if (name.equals("developer")) {
			inDeveloper = false;
		} else if (name.equals("genre")) {
			inGenre = false;
		} else if (name.equals("year")) {
			inYear = false;
		}
	}
}
