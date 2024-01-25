package com.marco.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@ApplicationScoped
public class JPAUtil {

	// Nome da unidade de persistência no arquivo persistence.xml
	private static final String PERSISTENCE_UNIT_NAME = "pu-proj-jsf-cdi";
	private static EntityManagerFactory factory;

	static {
		init();
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void close() {
		factory.close();
	}

	public static void init() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
	}

	public void startup(@Observes @Initialized(ApplicationScoped.class) Object context) {
		init();
	}

	public void shutdown(@Observes @Destroyed(ApplicationScoped.class) Object context) {
		close();
	}
}
