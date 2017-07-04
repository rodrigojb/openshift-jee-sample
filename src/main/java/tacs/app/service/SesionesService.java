package tacs.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacs.app.model.odb.Credencial;
import tacs.app.model.odb.Sesion;
import tacs.app.model.odb.TokenGenerator;
import tacs.app.model.odb.User;
import tacs.app.repositories.RepositorioDeSesiones;
import tacs.app.repositories.RepositorioDeUsuarios;

import java.util.Calendar;

@Service
public class SesionesService {

    @Autowired
    RepositorioDeUsuarios repositorioDeUsuarios;
	public static final String SALT = "TMDB-G1";


    public Sesion loguearUsuario(Credencial credencial) {
        this.crearAdminSiNoExiste();
        User user = repositorioDeUsuarios.findByUsername(credencial.getUsername());
        String saltedPassword = SALT + credencial.getPassword();
		String hashedPassword = TokenGenerator.generarHash(saltedPassword);
        if(user == null || !user.getPassword().equals(hashedPassword)){
            throw new RuntimeException("Usuario y/o contraseña inválida");
        }
        Sesion nuevaSesion = Sesion.create(user.getUsername(), user.getAdmin());
        RepositorioDeSesiones.getInstance().insert(nuevaSesion);
        user.setLastAccess(Calendar.getInstance().getTime());
        repositorioDeUsuarios.save(user);
        return nuevaSesion;
    }

    private void crearAdminSiNoExiste() {
        User userAdmin = User.create(Credencial.create("admin", "admin"),true);
        if(repositorioDeUsuarios.findByUsername("admin") == null){
            repositorioDeUsuarios.insert(userAdmin);
        }
    }

    public void desloguearUsuario(String token) {
        Sesion sesionADesactivar = RepositorioDeSesiones.getInstance().searchById(token);
        sesionADesactivar.desactivarSesion();
        RepositorioDeSesiones.getInstance().update(sesionADesactivar);
    }

    public void actualizarPass(User user){
        user.setPassword(TokenGenerator.generarHash(SALT+user.getPassword()));
        repositorioDeUsuarios.save(user);
    }
    
    public User obtenerUsuarioPorToken(String token ) {
        if (token == null)
            throw new RuntimeException("Token nulo, no se puede realizar la operación.");
        Sesion sesion = RepositorioDeSesiones.getInstance().searchById(token);
        validarSesionActiva(sesion);
        return repositorioDeUsuarios.findByUsername(sesion.getUsername());
//        return User.create(Credencial.create("admin","admin"),true);
    }



    public void validarSesionActiva(Sesion sesion) {
        if (!sesion.getEstaActiva()) {
            throw new RuntimeException("La sesión ya expiró, vuelva a loguearse por favor");
        }
    }

}
