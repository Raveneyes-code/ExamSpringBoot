package com.howtodoinjava.example.movie.controller;

import com.howtodoinjava.example.movie.beans.Acteur;
import com.howtodoinjava.example.movie.beans.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api(value = "Swagger2_movie_actor", description = "REST Apis related to Acteurs and Films Entities!!!!")
@RestController
public class FilmServiceController {

    private static final Map<String, Acteur> ActeurData = new HashMap<String, Acteur>() {
        {
            put("Aiman",new Acteur("Aiman","Benomar",new Date(1997, 1, 5),null));
            put("Anass",new Acteur("Anass","Benomar",new Date(2001, 3, 16),null));
            put("Yhaya",new Acteur("Yhaya","Benomar",new Date(2005, 4, 14),null));
        }
    };
    private static final Map<String, Film> FilmData = new HashMap<String, Film>() {
        {
            put("Hobbit",new Film("Hobbit","realisateur1",new Date(2033, 1, 16),ActeurData.get("Aiman")));
            put("Avatar",new Film("Avatar","realisateur2",new Date(2023, 5, 12),ActeurData.get("Aiman")));
            put("Harry Potter",new Film("Harry Potter","realisateur3",new Date(2018, 2, 4),ActeurData.get("Aiman")));
        }
    };

    @ApiOperation(value = "Get Acteur by his name ", response = Acteur.class, tags = "findActeurDetails")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/findActeurDetails/{ActeurNom}", method = RequestMethod.GET)
    public Acteur getActeurDetails(@PathVariable String ActeurNom){
        Acteur acteur= ActeurData.get(ActeurNom);
        if (acteur == null) {
            acteur = new Acteur("N/A","N/A",new Date(0, 0, 0),"N/A");
        }
        return acteur;
    }

    @ApiOperation(value = "Get all Acteurs", response = Iterable.class, tags = "findAllActeur")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/findAllActeur", method = RequestMethod.GET)
    public Map<String, Acteur> getAllActeurs(){
        return ActeurData;
    }

//    @RequestMapping(value = "/findActeurByFilm/{filmTitle}", method = RequestMethod.GET)
//    public Acteur getActeurByFilm(@PathVariable String filmTitle){
//        Acteur acteur=null;
//        for (Map.Entry<String, Acteur> entry : ActeurData.entrySet()) {
//            if (entry.getValue().getFilmographie().contains(filmTitle)) {
//                acteur= entry.getValue();
//            }
//        }
//        if (acteur == null) {
//            acteur = new Acteur("N/A","N/A",new Date(0, 0, 0),"N/A");
//        }
//        return acteur;
//    }

    @ApiOperation(value = "Get all Acteurs", response = Iterable.class, tags = "findAllFilms")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/findAllFilms", method = RequestMethod.GET)
    public Map<String, Film> getAllFilms(){
        return FilmData;
    }

    @ApiOperation(value = "Get all Acteurs", response = Film.class, tags = "findFilmDetails")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Suceess|OK"), @ApiResponse(code = 401, message = "not authorized!"), @ApiResponse(code = 403, message = "forbidden!!!"), @ApiResponse(code = 404, message = "not found!!!") })
    @RequestMapping(value = "/findFilmDetails/{FilmNom}", method = RequestMethod.GET)
    public Film getFilmDetails(@PathVariable String FilmNom){
        Film film= FilmData.get(FilmNom);
        if (film == null) {
            film = new Film("N/A","N/A",new Date(0, 0, 0),null);
        }
        return film;
    }

}
