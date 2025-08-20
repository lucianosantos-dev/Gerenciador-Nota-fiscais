package com.example.Gerenciador_Nota_fiscal.services;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;

import java.util.List;
import java.util.Optional;

public interface OrganizadorDeNotas {
    void adicionar(NotaFiscal nota);

    List<NotaFiscal> listarTodas();

    Optional<NotaFiscal> buscarPorNumero(String numero);

    boolean marcarComoPaga(String numero);

    void excluirPorNumero(String numero);

    List<NotaFiscal> listarNotasProximasDoVencimento();
}
