package br.com.mesttra.service;

import br.com.mesttra.model.Condutor;
import br.com.mesttra.model.Multa;
import br.com.mesttra.repository.MultaRepository;

public class MultaService {

    private MultaRepository multaRepository = new MultaRepository();

    public Multa registrarMulta(Multa multa) {
        if(!multaRepository.save(multa)) {
            throw new RuntimeException("Erro ao criar um novo condutor");
        }
        System.out.println("Multa aplicada com sucesso!");
        return multa;
    }
}
