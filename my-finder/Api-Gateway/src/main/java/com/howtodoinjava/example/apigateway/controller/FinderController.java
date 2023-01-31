package com.howtodoinjava.example.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FinderController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/findActeurDetails/{ActeurNom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getActeurDetails(@PathVariable String ActeurNom)
    {
        System.out.println("Getting "+ ActeurNom +"'s details");
 
        String response = restTemplate.exchange("http://my-movie/findActeurDetails/{ActeurNom}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, ActeurNom).getBody();
 
        System.out.println("Response Body " + response);
 
        return ActeurNom + ": [ Acteur Details " + response+" ]";
    }

    @RequestMapping(value = "/findAllActeur", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getAllActeurs()
    {
        System.out.println("Getting all actors details");

        String response = restTemplate.exchange("http://my-movie/findAllActeur",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return  "Here is the full list of actors: "+ response;
    }

    @RequestMapping(value = "/findAllFilms", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getAllFilms()
    {
        System.out.println("Getting all actors details");

        String response = restTemplate.exchange("http://my-movie/findAllFilms",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

        System.out.println("Response Body " + response);

        return  "Here is the full list of movies: "+ response;
    }

    @RequestMapping(value = "/findFilmDetails/{FilmNom}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethodFilm")
    public String getFilmDetails(@PathVariable String FilmNom)
    {
        System.out.println("Getting "+ FilmNom +"'s details");

        String response = restTemplate.exchange("http://my-movie/findFilmDetails/{FilmNom}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, FilmNom).getBody();

        System.out.println("Response Body " + response);

        return FilmNom + ": [ Film Details " + response+" ]";
    }
    public String  fallbackMethod(String ActeurNom){
    	
    	return "The list is empty or there is no actor of this name";
    }
    public String  fallbackMethodFilm(String FilmName){

        return "The list is empty or there is no movie with this title";
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
