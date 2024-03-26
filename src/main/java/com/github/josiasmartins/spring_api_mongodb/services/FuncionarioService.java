package com.github.josiasmartins.spring_api_mongodb.services;

import com.github.josiasmartins.spring_api_mongodb.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);

    public List<Funcionario> obterFuncionarioPorNome(String nome);

}
