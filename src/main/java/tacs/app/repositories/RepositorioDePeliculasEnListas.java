package tacs.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tacs.app.model.odb.Movie;

/**
 * Created by aye on 27/05/17.
 */
public interface RepositorioDePeliculasEnListas extends MongoRepository<Movie, String> {
}
