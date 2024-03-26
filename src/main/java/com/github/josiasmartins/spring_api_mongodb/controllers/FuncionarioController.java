package com.github.josiasmartins.spring_api_mongodb.controllers;

import com.github.josiasmartins.spring_api_mongodb.model.Funcionario;
import com.github.josiasmartins.spring_api_mongodb.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.criar(funcionario);
    }


    @GetMapping("/range")
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate
    ) {
        return this.funcionarioService.obterFuncionarioPorRangeDeIdade(de, ate);
    }

    @GetMapping("/por-nome")
    public List<Funcionario> obterFuncionarioPorNome(@RequestParam("nome") String nome) {
        return this.funcionarioService.obterFuncionarioPorNome(nome);
    }

}
