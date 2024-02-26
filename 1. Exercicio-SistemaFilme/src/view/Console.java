package view;

import controller.ActorController;
import controller.DirectorController;
import controller.MovieController;
import model.Actor;
import model.Director;
import model.Movie;

public class Console {
    private static MovieController movieController;
    private static ActorController actorController;
    private static DirectorController directorController;

    public Console(){
         movieController = new MovieController();
         actorController = new ActorController();
         directorController = new DirectorController();
    }

    public static void system(){
        MenuOptions option;

        do {
            option = Utils.menu();

            switch(option){
                case CADASTRO_FILME:
                        Movie movieData = Utils.readFilmData();
                        if (movieController.addMovie(movieData)){
                            System.out.println("Êxito ao adicionar o filme!");
                        } else {
                            System.out.println("Falha ao adicionar o filme.");
                        }
                    break;

                case LISTAR_FILMES:
                        if(!movieController.isNull()) {
                            System.out.println("\nFILMES CADASTRADOS:\n");
                            for (Movie movie : movieController.getAllMovies()) {
                                System.out.println(movie.toString());
                            }
                        } else {
                            System.out.println("Não há filmes a serem " +
                                    "listados.");
                        }

                    break;

                case LISTAR_DIRETORES:
                    if(!directorController.isNull()) {
                        System.out.println("\nDIRETORES CADASTRADOS:\n");
                            for (Director director :
                                 directorController.getAllDirectors()) {
                                System.out.println(director);
                            }
                    } else {
                        System.out.println("Não há diretores a serem " +
                                "listados.");
                    }
                    break;

                case LISTAR_ATORES:
                    if (!actorController.isNull()) {
                        System.out.println("\nATORES CADASTRADOS:\n");
                        for (Actor actor : actorController.getAllActors()){
                            System.out.println(actor.getName() + " (" + actor.getAge() + ")");
                        }

                    } else {
                        System.out.println("Não há atores a serem " +
                                "listados.");
                    }
                    break;

                case FILMES_POR_DIRETOR:
                    String director = Utils.getName("diretor");
                    if (!movieController.getMoviesByDirector(director).isEmpty()) {
                        System.out.println("\nFILMES DO DIRETOR " + director.toUpperCase() + ": \n");

                            for (Movie movie : movieController.getMoviesByDirector(director)){
                                System.out.println(movie);
                            }
                    } else {
                        System.out.println("Esse diretor não possui filmes " +
                                "cadastrados.");
                    }
                    break;

                case FILMES_POR_ATOR:
                    String actor = Utils.getName("ator");
                    if(!movieController.getMoviesByActor(actor).isEmpty()) {
                        System.out.println("\nFILMES DO ATOR " + actor.toUpperCase() + ":\n");
                        for (Movie movie :
                                movieController.getMoviesByActor(actor)) {
                            System.out.println(movie.toString());
                        }
                    } else {
                        System.out.println("Esse ator não possui filmes " +
                                "cadastrados.");
                    }
                    break;

                case FILMES_POR_NOTA:
                    int mark = Utils.getMark();
                    if (!movieController.getMoviesByMark(mark).isEmpty()) {
                        System.out.println("\nFILMES COM NOTA " + mark + ":\n");
                        for (Movie movie :
                                movieController.getMoviesByMark(mark)) {
                            System.out.println(movie.toString());
                        }
                    } else {
                        System.out.println("Não há filmes cadastrados com " +
                                "essa nota no momento.");
                    }
                    break;
            }

        }while(option != MenuOptions.SAIR);

        System.out.println("Saindo...");
    }
}
