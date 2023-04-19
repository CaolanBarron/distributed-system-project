package myApp;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("videogames")
public class VideoGameResources {	
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/all")
	public List<VideoGame> getVideoGames() {
		return VideoGameDao.instance.getAllGames();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/id/{gameId}")
	public VideoGame getGameId(@PathParam("gameId") String id) {
		return VideoGameDao.instance.getGameById(Integer.parseInt(id));
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/name/{gameName}")
	public VideoGame getGameName(@PathParam("gameName") String name) {
		return VideoGameDao.instance.getGameByName(name);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/developer/{gameDeveloper}")
	public List<VideoGame> getGameDeveloper(@PathParam("gameDeveloper") String developer) {
		return VideoGameDao.instance.getGamesByDeveloper(developer);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/genre/{gameGenre}")
	public List<VideoGame> getGameGenre(@PathParam("gameGenre") String genre) {
		return VideoGameDao.instance.getGamesByGenre(genre);
	}
	@GET
	@Produces({ MediaType.APPLICATION_XML})
	@Path("/year/{gameYear}")
	public List<VideoGame> getGameYear(@PathParam("gameYear") String year) {
		return VideoGameDao.instance.getGamesByYear(Integer.parseInt(year));
	}
	
	@DELETE
	@Path("/id/{gameId}")
	public boolean deleteGameId(@PathParam("gameId") String id) {
		return VideoGameDao.instance.deleteGameById(Integer.parseInt(id));
	}
	@DELETE
	@Path("/name/{gameName}")
	public boolean deleteGameName(@PathParam("gameName") String name) {
		return VideoGameDao.instance.deleteGameByName(name);
	}
	@DELETE
	@Path("/developer/{gameDeveloper}")
	public boolean deleteGameDeveloper(@PathParam("gameDeveloper") String developer) {
		return VideoGameDao.instance.deleteGamesByDeveloper(developer);
	}
	@DELETE
	@Path("/genre/{gameGenre}")
	public boolean deleteGameGenre(@PathParam("gameGenre") String genre) {
		return VideoGameDao.instance.deleteGamesByGenre(genre);
	}
	@DELETE
	@Path("/year/{gameYear}")
	public boolean deleteGameYear(@PathParam("gameYear") String year) {
		return VideoGameDao.instance.deleteGamesByYear(Integer.parseInt(year));
	}
	
	@PUT
	@Path("/name/{gameId}/{gameName}")
	public boolean updateGameName(@PathParam("gameId") String id, @PathParam("gameName") String name) {
		return VideoGameDao.instance.updateGameName(Integer.parseInt(id), name);
	}
	@PUT
	@Path("/developer/{gameId}/{gameDeveloper}")
	public boolean updateGameDeveloper(@PathParam("gameId") String id, @PathParam("gameDeveloper") String developer) {
		return VideoGameDao.instance.updateGameDeveloper(Integer.parseInt(id), developer);
	}
	@PUT
	@Path("/genre/{gameId}/{gameGenre}")
	public boolean updateGameGenre(@PathParam("gameId") String id, @PathParam("gameGenre") String genre) {
		return VideoGameDao.instance.updateGameGenre(Integer.parseInt(id), genre);
	}
	@PUT
	@Path("/year/{gameId}/{gameYear}")
	public boolean updateGameYear(@PathParam("gameId") String id, @PathParam("gameYear") String year) {
		return VideoGameDao.instance.updateGameYear(Integer.parseInt(id), Integer.parseInt(year));
	}
	@POST
	@Path("/create")
	public boolean createGame(@FormParam("gameName") String name, @FormParam("gameDeveloper") String developer, @FormParam("gameGenre") String genre, @FormParam("gameYear") String year) {
		return VideoGameDao.instance.createNewGame(name, developer, genre, Integer.parseInt(year));
	}
}
