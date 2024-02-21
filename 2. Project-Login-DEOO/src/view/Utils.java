package view;

import model.User;

import java.util.Scanner;

public class Utils {
    private static final Scanner scan = new Scanner(System.in);
    private static final String pageChanger = "-----------------------------------";
    public static MenuOptions Menu(){
        System.out.println(pageChanger);
        System.out.println("MENU PRINCIPAL");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar Usuario");
        System.out.println("2 - Recuperar Senha");
        System.out.println("3 - Fazer Login");

        return switch (scan.nextInt()){
            case 1 -> MenuOptions.ADICIONAR_USUARIO;
            case 2 -> MenuOptions.RECUPERAR_SENHA;
            case 3 -> MenuOptions.FAZER_LOGIN;
            default -> MenuOptions.SAIR;
        };
    }

    public static User getUserData(){
        scan.nextLine();
        System.out.println("Digite o username do usuário: ");
        String username = scan.nextLine();
        System.out.println("Digite o email do usuário: ");
        String email = scan.nextLine();
        System.out.println("Digite a senha do usuário: ");
        String password = scan.nextLine();
        return new User(username, email, password);
    }

    public static String getString(String remetente){
        System.out.println("Digite " + remetente + ": ");
        return scan.next();
    }
}
