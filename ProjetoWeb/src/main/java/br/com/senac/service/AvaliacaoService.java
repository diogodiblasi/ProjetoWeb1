package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Avaliacao;
import br.com.senac.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	public List<Avaliacao> buscarTodasAvaliacoes(){
		return avaliacaoRepository.findAll();
	}
	
	public Avaliacao salvar(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
	
	public Avaliacao atualizar(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
}
