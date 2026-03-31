package com.example.Gerenciador_Nota_fiscal.repositories;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    List<NotaFiscal> findByDataVencimentoBetween(LocalDate dataInicial, LocalDate dataFinal);
    Optional<NotaFiscal> findByNumero(String numero);

    @Modifying
    void deleteByNumero(String numero);
}