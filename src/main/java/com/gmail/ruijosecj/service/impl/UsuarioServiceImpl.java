package com.gmail.ruijosecj.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.ruijosecj.exception.ErroAutenticacao;
import com.gmail.ruijosecj.exception.RegraNegocioException;
import com.gmail.ruijosecj.model.entity.Usuario;
import com.gmail.ruijosecj.model.repository.UsuarioRepository;
import com.gmail.ruijosecj.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");
		}
		return usuario.get();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existeEmail = repository.existsByEmail(email);
		if(existeEmail) {
			throw new RegraNegocioException("Já existe um usuario cadastrado com este email.");
			
		}
		
	}

}
