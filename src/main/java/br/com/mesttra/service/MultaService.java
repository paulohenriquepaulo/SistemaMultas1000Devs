package br.com.mesttra.service;

import br.com.mesttra.model.Multa;
import br.com.mesttra.model.Veiculo;
import br.com.mesttra.repository.MultaRepository;
import br.com.mesttra.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

public class MultaService {

    private MultaRepository multaRepository = new MultaRepository();

    private VeiculoRepository veiculoRepository = new VeiculoRepository();

    public Multa registrarMulta(Multa multa) {
        if( multa.getVeiculo() == null || !multaRepository.save(multa)) {
            throw new RuntimeException("Erro ao criar uma nova multa");
        }
        System.out.println("Multa aplicada com sucesso!");
        return multa;
    }

    public void getMultasVeiculos(String placa) {
        try {
            Veiculo v = veiculoRepository.getVeiculo(placa);
            List<Multa>  list = multaRepository.ListaMultas(v.getId());
            if (!list.isEmpty()) {
                list.stream().forEach(m ->
                        System.out.println("------------------------------------------ " +
                                "\nMulta: " + m.getCodigoMulta() +
                                "\nPontuação: " + m.getPontuacao() +
                                "\nValor: " + m.getValor()));
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
