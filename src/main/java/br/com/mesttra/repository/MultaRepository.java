package br.com.mesttra.repository;

import br.com.mesttra.model.Condutor;
import br.com.mesttra.model.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class MultaRepository{

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mildevs-multas");
    private static EntityManager manager = factory.createEntityManager();

    public boolean save(Multa multa) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(multa);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }
}
