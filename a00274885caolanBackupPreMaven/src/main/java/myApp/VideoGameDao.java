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

	

	public VideoGame getGameById(int id) {
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
		
		return game;
	}
	public VideoGame getGameByName(String name) {
		VideoGame game = null;
		
		Connection conn = startDBConnection();
		
		String query = "SELECT * FROM VIDEOGAMES WHERE NAME = '"+name+"';";
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
			 			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return game;
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
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql//localhost/oneDB;ifexists=true","SA","Passw0rd");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}




}
