package dev.uninter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.uninter.demo.model.Tarefa;

import dev.uninter.demo.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	private final TarefaService tarefaService;

	@Autowired // 
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	
	@GetMapping
	public List<Tarefa>getAll(){return tarefaService.getAll();}
	@PostMapping
	public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }
	
}
