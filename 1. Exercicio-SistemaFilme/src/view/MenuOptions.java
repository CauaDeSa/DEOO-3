package view;

public enum MenuOptions {
    SAIR(0),

    CADASTRO_FILME(1),

    LISTAR_FILMES(2),

    LISTAR_DIRETORES(3),

    LISTAR_ATORES(4),

    FILMES_POR_DIRETOR(5),

    FILMES_POR_ATOR(6),

    FILMES_POR_NOTA(7);

    private final int value;

    MenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}