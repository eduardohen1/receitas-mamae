package br.com.ehmf.receitas.Service;

import br.com.ehmf.receitas.Enum.TipoReceita;
import br.com.ehmf.receitas.Model.Receitas;
import br.com.ehmf.receitas.Repository.ReceitasRepository;
import br.com.ehmf.receitas.Service.Interfaces.ReceitasServicesInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitasService implements ReceitasServicesInterface {

    private ReceitasRepository receitasRepository;

    public ReceitasService(ReceitasRepository receitasRepository){
        this.receitasRepository = receitasRepository;
    }

    @Override
    public Receitas save(Receitas receitas) throws RuntimeException {
        try {
            //validar objeto receitas
            if (receitas.getTitulo() == null || receitas.getTitulo().isEmpty())
                throw new RuntimeException("Nome da receita é obrigatório");
            if (receitas.getModoPreparo() == null || receitas.getModoPreparo().isEmpty())
                throw new RuntimeException("Modo de preparo é obrigatório");
            if (receitas.getIngredientes() == null || receitas.getIngredientes().isEmpty())
                throw new RuntimeException("Ingredientes são obrigatórios");
            if (receitas.getTipoReceita() == null)
                receitas.setTipoReceita(TipoReceita.OUTROS);
            return receitasRepository.save(receitas);
        }catch (Exception e){
            throw new RuntimeException("Erro ao gravar receita: " + e.getMessage());
        }
    }

    @Override
    public List<Receitas> findAll() {
        return receitasRepository.findAll();
    }

    @Override
    public Optional<Receitas> findById(Long id) {
        return receitasRepository.findById(id);
    }

    @Override
    public Receitas update(Receitas receitas) throws RuntimeException {
        try {
            Optional<Receitas> findReceitas = receitasRepository.findById(receitas.getId());
            if (findReceitas.isPresent()) {
                Receitas receitasUp = findReceitas.get();
                receitasUp.setTitulo(receitas.getTitulo());
                receitasUp.setTipoReceita(receitas.getTipoReceita());
                receitasUp.setIngredientes(receitas.getIngredientes());
                receitasUp.setModoPreparo(receitas.getModoPreparo());
                receitasUp.setObservacoes(receitas.getObservacoes());
                receitasUp.setRendimento(receitas.getRendimento());
                receitasUp.setTempoPreparo(receitas.getTempoPreparo());
                return receitasRepository.save(receitasUp);
            } else {
                return save(receitas);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao atualizar a receita: " + ex.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Receitas> receitas = receitasRepository.findById(id);
        if(!receitas.isEmpty())
            receitasRepository.delete(receitas.get());
    }

    @Override
    public Receitas findByTitulo(String titulo) {
        //buscar receitas por titulo
        return receitasRepository.findByTitulo(titulo);
    }

    @Override
    public List<Receitas> findByTipoReceita(String tipoReceita) {
        //buscar receitas por tipoReceita
        TipoReceita tipoDaReceita = null;
        switch (tipoReceita.toUpperCase()){
            case "DOCE":
                tipoDaReceita = TipoReceita.DOCE;
                break;
            case "SALGADO":
                tipoDaReceita = TipoReceita.SALGADO;
                break;
            case "BEBIDA":
                tipoDaReceita = TipoReceita.BEBIDA;
                break;
            case "OUTROS":
                tipoDaReceita = TipoReceita.OUTROS;
                break;
        }
        if(tipoReceita != null)
            return receitasRepository.findByTipoReceita(tipoDaReceita);
        return null;
    }

    public List<String> retornaTiposReceitas(){
        List<String> tipos = List.of("Doce", "Salgado", "Bebida", "Outros");
        return tipos;
    }
}
