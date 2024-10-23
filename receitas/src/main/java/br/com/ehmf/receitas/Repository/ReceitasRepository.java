package br.com.ehmf.receitas.Repository;

import br.com.ehmf.receitas.Enum.TipoReceita;
import br.com.ehmf.receitas.Model.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

    List<Receitas> findByTipoReceita(TipoReceita tipoReceita);

    Receitas findByTitulo(String titulo);
}
