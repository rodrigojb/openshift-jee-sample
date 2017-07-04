package tacs.app.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacs.app.model.odb.Actor;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/person")
public class ActorController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
    Actor busquedaPeliculaJson(@RequestHeader String Token, @PathVariable String id)
			throws Exception {
		return new Actor(id);
	}
}
