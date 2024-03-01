package com.driver;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private Map<String, Movie> moviesMap = new HashMap<>();
    private Map<String, Director> directorsMap = new HashMap<>();

    public void addMovie(Movie movie){
        if (!moviesMap.containsKey(movie.getMovieName())) {
            moviesMap.put(movie.getMovieName(), movie);
        }
    }

    public void addDirector(Director director){
        if (!directorsMap.containsKey(director.getDirectorName())) {
            directorsMap.put(director.getDirectorName(), director);
        }
    }

    public void addMovieDirectorPair(Movie movie, Director director){
        movie.setDirector(director);
        director.addMovie(movie);
    }

    public Movie getMovieByName(String name){
        return moviesMap.get(name);
    }

    public Director getDirectorByName(String name){
        return directorsMap.get(name);
    }

    public List<Movie> getMoviesByDirector(Director director) {
        if (director == null) {
            return Collections.emptyList();
        }
        List<Movie> movieByDirector = new ArrayList<>();

        String directorName = director.getDirectorName();
        for(Movie movie:moviesMap.values()){
            if(movie.getDirector().getDirectorName().equals(directorName)){
                movieByDirector.add(movie);
            }
        }
        return movieByDirector;
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(moviesMap.values());
    }

    public void deleteDirectorByName(String name){
        directorsMap.remove(name);
    }

    public void deleteAllDirectors(){
        directorsMap.clear();
    }
}
