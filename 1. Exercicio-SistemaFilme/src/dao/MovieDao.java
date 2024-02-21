package dao;

import model.Movie;
import java.util.List;

public interface MovieDao {
    public List<Movie> getAllMovies();
    public Movie getMovieByName(String name);

    public List<Movie> getMoviesByDirector(String directorName);
    public List<Movie> getMoviesByActor(String actorName);
    public List<Movie> getMoviesByMark(int mark);

    void insertMovie(Movie movie);
    void updateMovie(Movie old, Movie newMovie);

    void deleteMovie(Movie movie);
}