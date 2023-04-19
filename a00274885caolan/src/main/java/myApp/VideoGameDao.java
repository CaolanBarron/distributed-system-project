package myApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public enum VideoGameDao {
	instance;

	public List<VideoGame> getAllGames() {
		List<VideoGame> games = new ArrayList<VideoGame>();
		
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES;";
		try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 VideoGame game = null;
			 while(rs.next()) {
				 game = new VideoGame();
				 game.setId(rs.getInt("ID"));
				 game.setName(rs.getString("NAME"));
				 game.setDeveloper(rs.getString("DEVELOPER"));
				 game.setGenre(rs.getString("GENRE"));
				 game.setYear(rs.getInt("YEAR"));
				 
				 games.add(game);
			 }
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return games;
	}

	public List<VideoGame> getGameById(int id) {
		List<VideoGame> games = new ArrayList<VideoGame>();
		VideoGame game =  null;
		Connection conn = startDBConnection();
		String query = "SELECT * FROM VIDEOGAMES WHERE ID = "+ id + ";";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(rs.next()) {
				game = new VideoGame();
				game.setId(rs.getInt(1));
				game.setName(rs.getString(2));
				game.setDeveloper(rs.getString(3));
				game.setGenre(rs.getString(4));
				game.setYear(rs.getInt(5));
			} else {
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		games.add(game);
		return games;
	}
	public List<VideoGame> getGameByName(String name) {
		List<VideoGame> games = new ArrayList<VideoGame>();
		VideoGame game = null;
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES WHERE NAME = '"+name+"';";
		System.out.println("LOOKING FOR A GAME: " + name);
		try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 if(rs.next()) {
				 System.out.println("FOUND A GAME");
				 game = new VideoGame();
				 game.setId(rs.getInt(1));
				 game.setName(rs.getString(2));
				 game.setDeveloper(rs.getString(3));
				 game.setGenre(rs.getString(4));
				 game.setYear(rs.getInt(5));
			 } else {
				 return null;
			 }
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(game.getName());
		games.add(game);
		return games;
	}
	public List<VideoGame> getGamesByDeveloper(String developer) {
		List<VideoGame> games = new ArrayList<VideoGame>();
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES WHERE DEVELOPER = '"+developer+"';";
		try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 VideoGame game = null;
			 while(rs.next()) {
				 game = new VideoGame();
				 game.setId(rs.getInt(1));
				 game.setName(rs.getString(2));
				 game.setDeveloper(rs.getString(3));
				 game.setGenre(rs.getString(4));
				 game.setYear(rs.getInt(5));
				 
				 games.add(game);
			 }
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return games;	
	}
	
	public List<VideoGame> getGamesByGenre(String genre) {
		List<VideoGame> games = new ArrayList<VideoGame>();
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES WHERE GENRE = '"+genre+"';";
		try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 VideoGame game = null;
			 while(rs.next()) {
				 game = new VideoGame();
				 game.setId(rs.getInt(1));
				 game.setName(rs.getString(2));
				 game.setDeveloper(rs.getString(3));
				 game.setGenre(rs.getString(4));
				 game.setYear(rs.getInt(5));
				 
				 games.add(game);
			 }
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return games;		
	}
	
	public List<VideoGame> getGamesByYear(int year) {
		List<VideoGame> games = new ArrayList<VideoGame>();
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES WHERE YEAR = '"+year+"';";
		try {
			 Statement statement = conn.createStatement();
			 ResultSet rs = statement.executeQuery(query);
			 VideoGame game = null;
			 while(rs.next()) {
				 game = new VideoGame();
				 game.setId(rs.getInt(1));
				 game.setName(rs.getString(2));
				 game.setDeveloper(rs.getString(3));
				 game.setGenre(rs.getString(4));
				 game.setYear(rs.getInt(5));
				 
				 games.add(game);
			 }
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return games;		
	}
	
	boolean deleteGameById(int id) {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES WHERE ID = '"+id+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean deleteGameByName(String name) {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES WHERE NAME = '"+name+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	}
	
	boolean deleteGamesByDeveloper(String developer) {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES WHERE DEVELOPER = '"+developer+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean deleteGamesByGenre(String genre) {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES WHERE GENRE = '"+genre+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean deleteGamesByYear(int year) {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES WHERE YEAR = '"+year+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;	
		}
	
	boolean updateGameName(int id, String name) {
		Connection conn = startDBConnection();
		
		String query =  "UPDATE VIDEOGAMES SET NAME = '"+name+"' WHERE ID = '"+id+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean updateGameDeveloper(int id, String developer) {
		Connection conn = startDBConnection();
		
		String query =  "UPDATE VIDEOGAMES SET NAME = '"+developer+"' WHERE ID = '"+id+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean updateGameGenre(int id, String genre) {
		Connection conn = startDBConnection();
		
		String query =  "UPDATE VIDEOGAMES SET NAME = '"+genre+"' WHERE ID = '"+id+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean updateGameYear(int id, int year) {
		Connection conn = startDBConnection();
		
		String query =  "UPDATE VIDEOGAMES SET NAME = '"+year+"' WHERE ID = '"+id+"';";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	boolean createNewGame(String name, String developer, String genre, int year) {
		Connection conn = startDBConnection();
		
		String query =  "INSERT INTO VIDEOGAMES(NAME, DEVELOPER, GENRE, YEAR) VALUES ('"+name+"','"+developer+"','"+genre+"','"+year+"');";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	Connection startDBConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/oneDB;",
					"SA",
					"Passw0rd");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void resetDatabase() {
		Connection conn = startDBConnection();
		
		String query =  "DELETE FROM VIDEOGAMES; "
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "(\"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Persona 5', 'Atlus', 'RPG', 2016);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "(\"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Skyrim', 'Bethesda', 'RPG', 2011);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "(\"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Titanfall 2', 'Respawn Entertainment', 'FPS', 2016);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "(\"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Apex Legends', 'Respawn Entertainment', 'FPS', 2019);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "(\"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Minecraft', 'Mojang', 'Survival', 2011);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('The Witcher 3:Wild Hunt', 'CD Projekt Red', 'RPG', 2015);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Tetris', 'Alexey Pajitnov', 'Puzzle', 1985);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Mass Effect 2', 'Electronic Arts', 'Action', 2010);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Super Mario Odyssey', 'Nintendo', 'Adventure', 2017);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Overwatch', 'Blizzard', 'FPS', 2016);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('World Of Warcraft', 'Blizzard', 'MMO', 2004);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Dark Souls', 'From Software', 'RPG', 2011);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Animal Crossing: New Horizons', 'Nintendo', 'Adventure', 2020);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Zelda: Majoras Mask', 'Nintendo', 'Adventure', 2000);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Zelda: Breath of the wild', 'Nintendo', 'RPG', 2017);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Shadows of the Colossus', 'Team Ico', 'Action', 2005);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Undertale', 'Toby Fox', 'Adventure', 2015);\n"
				+ "\n"
				+ "INSERT INTO \"PUBLIC\".\"VIDEOGAMES\"\n"
				+ "( \"NAME\", \"DEVELOPER\", \"GENRE\", \"YEAR\" )\n"
				+ "VALUES ('Bloodborne', 'From Software', 'RPG', 2015);";
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch( SQLException e) {
				e.printStackTrace();
			}
		}
	}



}
