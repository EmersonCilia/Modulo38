package br.com.emerson.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("monolithPU");

    public static EntityManagerFactory getEmf() {
        return EMF;
    }
}