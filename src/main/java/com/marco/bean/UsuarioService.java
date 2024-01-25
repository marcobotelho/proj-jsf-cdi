package com.marco.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UsuarioService {

	public String retornaNome() {
		return "Marcelo";
	}
}
