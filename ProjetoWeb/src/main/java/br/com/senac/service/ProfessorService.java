package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repoProfessor;
	
	public List<Professor> buscarTodosProfessores(){
		return repoProfessor.findAll();
	}
	public Professor salvar(Professor professor) {
		return repoProfessor.save(professor);
	}
	
	public Professor buscarPorID(Integer id)throws ObjectNotFoundException{
		Optional<Professor> professor = repoProfessor.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException(professor, "Professor nao encontrado. Id: " + id));
	}
	
	public Professor salvarAlteração(Professor professorAlterado) throws ObjectNotFoundException {
		Professor professor = buscarPorID(professorAlterado.getId());
		professor.setId(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return salvar(professor);
	}
	
	public void excluir(Integer id) {
		repoProfessor.deleteById(id);
	}
	
	
}
