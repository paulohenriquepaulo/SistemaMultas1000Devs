package br.com.mesttra.repository;

import br.com.mesttra.model.Condutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class CondutorRepository{


    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mildevs-multas");
    private static EntityManager manager = factory.createEntityManager();

    public boolean save(Condutor condutorModel) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(condutorModel);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    // CONSULTAR
    public Condutor getCondutor(String cnh) {
        Long idCondutor = getIdCondutor(cnh);
        if (idCondutor == null) {
            throw  new RuntimeException("Condutor não encontrado");
        }
            return manager.find(Condutor.class, idCondutor);

    }

    private Long getIdCondutor(String cnh) {
        Query query = manager.createNativeQuery("select c.id from condutor c where c.numeroCnh = " + cnh + ";");
        for (Object o : query.getResultList()) {
            if (o != null) {
                return Long.parseLong(o.toString());
            }
        }
        return null;
    }

    public void atualizarPontuacaoCNH(Condutor condutor) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.merge(condutor);
        manager.getTransaction().commit();
        manager.close();
    }

}
