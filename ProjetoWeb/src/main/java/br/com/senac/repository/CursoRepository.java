package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.entity.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Integer>{

}
