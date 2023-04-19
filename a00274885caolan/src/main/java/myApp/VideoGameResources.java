package myApp;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("videogames")
public class VideoGameResources {	
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/reset")
	public void resetDatabase() {
		VideoGameDao.instance.resetDatabase();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/all")
	public List<VideoGame> getVideoGames() {
		System.out.println("--------DEBUG OUTPUTS---------");
		System.out.println("--------GETTING ALL---------");
		System.out.println("--------GOT ALL------------");
		System.out.println("----------------------------");
		return VideoGameDao.instance.getAllGames();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/id/{gameId}")
	public List<VideoGame> getGameId(@PathParam("gameId") String id) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("GETTING A GAME");
		System.out.println("GETTING game by id: " + id);
		System.out.println("---------------------------");
		
		return VideoGameDao.instance.getGameById(Integer.parseInt(id));
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/name/{gameName}")
	public List<VideoGame> getGameName(@PathParam("gameName") String name) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("GETTING A GAME");
		System.out.println("GETTING game by name: " + name);
		System.out.println("---------------------------");
		
		return VideoGameDao.instance.getGameByName(name);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/developer/{gameDeveloper}")
	public List<VideoGame> getGameDeveloper(@PathParam("gameDeveloper") String developer) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("GETTING A GAME");
		System.out.println("GETTING game by developer: " + developer);
		System.out.println("---------------------------");
		
		return VideoGameDao.instance.getGamesByDeveloper(developer);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/genre/{gameGenre}")
	public List<VideoGame> getGameGenre(@PathParam("gameGenre") String genre) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("GETTING A GAME");
		System.out.println("GETTING game by genre: " + genre);
		System.out.println("---------------------------");
		
		return VideoGameDao.instance.getGamesByGenre(genre);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/year/{gameYear}")
	public List<VideoGame> getGameYear(@PathParam("gameYear") String year) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("GETTING A GAME");
		System.out.println("GETTING game by year: " + year);
		System.out.println("---------------------------");
		
		return VideoGameDao.instance.getGamesByYear(Integer.parseInt(year));
	}
	
	@DELETE
	@Path("/id/{gameId}")
	public void deleteGameId(@PathParam("gameId") String id) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("DELETING A GAME");
		System.out.println("DELETING game by id: " + id);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.deleteGameById(Integer.parseInt(id));
	}
	@DELETE
	@Path("/name/{gameName}")
	public void deleteGameName(@PathParam("gameName") String name) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("DELETING A GAME");
		System.out.println("DELETING game by name: " + name);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.deleteGameByName(name);
	}
	@DELETE
	@Path("/developer/{gameDeveloper}")
	public void deleteGameDeveloper(@PathParam("gameDeveloper") String developer) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("DELETING A GAME");
		System.out.println("DELETING game by developer: " + developer);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.deleteGamesByDeveloper(developer);
	}
	@DELETE
	@Path("/genre/{gameGenre}")
	public void deleteGameGenre(@PathParam("gameGenre") String genre) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("DELETING A GAME");
		System.out.println("DELETING game by genre: " + genre);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.deleteGamesByGenre(genre);
	}
	@DELETE
	@Path("/year/{gameYear}")
	public void deleteGameYear(@PathParam("gameYear") String year) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("DELETING A GAME");
		System.out.println("DELETING game by year: " + year);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.deleteGamesByYear(Integer.parseInt(year));
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/name/")
	public void updateGameName(@FormParam("gameId") String id, @FormParam("input") String name, @Context HttpServletResponse servletResponse) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("UPDATING A GAME");
		System.out.println("Updating game name: " + id + " with " + name);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.updateGameName(Integer.parseInt(id), name);
	}
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/developer/")
	public void updateGameDeveloper(@FormParam("gameId") String id, @FormParam("input") String developer) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("UPDATING A GAME");
		System.out.println("Updating game developer: " + id + " with " + developer);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.updateGameDeveloper(Integer.parseInt(id), developer);
	}
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/genre/")
	public void updateGameGenre(@FormParam("gameId") String id, @FormParam("input") String genre) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("UPDATING A GAME");
		System.out.println("Updating game genre: " + id + " with " + genre);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.updateGameGenre(Integer.parseInt(id), genre);
	}
	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/year/")
	public void updateGameYear(@FormParam("gameId") String id, @FormParam("input") String year) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("UPDATING A GAME");
		System.out.println("Updating game year: " + id + " with " + year);
		System.out.println("---------------------------");

		VideoGameDao.instance.updateGameYear(Integer.parseInt(id), Integer.parseInt(year));
	}
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createGame(@FormParam("gameName") String name, 
			@FormParam("gameDeveloper") String developer, 
			@FormParam("gameGenre") String genre, 
			@FormParam("gameYear") String year,
			@Context HttpServletResponse servletResponse) {
		System.out.println("------ DEBUG OUTPUTS ------");
		System.out.println("MAKING A GAME");
		System.out.println("NAME: " + name);
		System.out.println("DEVELOPER: " + developer);
		System.out.println("GENRE: " + genre);
		System.out.println("YEAR: " + year);
		System.out.println("---------------------------");
		
		VideoGameDao.instance.createNewGame(name, developer, genre, Integer.parseInt(year));
	}
}
