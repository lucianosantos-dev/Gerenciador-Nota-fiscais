package com.example.Gerenciador_Nota_fiscal.services;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    List<NotaFiscal> findByDataVencimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    Optional<NotaFiscal> findByNumero(String numero);

    @Transactional
    void deleteByNumero(String numero);
}