package tacs.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tacs.app.model.odb.Actor;

/**
 * Created by aye on 27/05/17.
 */
public interface RepositorioDeActores extends MongoRepository<Actor,String> {
}
