package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private String directorName;
    private int birthYear;
    private String nationality;

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getBirthYear() {
        return birthYear;
    }
    private List<Movie> movies = new ArrayList<>();
    public void addMovie(Movie movie){
        movies.add(movie);
    }
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
