package app.web.controller;

import app.model.odb.Credencial;
import app.model.odb.Sesion;
import app.service.SesionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "tacs-tmdb-tmdb-grupo1.7e14.starter-us-west-2.openshiftapps.com")
@RequestMapping("/api/authentication")
public class SesionesController {

    @Autowired
    SesionesService servicioDeSesiones;

    @RequestMapping(value="/login", method= RequestMethod.POST)
    @ResponseBody
    public Sesion loguearUsuario(@RequestBody Credencial userAndPassword) throws IOException{
        return servicioDeSesiones.loguearUsuario(userAndPassword);
    }

    @RequestMapping(value="/logout", method= RequestMethod.PUT)
    @ResponseBody
    public void desloguearUsuario(@RequestHeader String token) throws IOException{
       /*acá debo desloguear al usuario va a devolver void pero en forma de prueba*/
        servicioDeSesiones.desloguearUsuario(token);
    }
}
