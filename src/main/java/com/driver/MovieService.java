package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<String> addMovie(Movie movie) {
        if (movieRepository.getMovieByName(movie.getMovieName()) != null) {
            return ResponseEntity.badRequest().body("Movie with the same name already exists");
        }

        movieRepository.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    public ResponseEntity<String> addDirector(Director director) {
        if (movieRepository.getDirectorByName(director.getDirectorName()) != null) {
            return ResponseEntity.badRequest().body("Director with the same name already exists");
        }
        movieRepository.addDirector(director);
        return ResponseEntity.ok("Director added successfully");
    }


    public boolean addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movieRepository.getMovieByName(movieName);
        Director director = movieRepository.getDirectorByName(directorName);

        if(movie == null || director == null) {
            return false;
        }

        movieRepository.addMovieDirectorPair(movie, director);
        return true;
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        Director director = movieRepository.getDirectorByName(directorName);
        return movieRepository.getMoviesByDirector(director);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }
}
