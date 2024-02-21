package view;

import dao.UserDaoImpl;
import model.User;

public class Console {
    private static UserDaoImpl userDataset;
    public Console() {
        userDataset = UserDaoImpl.getInstance();
    }

    public void system() {
        MenuOptions option;

        do {
            option = Utils.Menu();

            switch (option) {
                case ADICIONAR_USUARIO -> {
                    User user = Utils.getUserData();
                    if (userDataset.insert(user))
                        System.out.println("Usuário adicionado com sucesso");
                    else
                        System.out.println("Usuário já existe");
                }
                case RECUPERAR_SENHA -> {

                    if (userDataset.changePassword(Utils.getString("o " +
                                    "username"),
                            Utils.getString("o e-mail"), Utils.getString("a " +
                                    "nova senha"))){
                        System.out.println("Senha alterada com sucesso");
                    } else {
                        System.out.println("Usuário não encontrado");
                    }
                }
                case FAZER_LOGIN -> {
                    User user = userDataset.login(Utils.getString("o " +
                            "username"), Utils.getString("a senha"));
                    if (user != null) {
                        System.out.println("Login efetuado com sucesso!");
                    } else {
                        System.out.println("Erro ao efetuar login!");
                    }
                }
                case SAIR -> {
                    System.out.println("Saindo...");
                }
            }

        } while (option != MenuOptions.SAIR);
    }
}
