package br.com.ehmf.receitas.Controller;

import br.com.ehmf.receitas.Exceptions.ReceitaException;
import br.com.ehmf.receitas.Model.Receitas;
import br.com.ehmf.receitas.Service.ReceitasService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receitas")
public class ReceitasController {

    private ReceitasService receitasService;

    public ReceitasController(ReceitasService receitasService){
        this.receitasService = receitasService;
    }

    @Operation(summary = "Salvar receita")
    @PostMapping
    public ResponseEntity<Receitas> save(@RequestBody Receitas receitas){
        Receitas receita = receitasService.save(receitas);
        if (receita == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(receita);

    }

    @Operation(summary = "Listar todas as receitas")
    @GetMapping
    public ResponseEntity<List<Receitas>> findAll(){
        List<Receitas> receitasList = receitasService.findAll();
        if(receitasList == null)
            return ResponseEntity.notFound().build();
        if(receitasList.size() == 0)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(receitasList);
    }

    @Operation(summary = "Buscar receita por id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Receitas>> findById(@PathVariable Long id){
        Optional<Receitas> receitas = receitasService.findById(id);
        if(receitas.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(receitas);
    }

    @Operation(summary = "Atualizar receita")
    @PutMapping
    public ResponseEntity<Receitas> update(@RequestBody Receitas receitas){
        Receitas receita = receitasService.update(receitas);
        if (receita == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(receita);
    }

    @Operation(summary = "Deletar receita")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        receitasService.delete(id);
        return ResponseEntity.ok().build();
    }

    //buscar lista de receitas por tipo
    @Operation(summary = "Buscar receitas por tipo")
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Receitas>> findByTipo(@PathVariable String tipo){
        List<Receitas> receitasList = receitasService.findByTipoReceita(tipo);
        if(receitasList == null)
            return ResponseEntity.notFound().build();
        if(receitasList.size() == 0)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(receitasList);
    }

    //retornar lista com os tipos de receita
    @Operation(summary = "Listar tipos de receitas")
    @GetMapping("/tipos")
    public ResponseEntity<List<String>> tipos(){
        return ResponseEntity.ok(receitasService.retornaTiposReceitas());
    }

    @GetMapping("/iniciarBanco")
    public ResponseEntity<List<Receitas>> iniciarBanco(){
        try {
            List<Receitas> receitas = receitasService.iniciarBanco();
            if(receitas == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(receitas);
        } catch (ReceitaException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
