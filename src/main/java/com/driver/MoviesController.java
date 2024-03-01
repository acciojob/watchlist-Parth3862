package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.getMovieByName(name);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.getDirectorByName(name);
        if (director == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(director);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable String director){
        List<Movie> movies = movieService.getMoviesByDirectorName(director);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.ok("Movie added successfully");
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return ResponseEntity.ok("Director added successfully");
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName, @RequestParam String directorName){
        boolean success = movieService.addMovieDirectorPair(movieName, directorName);
        if (!success) {
            return ResponseEntity.badRequest().body("Movie or Director Not Found");
        }
        return ResponseEntity.ok("Movie Director Pair added Successfully");
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable String name){
        movieService.deleteDirectorByName(name);
        return ResponseEntity.ok("Director deleted successfully");
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return ResponseEntity.ok("All Directors deleted successfully");
    }
}
