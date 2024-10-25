package br.com.ehmf.receitas.Service;

import br.com.ehmf.receitas.Enum.TipoReceita;
import br.com.ehmf.receitas.Model.Ingredientes;
import br.com.ehmf.receitas.Model.ModoPreparo;
import br.com.ehmf.receitas.Model.Receitas;
import br.com.ehmf.receitas.Repository.ReceitasRepository;
import br.com.ehmf.receitas.Service.Interfaces.ReceitasServicesInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Receitas> iniciarBanco() {
        try {

            Integer dadosBanco = receitasRepository.findAll().size();

            if(dadosBanco > 0)
                return receitasRepository.findAll();

            Receitas receitas = new Receitas();
            receitas.setTipoReceita(TipoReceita.SALGADO);
            receitas.setTitulo("Bolinho de chuva salgado");
            receitas.setRendimento("30 porções");
            receitas.setTempoPreparo("30 minutos");
            receitas.setObservacoes("Receita fácil e rápida");

            List<Ingredientes> ingredientes = new ArrayList<>();
            ingredientes.add(new Ingredientes("Farinha de trigo", "2", "Xícaras"));
            ingredientes.add(new Ingredientes("Ovos", "2", "Unidade"));
            ingredientes.add(new Ingredientes("Leite", "1", "Xícara"));
            ingredientes.add(new Ingredientes("Fermento", "1", "Colher de sopa"));
            ingredientes.add(new Ingredientes("Queijo parmesão ralado", "100", "Gramas"));

            receitas.setIngredientes(ingredientes);

            List<ModoPreparo> modoPreparos = new ArrayList<>();
            modoPreparos.add(new ModoPreparo("Esquente o leite, mas não levante fervura",1));
            modoPreparos.add(new ModoPreparo("Misture todos os ingredientes até ficar uma massa homogênea",2));
            modoPreparos.add(new ModoPreparo("Faça pequenas bolinhas com a massa e frite",3));

            receitas.setModoPreparo(modoPreparos);

            receitasRepository.save(receitas);

            // *******************************************
            receitas = new Receitas();
            receitas.setTipoReceita(TipoReceita.DOCE);
            receitas.setTitulo("Bolo de cenoura");
            receitas.setRendimento("10 porções");
            receitas.setTempoPreparo("1 hora");
            receitas.setObservacoes("Receita fácil e rápida");

            ingredientes = new ArrayList<>();
            ingredientes.add(new Ingredientes("Cenoura", "3", "Unidades"));
            ingredientes.add(new Ingredientes("Ovos", "3", "Unidades"));
            ingredientes.add(new Ingredientes("Óleo", "1", "Xícara"));
            ingredientes.add(new Ingredientes("Açúcar", "2", "Xícaras"));
            ingredientes.add(new Ingredientes("Farinha de trigo", "2", "Xícaras"));
            ingredientes.add(new Ingredientes("Fermento", "1", "Colher de sopa"));

            receitas.setIngredientes(ingredientes);

            modoPreparos = new ArrayList<>();
            modoPreparos.add(new ModoPreparo("Bata no liquidificador a cenoura, os ovos e o óleo",1));
            modoPreparos.add(new ModoPreparo("Em uma tigela, misture o açúcar, a farinha e o fermento",2));
            modoPreparos.add(new ModoPreparo("Junte a mistura do liquidificador com a mistura da tigela",3));
            modoPreparos.add(new ModoPreparo("Coloque em uma forma untada e leve ao forno por 40 minutos",4));

            receitas.setModoPreparo(modoPreparos);

            receitasRepository.save(receitas);
            // *******************************************

            receitas = new Receitas();
            receitas.setTipoReceita(TipoReceita.BEBIDA);
            receitas.setTitulo("Suco de abacaxi");
            receitas.setRendimento("1 porção");
            receitas.setTempoPreparo("5 minutos");
            receitas.setObservacoes("Receita fácil e rápida");

            ingredientes = new ArrayList<>();
            ingredientes.add(new Ingredientes("Abacaxi", "1", "Unidade"));
            ingredientes.add(new Ingredientes("Água", "1", "Xícara"));
            ingredientes.add(new Ingredientes("Açúcar", "1", "Colher de sopa"));

            receitas.setIngredientes(ingredientes);

            modoPreparos = new ArrayList<>();
            modoPreparos.add(new ModoPreparo("Descasque o abacaxi e corte em pedaços",1));
            modoPreparos.add(new ModoPreparo("Bata no liquidificador o abacaxi, a água e o açúcar",2));
            modoPreparos.add(new ModoPreparo("Coe e sirva",3));

            receitas.setModoPreparo(modoPreparos);

            receitasRepository.save(receitas);

            return receitasRepository.findAll();
        }catch (Exception e){
            return null;
        }
    }
}
