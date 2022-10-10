package com.moviesticketwebsite.moviesticketwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesticketwebsite.moviesticketwebsite.model.Movies;
import com.moviesticketwebsite.moviesticketwebsite.service.MoviesService;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/movies")
public class MoviesController {
    
    @Autowired
    private MoviesService movieService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Movies>> getAll() {
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movies) {
        return new ResponseEntity<>(movieService.addMovie(movies),HttpStatus.OK);
    }

    @RequestMapping(value= {"update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movies> updateMovie(Long id, @RequestBody Movies movie) {
        return new ResponseEntity<>(movieService.updateMovie(movie, movie.getId()), HttpStatus.OK);
    }
    
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Movies> deleteMovie(@PathVariable("id") Long id){
        Movies movie = movieService.deleteMoviesById(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @RequestMapping(value = {"/find/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<Movies> getMoviesById (@PathVariable("id") Long id) {
        Movies movie = movieService.findMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK); 
    }

    @RequestMapping(value = {"/findGenre/{genre}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Movies>> getMoviesByGenre (@PathVariable("genre") String genre) {
        List<Movies> movie = movieService.findMovieByGenre(genre);
        return new ResponseEntity<>(movie, HttpStatus.OK); 
    }

    @RequestMapping(value = {"/findName/{name}"}, method = RequestMethod.GET)
    public ResponseEntity<List<Movies>> getMoviesByName (@PathVariable("name") String name) {
        List<Movies> movie = movieService.findMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK); 
    }

    @RequestMapping(value = {"/findComingSoon"},method=RequestMethod.GET)
    public ResponseEntity<List<Movies>> getComingSoon() {
        return new ResponseEntity<>(movieService.findComingSoon(),HttpStatus.OK);
    }

    @RequestMapping(value = {"/findAlreadyShown"},method=RequestMethod.GET)
    public ResponseEntity<List<Movies>> getAlreadyShown() {
        return new ResponseEntity<>(movieService.findAlreadyShown(),HttpStatus.OK);
    }

}
