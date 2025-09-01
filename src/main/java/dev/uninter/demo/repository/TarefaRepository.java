package dev.uninter.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.uninter.demo.model.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	
}
