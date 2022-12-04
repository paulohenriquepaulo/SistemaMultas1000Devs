package br.com.mesttra.repository;

import br.com.mesttra.model.Condutor;
import br.com.mesttra.model.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;


public class VeiculoRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("mildevs-multas");
    private static EntityManager manager = factory.createEntityManager();


    public boolean save(Veiculo veiculo) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(veiculo);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }

    public boolean update(Veiculo v) {
        manager = Persistence.createEntityManagerFactory("mildevs-multas").createEntityManager();
        manager.getTransaction().begin();
        manager.merge(v);
        manager.getTransaction().commit();
        manager.close();
        return true;
    }


    public Veiculo getVeiculo(String placa) {
        Long idVeiculo = getIdVeiculo(placa);
        if (idVeiculo == null) {
            throw new RuntimeException("Veiculo não encontrado");
        }
        return manager.find(Veiculo.class, idVeiculo);

    }

    private Long getIdVeiculo(String placa) {
        Query query = manager.createNativeQuery("select v.id from veiculo v where v.placa = " + placa + ";");
        for (Object o : query.getResultList()) {
            if (o != null) {
                return Long.parseLong(o.toString());
            }
        }
        return null;
    }


 /*   // CONSULTAR
    public  CondutorModel consultaAluno(int matricula) {
        return manager.find(Aluno.class, matricula);
    }
*//*
    // LISTAR
    public List<Aluno> listaAlunos() {
        Query query = manager.createQuery("select a from Aluno as a");
        return query.getResultList();
    }*/

  /*  // REMOVER
    public boolean removeAluno(int matricula) {
        Aluno alunoASerRemovido = manager.find(Aluno.class, matricula);

        if (alunoASerRemovido == null)
            return false;

        manager.getTransaction().begin();
        manager.remove(alunoASerRemovido);
        manager.getTransaction().commit();

        return true;
    }*/
}
