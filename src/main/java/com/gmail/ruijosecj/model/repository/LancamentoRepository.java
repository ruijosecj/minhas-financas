package com.gmail.ruijosecj.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gmail.ruijosecj.model.entity.Lancamento;

@Repository
public interface LancamentoRepository  extends JpaRepository<Lancamento, Long>{

}
