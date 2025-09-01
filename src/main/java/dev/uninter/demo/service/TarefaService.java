package dev.uninter.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.uninter.demo.model.Tarefa;
import dev.uninter.demo.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    // Listar todas
    public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }

    // Buscar por ID
    public Optional<Tarefa> getById(Long id) {
        return tarefaRepository.findById(id);
    }

    // Salvar nova
    public Tarefa save(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // Atualizar existente
    public Tarefa update(Long id, Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTaskName(tarefaAtualizada.getTaskName());
                    tarefa.setDeliveryDate(tarefaAtualizada.getDeliveryDate());
                    tarefa.setResponsible(tarefaAtualizada.getResponsible());
                    return tarefaRepository.save(tarefa);
                }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada com ID: " + id));
    }

    // Deletar por ID
    public void delete(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada com ID: " + id);
        }
    }
}