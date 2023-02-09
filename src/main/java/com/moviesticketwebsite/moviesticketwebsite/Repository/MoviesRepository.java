package com.moviesticketwebsite.moviesticketwebsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.moviesticketwebsite.moviesticketwebsite.model.Movies;

public interface MoviesRepository extends JpaRepository<Movies,Long> {
    
    @Query("FROM Movies Where release_date >= ADDDATE(CURDATE(),-30) AND release_date <= CURDATE() ORDER BY release_date DESC")
    public List<Movies> findAllOrderByDate();

    public Movies findMovieById(Long id);

    public List<Movies> findByGenreLike(String genre);
    
    public List<Movies> findByTitleLike(String genre); 

    @Query("FROM Movies where release_date > CURDATE() ORDER BY release_date")
    public List<Movies> findComingSoon();

    @Query("FROM Movies where release_date < ADDDATE(CURDATE(),-30) ORDER BY release_date DESC")
    public List<Movies> findAlreadyShown();

    public void deleteById(Long id); 
}
