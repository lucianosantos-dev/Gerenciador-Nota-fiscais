package com.example.Gerenciador_Nota_fiscal.services;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizadorDeNotasEmMemoria implements OrganizadorDeNotas {

    private final NotaFiscalRepository notaFiscalRepository;

    @Autowired
    public OrganizadorDeNotasEmMemoria(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @Override
    public void adicionar(NotaFiscal nota) {
        notaFiscalRepository.save(nota);
    }

    @Override
    public List<NotaFiscal> listarTodas() {
        return notaFiscalRepository.findAll(Sort.by(Sort.Direction.ASC, "dataVencimento"));
    }

    @Override
    public Optional<NotaFiscal> buscarPorNumero(String numero) {
        return notaFiscalRepository.findByNumero(numero);
    }

    @Override
    public boolean marcarComoPaga(String numero) {
        Optional<NotaFiscal> notaOptional = notaFiscalRepository.findByNumero(numero);
        if (notaOptional.isPresent()) {
            NotaFiscal nota = notaOptional.get();
            nota.setPaga(true);
            notaFiscalRepository.save(nota);
            return true;
        }
        return false;
    }

    @Override
    public void excluirPorNumero(String numero) {
        notaFiscalRepository.deleteByNumero(numero);
    }

    @Override
    public List<NotaFiscal> listarNotasProximasDoVencimento() {
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.plusDays(7);
        return notaFiscalRepository.findByDataVencimentoBetween(hoje, dataLimite);
    }
}