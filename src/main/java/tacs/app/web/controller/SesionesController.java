package tacs.app.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tacs.app.model.odb.Credencial;
import tacs.app.model.odb.Sesion;
import tacs.app.service.SesionesService;

import java.io.IOException;

@RestController
@CrossOrigin
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
