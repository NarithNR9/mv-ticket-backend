package com.moviesticketwebsite.moviesticketwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviesticketwebsite.moviesticketwebsite.Repository.MoviesRepository;
import com.moviesticketwebsite.moviesticketwebsite.model.Movies;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepo;
    
    public List<Movies> findAllMovies() {
        return moviesRepo.findAllOrderByDate();
    }

    public Movies addMovie(Movies movies) {
        return moviesRepo.save(movies);
    }

    public Movies updateMovie(Movies movie, Long id) {
        Optional<Movies> optionalMovies = moviesRepo.findById(id);
        Movies movieFromRepo = optionalMovies.get();
        movieFromRepo.setTitle(movie.getTitle());
        movieFromRepo.setGenre(movie.getGenre());
        movieFromRepo.setReleaseDate(movie.getReleaseDate());
        movieFromRepo.setDuration(movie.getDuration());
        movieFromRepo.setRate(movie.getRate());
        movieFromRepo.setTrailer(movie.getTrailer());
        movieFromRepo.setImageUrl(movie.getImageUrl());
        movieFromRepo.setShortDescription(movie.getShortDescription());
        return moviesRepo.save(movieFromRepo);
    }

    public Movies findMovieById(Long id) {
        return moviesRepo.findMovieById(id);
    }

    public List<Movies> findMovieByGenre(String genre) {
        return moviesRepo.findByGenreLike(genre);
    }

    public List<Movies> findMovieByName(String genre) {
        return moviesRepo.findByTitleLike(genre);
    }

    public Movies deleteMoviesById(Long id) {
        Movies movie = moviesRepo.findMovieById(id);
        moviesRepo.deleteById(id);
        return movie;
    }

    public List<Movies> findComingSoon() {
        return moviesRepo.findComingSoon();
    }

    public List<Movies> findAlreadyShown() {
        return moviesRepo.findAlreadyShown();
    }

    
}
