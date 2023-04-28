package br.com.senac.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	CursoRepository repoCurso;
	
	public List<Curso> buscarTodosCursos(){
		return repoCurso.findAll();
	}
	public Curso salvar(Curso curso) {
		return repoCurso.save(curso);
	}
	public Curso buscarPorID(Integer id)throws ObjectNotFoundException{
		return repoCurso.findById(id).get();

		
	}
	
	public Curso salvarAlteração(Curso cursoAlterado) throws ObjectNotFoundException{
		Curso curso = buscarPorID(cursoAlterado.getId());
		curso.setId(cursoAlterado.getId());
		curso.setNome(cursoAlterado.getNome());
		return salvar(curso);
		
	}
	
	public void excluir (Integer id) {
		repoCurso.deleteById(id);
	}

}
