package br.com.senac.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarProfessores")
	public ModelAndView listaTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
		mv.addObject("professores", professorService.buscarTodosProfessores());
		return mv;
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		professorService.salvar(professor);
		return listaTodosProfessores();
	}
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("professor/alteraProfessor");
		mv.addObject("professor", professorService.buscarPorID(idProfessor));
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Professor professorAlterado) throws ObjectNotFoundException {
		professorService.salvarAlteração(professorAlterado);
		return listaTodosProfessores();
	}
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProfessor(@PathVariable("id") Integer id) {
		professorService.excluir(id);
		return listaTodosProfessores();
	}
	
	

}
