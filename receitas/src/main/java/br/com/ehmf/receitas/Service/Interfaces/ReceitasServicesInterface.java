package br.com.ehmf.receitas.Service.Interfaces;


import br.com.ehmf.receitas.Model.Receitas;

import java.util.List;
import java.util.Optional;

public interface ReceitasServicesInterface {
    Receitas save(Receitas receitas) throws RuntimeException;
    List<Receitas> findAll();
    Optional<Receitas> findById(Long id);
    Receitas update(Receitas receitas) throws RuntimeException;
    void delete(Long id);
    Receitas findByTitulo(String titulo);
    List<Receitas> findByTipoReceita(String tipoReceita);
}
