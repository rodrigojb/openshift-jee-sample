package tacs.app.web.controller;


import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tacs.app.model.dto.RespuestaDto;
import tacs.app.model.odb.Actor;
import tacs.app.model.odb.Credencial;
import tacs.app.model.odb.Movie;
import tacs.app.model.odb.MovieList;
import tacs.app.service.UserService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService servicioDeUsuario;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public void crearUsuario(@RequestBody Credencial userAndPassword) throws Exception, IOException {
        servicioDeUsuario.crearNuevoUsuario(userAndPassword);
    }

    @RequestMapping(value = "/ranking/{idlistaDePeliculas}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Actor> rankingDeActores(@RequestHeader String token, @PathVariable String idlistaDePeliculas)
            throws JSONException, IOException {
        return servicioDeUsuario.rankingDeActoresPorMayorRepeticion(token, idlistaDePeliculas);
    }

    @RequestMapping(value = "/favoriteactor/", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public RespuestaDto marcarActorFavorito(@RequestHeader String token, @RequestBody Actor actor)
            throws Exception {
        return servicioDeUsuario.marcarActorFavorito(token, actor);
    }

    @RequestMapping(value = "/favoriteactor/{id_actor}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public void desmarcarActorFavorito(@RequestHeader String token, @PathVariable String id_actor)
            throws Exception {
        servicioDeUsuario.desmarcarActorFavorito(token, id_actor);
    }

    @RequestMapping(value = "/favoriteactor/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Actor> verActoresFavoritos(@RequestHeader String token) throws IOException {
        return servicioDeUsuario.verActoresFavoritos(token);
    }

    @RequestMapping(value = "/favoriteactor/ranking", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Actor> verRankingActoresFavoritos(@RequestHeader String token) throws IOException {
        return servicioDeUsuario.verRankingActoresFavoritos(token);
    }

    @RequestMapping(value = "/favoriteactor/movies", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Movie> verPeliculasConActoresFavoritos(@RequestHeader String token) throws Exception {
        return servicioDeUsuario.verPeliculasConMasDeUnActorFavorito(token);
    }

    @RequestMapping(value = "/movieLists", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MovieList> verListas(@RequestHeader String token) throws Exception {
        return servicioDeUsuario.verListas(token);
    }

}
