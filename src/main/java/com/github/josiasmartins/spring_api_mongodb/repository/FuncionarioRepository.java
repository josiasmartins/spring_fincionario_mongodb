package com.github.josiasmartins.spring_api_mongodb.repository;

import com.github.josiasmartins.spring_api_mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    // $and: serve para agrupar duas comparações
    // $gt: green than. $gte: greem than equal
    // $lt: less than
    @Query("{ $and: [ { 'idade': { $gte: ?0 } }, { 'idade': { $lte: ?1 } } ] }")
    public List<Funcionario> obterFuncionariosPorIdade(Integer de, Integer ate);

    public List<Funcionario> findByNome(String nome);

}
