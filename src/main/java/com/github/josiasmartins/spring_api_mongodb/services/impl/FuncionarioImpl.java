package com.github.josiasmartins.spring_api_mongodb.services.impl;

import com.github.josiasmartins.spring_api_mongodb.model.Funcionario;
import com.github.josiasmartins.spring_api_mongodb.repository.FuncionarioRepository;
import com.github.josiasmartins.spring_api_mongodb.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não existe."));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {

        Funcionario chefe = this.funcionarioRepository
                .findById(funcionario.getChefe().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Chefe inexistente"));

        funcionario.setChefe(chefe);

        return this.funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate) {
        return this.funcionarioRepository.obterFuncionariosPorIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorNome(String nome) {
        return this.funcionarioRepository.findByNome(nome);
    }
}
