package com.example.Gerenciador_Nota_fiscal.controller;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import com.example.Gerenciador_Nota_fiscal.services.OrganizadorDeNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class NotaFiscalController {

    private final OrganizadorDeNotas organizador;

    @Autowired
    public NotaFiscalController(OrganizadorDeNotas organizador) {
        this.organizador = organizador;
    }

    @GetMapping("/")
    public String mostrarPaginaInicial(Model model) {
        List<NotaFiscal> notas = organizador.listarTodas();
        model.addAttribute("notas", notas);

        List<NotaFiscal> notasAVencer = organizador.listarNotasProximasDoVencimento();
        model.addAttribute("notasDeAlerta", notasAVencer);
        return "index";
    }

    @GetMapping("/notas/novo")
    public String mostrarFormularioDeAdicao(Model model) {
        model.addAttribute("notaFiscal", new NotaFiscal());
        return "formulario-nota";
    }

    @PostMapping("/notas/salvar")
    public String salvarNota(@ModelAttribute NotaFiscal notaFiscal) {
        if (notaFiscal.getNumero() == null || notaFiscal.getNumero().isEmpty()) {
            notaFiscal.setNumero(UUID.randomUUID().toString());
        }
        organizador.adicionar(notaFiscal);
        return "redirect:/";
    }

    @GetMapping("/notas/editar/{numero}")
    public String mostrarFormularioDeEdicao(@PathVariable String numero, Model model) {
        Optional<NotaFiscal> resultadoBusca = organizador.buscarPorNumero(numero);
        if (resultadoBusca.isPresent()) {
            model.addAttribute("notaFiscal", resultadoBusca.get());
        } else {
            return "redirect:/";
        }
        return "formulario-nota";
    }

    @PostMapping("/notas/excluir/{numero}")
    public String excluirNota(@PathVariable String numero) {
        organizador.excluirPorNumero(numero);
        return "redirect:/";
    }

    @PostMapping("/notas/pagar/{numero}")
    public String marcarNotaPaga(@PathVariable String numero) {
        organizador.marcarComoPaga(numero);
        return "redirect:/";
    }

}