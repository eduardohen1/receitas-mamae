package br.com.ehmf.receitas.Enum;

public enum TipoReceita {
    DOCE(1, "Doce"), SALGADO(2, "Salgado"), BEBIDA(3, "Bebida"), OUTROS(4, "Outros");

    private int id;
    private String descricao;

    private TipoReceita(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    //Gets e Sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
