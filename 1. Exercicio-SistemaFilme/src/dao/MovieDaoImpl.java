package dao;

import java.util.ArrayList;
import java.util.List;
import model.Movie;
import model.Actor;
public class MovieDaoImpl {
    private static MovieDaoImpl instance;
    private final List<Movie> dataset;

    private MovieDaoImpl(){
        dataset = new ArrayList<>();
    }

    public static MovieDaoImpl getInstance(){
        if(instance == null){
            instance = new MovieDaoImpl();
        }
        return instance;
    }

    public List<Movie> getAllMovies(){
        return dataset;
    }

    public Movie getMovieByName(String name){
        Movie movie = null;
        if (!dataset.isEmpty()) {
            for (int i = 0; i < dataset.size() && movie == null; i++) {
                if (dataset.get(i).getTitle().equals(name)) {
                    movie = dataset.get(i);
                }
            }
        }
        return movie;
    }

    public List<Movie> getMoviesByDirector(String directorName){
        List<Movie> movies = new ArrayList<>(0);
        for(Movie movie : dataset){
            if (movie.getDirector().getName().equals(directorName)){
                movies.add(movie);
            }
        }
        return movies;
    }
    public List<Movie> getMoviesByActor(String actorName){
        List<Movie> movies = new ArrayList<>(0);
        ActorDao actorInstance = ActorDaoImpl.getInstance();
        Actor actor = actorInstance.getActorByName(actorName);
        for(Movie movie : dataset){
            if (movie.getActors().contains(actor)){
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<Movie> getMoviesByMark(int mark){
        List<Movie> movies = new ArrayList<>(0);
        for(Movie movie : dataset){
            if(movie.getMark() == mark){
                movies.add(movie);
            }
        }
        return movies;
    }

    public boolean insertMovie(Movie movie){
        if(getMovieByName(movie.getTitle()) == null){
            dataset.add(movie);
            return true;
        }
        return false;
    }
    public void updateMovie(Movie old, Movie newMovie){
        for (int i = 0; i < dataset.size() && newMovie != null; i++) {
            if (dataset.get(i).getTitle().equals(old.getTitle())) {
                dataset.set(i, newMovie);
                newMovie = null;
            }
        }
    }

    public void deleteMovie(Movie movie){
        for (int i = 0; i < dataset.size() && movie != null; i++){
            if(dataset.get(i).getTitle().equals(movie.getTitle())){
                dataset.remove(i);
                movie = null;
            }
        }
    }
}
