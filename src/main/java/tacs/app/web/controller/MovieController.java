package tacs.app.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tacs.app.model.odb.Movie;

@Controller
@CrossOrigin
@RequestMapping(value = "/api/movie")
public class MovieController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody
    Movie busquedaPeliculaJson(@RequestHeader String Token, @PathVariable String id)
			throws Exception {
		return new Movie(id);
	}

}
