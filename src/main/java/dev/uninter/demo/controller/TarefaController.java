package dev.uninter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.uninter.demo.model.Tarefa;
import dev.uninter.demo.service.TarefaService;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    // Listar todas
    @GetMapping
    public List<Tarefa> getAll() {
        return tarefaService.getAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable Long id) {
        return tarefaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar nova
    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    // Atualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        try {
            return ResponseEntity.ok(tarefaService.update(id, tarefaAtualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            tarefaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
