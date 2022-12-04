package br.com.mesttra.service;

import br.com.mesttra.model.Condutor;
import br.com.mesttra.repository.CondutorRepository;

public class CondutorService {

    private CondutorRepository condutorRepository = new CondutorRepository();



    public Condutor criarCondutor(Condutor condutor) {
        if(!condutorRepository.save(condutor)) {
            throw new RuntimeException("Erro ao criar um novo condutor");
        }
        System.out.println("Condutor Cadastrado com sucesso!");
        return condutor;
    }

    public Condutor buscarCondutor(String cnh) {
        try {
        return condutorRepository.getCondutor(cnh);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void atualizarPontuacaoCNH(Condutor condutor) {
        condutorRepository.atualizarPontuacaoCNH(condutor);
    }
}
