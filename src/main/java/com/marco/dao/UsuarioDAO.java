package com.marco.dao;

import javax.persistence.EntityManager;

import com.marco.model.UsuarioModel;

public class UsuarioDAO extends GenericDAO<UsuarioModel> {

	public UsuarioDAO(EntityManager entityManager) {
		super(UsuarioModel.class, entityManager);
	}

}
