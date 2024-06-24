package com.mballem.curso.jasper.spring.controller;

import com.mballem.curso.jasper.spring.entity.Funcionario;
import com.mballem.curso.jasper.spring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;

@Controller
public class HomeController {

    @Autowired
    private Connection connection;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/conn")
    public String myConn(Model model) {
        model.addAttribute("conn", connection != null ? "Conexãõ OK" : "Falhou");
        return "index";
    }

    @GetMapping("/certificados")
    public String certificadoValidaor(@RequestParam("cid") Long cid, Model model) {
        Funcionario funcionario = funcionarioRepository.findById(cid).get();
        model.addAttribute("mensagem","Confirmamos a veracidade deste certificado pertencente a " +
                funcionario.getNome() + " emitido em " + funcionario.getDataDemissao());
        return "index";
    }

}
