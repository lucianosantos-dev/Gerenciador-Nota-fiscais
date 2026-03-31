package com.example.Gerenciador_Nota_fiscal.repositories;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    List<NotaFiscal> findByDataVencimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    Optional<NotaFiscal> findByNumero(String numero);

    boolean marcarComoPaga(String numero);

    List<NotaFiscal> listarNotasProximasDoVencimento();

    Optional<NotaFiscal> buscarPorNumero(String numero);


    void excluirPorNumero(String numero);


}