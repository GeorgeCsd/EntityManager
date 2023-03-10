package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // 1-Creates an instance of book
        Book book = new Book("H10G10", "The Hitchhiker's Guide to the Galaxy", 12.5F,"1-84023-742-2", 354, false);
        // 2-Obtains an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter15");
        EntityManager em = emf.createEntityManager();
        // 3-Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        // 4-Executes the named query
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        // 5-Closes the entity manager and the factory
        em.close();
        emf.close();
    }
}