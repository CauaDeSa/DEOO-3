package view;

public enum MenuOptions {
    ADICIONAR_USUARIO(1, "Adicionar usuário"),
    RECUPERAR_SENHA(2, "Recuperar senha"),
    FAZER_LOGIN(3, "Fazer login"),
    SAIR(4, "Sair");

    private final int value;
    private final String description;

    MenuOptions(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
