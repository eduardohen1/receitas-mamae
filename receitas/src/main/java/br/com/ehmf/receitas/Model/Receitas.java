package br.com.ehmf.receitas.Model;

import br.com.ehmf.receitas.Enum.TipoReceita;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "receitas")
public class Receitas {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_receita", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TipoReceita tipoReceita;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "ingredientes")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredientes> ingredientes;

    @Column(name = "modo_preparo")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ModoPreparo> modoPreparo;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "rendimento")
    private String rendimento;

    @Column(name = "tempo_preparo")
    private String tempoPreparo;

    public Receitas() {
    }

    public Receitas(Long id, TipoReceita tipoReceita, String titulo, List<Ingredientes> ingredientes, List<ModoPreparo> modoPreparo, String observacoes, String rendimento, String tempoPreparo) {
        this.id = id;
        this.tipoReceita = tipoReceita;
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.observacoes = observacoes;
        this.rendimento = rendimento;
        this.tempoPreparo = tempoPreparo;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<ModoPreparo> getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(List<ModoPreparo> modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
