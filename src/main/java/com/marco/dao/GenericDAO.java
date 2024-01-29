package com.marco.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.marco.util.JPAUtil;

public abstract class GenericDAO<T> {

	private final Class<T> entityClass;
	protected final EntityManager entityManager = JPAUtil.getEntityManager();

	public GenericDAO(Class<T> entityClass, EntityManager entityManager) {
		this.entityClass = entityClass;
	}

	public T findById(Object id) {
		return entityManager.find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);
		Root<T> root = criteriaQuery.from(entityClass);
		criteriaQuery.select(root);

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public void save(T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public void delete(Object id) {
		T entity = findById(id);
		if (entity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		}
	}
}