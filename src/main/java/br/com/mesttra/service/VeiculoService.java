package br.com.mesttra.service;

import br.com.mesttra.model.Veiculo;
import br.com.mesttra.repository.VeiculoRepository;

public class VeiculoService {


    private VeiculoRepository veiculoRepository = new VeiculoRepository();


    public Veiculo cadastrarVeiculo(Veiculo veiculo) {
        if (veiculoRepository.save(veiculo)) {
            return veiculo;
        }
        return null;
    }

    public Veiculo buscarVeiculo(String placa){
        try {
            return veiculoRepository.getVeiculo(placa);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean atualizarVeiculo(Veiculo v) {
      return   veiculoRepository.update(v);
    }
}
