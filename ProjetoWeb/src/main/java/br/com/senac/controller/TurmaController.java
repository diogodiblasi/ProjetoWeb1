package br.com.senac.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listarTurmas")
	public ModelAndView buscarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurma");
		mv.addObject("turmas", turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastraTurma");
		mv.addObject("turma", new Turma());
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarTurma(Turma turma) {
		turmaService.salvar(turma);
		return buscarTodasTurmas();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarTurma(@PathVariable("id") Integer idTurma) {
		ModelAndView mv = new ModelAndView("turma/alteraTurma");
		mv.addObject("turma", turmaService.buscaPorID(idTurma));
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Turma turmaAlterado) throws ObjectNotFoundException {
		turmaService.salvarAlteração(turmaAlterado);
		return buscarTodasTurmas();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirTurma(@PathVariable("id") Integer id) {
		turmaService.excluir(id);
		return buscarTodasTurmas();
	}

}
