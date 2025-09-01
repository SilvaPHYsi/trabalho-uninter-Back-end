package dev.uninter.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.uninter.demo.model.Tarefa;
import dev.uninter.demo.repository.TarefaRepository;

@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;

	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		super();
		this.tarefaRepository = tarefaRepository;
	}
	
	//Listar
	public List<Tarefa> getAll() {return tarefaRepository.findAll();}
	
	//Salvar
	public Tarefa save(Tarefa tarefa) {	return tarefaRepository.save(tarefa);	}
	
	//Deletar
	public void delete() {}

}
