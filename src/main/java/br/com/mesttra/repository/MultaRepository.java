package br.com.mesttra.repository;

import br.com.mesttra.model.Multa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MultaRepository {

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

    public List<Multa> ListaMultas(Long idVeiculo) {
        String sql = "select * from multa m where m.veiculo_id = " + idVeiculo + ";";
        List<Multa> listaRetorno =  manager.createNativeQuery(sql, Multa.class).getResultList();
        if (listaRetorno.isEmpty()) {
            throw new RuntimeException("Veiculo não contem multas");
        }

        manager.close();
        return listaRetorno;
    }
}
