package com.gmail.ruijosecj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gmail.ruijosecj.model.entity.Lancamento;
import com.gmail.ruijosecj.model.entity.StatusLancamento;

@Service
public interface LancamentoService {
	
	Lancamento salvar(Lancamento lancamento);
	
	Lancamento atualizar(Lancamento lancamento);
	
	void deletar(Lancamento lancamento);
	
	List<Lancamento> buscar(Lancamento lancamentoFiltro);
	
	void atualizarStatus(Lancamento lancamento, StatusLancamento status);
	
	void validar(Lancamento lancamento);
}
