package tacs.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tacs.app.model.odb.MovieList;

@Repository
public interface RepositorioDeListas extends MongoRepository<MovieList, String> {

}
