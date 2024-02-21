package view;

import dao.ActorDaoImpl;
import dao.DirectorDaoImpl;
import dao.MovieDaoImpl;
import model.Actor;
import model.Director;
import model.Movie;

import java.util.Locale;

public class Console {
    private static ActorDaoImpl actorDataset;
    private static DirectorDaoImpl directorDataset;
    private static MovieDaoImpl movieDataset;

    public Console(){
        actorDataset = ActorDaoImpl.getInstance();
        directorDataset = DirectorDaoImpl.getInstance();
        movieDataset = MovieDaoImpl.getInstance();
    }

    public static void system(){
        MenuOptions option;

        do {
            option = Utils.menu();

            switch(option){
                case CADASTRO_FILME:
                        Movie movieData = Utils.readFilmData();
                        if (movieDataset.insertMovie(movieData)){
                            for (Actor actor : movieData.getElenco()) {
                                actorDataset.insertActor(actor);
                            }
                            directorDataset.insertDirector(movieData.getDirector());
                            System.out.println("Êxito ao adicionar o filme!");
                        } else {
                            System.out.println("Falha ao adicionar o filme.");
                        }
                    break;

                case LISTAR_FILMES:
                        if(!movieDataset.isNull()) {
                            System.out.println("\nFILMES: \n");
                            for (Movie movie : movieDataset.getAllMovies()) {
                                System.out.println(movie.toString());
                                System.out.println();
                            }
                        } else {
                            System.out.println("Não há filmes a serem " +
                                    "listados.");
                        }

                    break;

                case LISTAR_DIRETORES:
                    if(!directorDataset.isNull()) {
                        System.out.println("\nDIRETORES: \n");
                        for (Director director : directorDataset.getAllDirectors()) {
                            System.out.println(director.getName());
                        }
                    } else {
                        System.out.println("Não há diretores a serem " +
                                "listados.");
                    }
                    break;

                case LISTAR_ATORES:
                    if (!actorDataset.isNull()) {
                        System.out.println("\nATORES: \n");
                        for(Actor actor : actorDataset.getAllActors()){
                            System.out.println(actor.getName() + " (" + actor.getAge() + ")");
                        }
                    } else {
                        System.out.println("Não há atores a serem " +
                                "listados.");
                    }
                    break;

                case FILMES_POR_DIRETOR:
                    String director = Utils.getName("diretor");
                    if (!movieDataset.getMoviesByDirector(director).isEmpty()) {
                        System.out.println("FILMES DO DIRETOR " + director.toUpperCase() + ":\n");
                        for (Movie movie :
                                movieDataset.getMoviesByDirector(director)) {
                            System.out.println(movie.toString());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Esse diretor não possui filmes " +
                                "cadastrados.");
                    }
                    break;

                case FILMES_POR_ATOR:
                    String actor = Utils.getName("ator");
                    if(!movieDataset.getMoviesByActor(actor).isEmpty()) {
                        System.out.println("\nFILMES DO ATOR " + actor.toUpperCase() + ":\n");
                        for (Movie movie :
                                movieDataset.getMoviesByActor(actor)) {
                            System.out.println(movie.toString());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Esse ator não possui filmes " +
                                "cadastrados.");
                    }
                    break;

                case FILMES_POR_NOTA:
                    int mark = Utils.getMark();
                    if (!movieDataset.getMoviesByMark(mark).isEmpty()) {
                        System.out.println("\nFILMES COM NOTA " + mark + ":\n");
                        for (Movie movie :
                                movieDataset.getMoviesByMark(mark)) {
                            System.out.println(movie.toString());
                            System.out.println();
                        }
                    } else {
                        System.out.println("Não há filmes cadastrados com " +
                                "essa nota no momento.");
                    }
                    break;
            }

        }while(option != MenuOptions.SAIR);
    }
}
