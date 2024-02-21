package view;

import model.Actor;
import model.Director;
import model.Movie;

import java.util.Scanner;

public class Utils {
    private static final Scanner scan = new Scanner(System.in);
    private static final String pageChanger = "---------- // ----------";

    public static MenuOptions menu() {
        System.out.println(pageChanger);
        System.out.println("MENU PRINCIPAL");
        System.out.println("0 - SAIR");
        System.out.println("1 - CADASTRAR FILME");
        System.out.println("2 - LISTAR TODOS FILMES CADASTRADOS");
        System.out.println("3 - LISTAR TODOS OS DIRETORES CADASTRADOS");
        System.out.println("4 - LISTAR TODOS OS ATORES CADASTRADOS");
        System.out.println("5 - LISTAR FILMES POR DIRETOR");
        System.out.println("6 - LISTAR FILMES POR ATOR");
        System.out.println("7 - LISTAR FILMES POR NOTA");

        return switch (scan.nextInt()){
            case 1 -> MenuOptions.CADASTRO_FILME;
            case 2 -> MenuOptions.LISTAR_FILMES;
            case 3 -> MenuOptions.LISTAR_DIRETORES;
            case 4 -> MenuOptions.LISTAR_ATORES;
            case 5 -> MenuOptions.FILMES_POR_DIRETOR;
            case 6 -> MenuOptions.FILMES_POR_ATOR;
            case 7 -> MenuOptions.FILMES_POR_NOTA;
            default -> MenuOptions.SAIR;
        };
    }

    public static Movie readFilmData(){
        System.out.println(pageChanger);
        scan.nextLine();
        System.out.println("CADASTRO DO FILME");
        System.out.print("Titulo do filme: ");
        String title = scan.nextLine();
        System.out.print("Ano de lançamento: ");
        int year = scan.nextInt();
        System.out.print("Numero de estrelas: ");
        int mark = scan.nextInt();
        scan.nextLine();
        System.out.print("Diretor do filme: ");
        String director = scan.nextLine();

        Movie movie = new Movie(title, new Director(director), year, mark);

        String name;
        int birthday;

        do{
            System.out.println("Insira o nome do ator: ");
            name = scan.nextLine();
            if(!name.isEmpty()) {
                System.out.println("Data de nascimento: ");
                birthday = scan.nextInt();
                movie.addActor(new Actor(name, birthday));
                System.out.println("Para finalizar, deixe o nome do ator em " +
                                "branco.\n");
                scan.nextLine();
            }
        }while (!name.isEmpty());

        return movie;
    }

    public static String getName(String remetente){
        scan.nextLine();
        System.out.println("Digite o nome do " + remetente + ": ");
        return scan.nextLine();
    }

    public static int getMark(){
        System.out.println("Nota: ");
        return scan.nextInt();
    }
}
