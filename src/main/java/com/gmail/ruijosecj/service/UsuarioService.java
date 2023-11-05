package com.gmail.ruijosecj.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gmail.ruijosecj.model.entity.Usuario;

@Service
public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
	Usuario salvarUsuario(Usuario usuario);
	
	void validarEmail(String email);
	
	Optional<Usuario> ObterPorId(Long id);
}
