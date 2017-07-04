package tacs.app.service;

import org.springframework.stereotype.Service;

//import app.repositories.RepositorioDeListas;
//import app.repositories.RepositorioDeUsuarios;

@Service
public class AdministrativoService {

//    @Autowired
//    RepositorioDeUsuarios repositorioDeUsuarios;
//
//    @Autowired
//    RepositorioDeListas repositorioDeListas;

//    public User obtenerUsuario(String id) {
//        User user = repositorioDeUsuarios.findOne(id);
//        user.setLists(user.getLists().stream().map(movieList -> repositorioDeListas.findOne(movieList.getId())).collect(Collectors.toList()));
//        if(user == null){
//            throw new RuntimeException("No existe el usuario con id " + id.toString());
//        }
//        return user;
//    }
//
//    public List<User> obtenerUsuarios() {
//        return repositorioDeUsuarios.findAll();
//    }
//
//
//    public AdministrativoService validarAdmin(String token) {
//        if (token.substring(0,1) == "f"){
//            throw new RuntimeException("Esta funcionalidad solo es para admins");
//        }
//        return this;
//    }
//
//
//    public List<Movie> obtenerInterseccionListas(String id1, String id2) {
//        MovieList lista1 = repositorioDeListas.findOne(id1);
//        MovieList lista2 = repositorioDeListas.findOne(id2);
//        List<Movie> interseccion = lista1.intersectionWith(lista2);
//        return interseccion;
//    }

}
