package app.web.controller;

import app.model.odb.Credencial;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
//@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserService servicioDeUsuario;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public void crearUsuario(@RequestBody Credencial userAndPassword) throws Exception, IOException {
        servicioDeUsuario.crearNuevoUsuario(userAndPassword);
    }

//    @RequestMapping(value = "/ranking/{idlistaDePeliculas}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<Actor> rankingDeActores(@RequestHeader String token, @PathVariable String idlistaDePeliculas)
//            throws JSONException, IOException {
//        return servicioDeUsuario.rankingDeActoresPorMayorRepeticion(token, idlistaDePeliculas);
//    }
//
//    @RequestMapping(value = "/favoriteactor/", method = RequestMethod.PUT, produces = "application/json")
//    @ResponseBody
//    public RespuestaDto marcarActorFavorito(@RequestHeader String token, @RequestBody Actor actor)
//            throws Exception {
//        return servicioDeUsuario.marcarActorFavorito(token, actor);
//    }
//
//    @RequestMapping(value = "/favoriteactor/{id_actor}", method = RequestMethod.PUT, produces = "application/json")
//    @ResponseBody
//    public void desmarcarActorFavorito(@RequestHeader String token, @PathVariable String id_actor)
//            throws Exception {
//        servicioDeUsuario.desmarcarActorFavorito(token, id_actor);
//    }
//
//    @RequestMapping(value = "/favoriteactor/", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<Actor> verActoresFavoritos(@RequestHeader String token, Model model) throws IOException {
//        return servicioDeUsuario.verActoresFavoritos(token);
//    }
//
//    @RequestMapping(value = "/favoriteactor/ranking", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<Actor> verRankingActoresFavoritos(@RequestHeader String token, Model model) throws IOException {
//        return servicioDeUsuario.verRankingActoresFavoritos(token);
//    }
//
//    @RequestMapping(value = "/favoriteactor/movies", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<Movie> verPeliculasConActoresFavoritos(@RequestHeader String token, Model model) throws Exception {
//        return servicioDeUsuario.verPeliculasConMasDeUnActorFavorito(token);
//    }
//
//    @RequestMapping(value = "/movieLists", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<MovieList> verListas(@RequestHeader String token, Model model) throws Exception {
//        return servicioDeUsuario.verListas(token);
//    }

}
