package com.marco.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("usuarioBean")
@RequestScoped
public class UsuarioBean {

	private String nome;

	@Inject
	private UsuarioService usuarioService;

	@PostConstruct
	public void init() {
		nome = usuarioService.retornaNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String salvar() {
		return null;
	}
}
