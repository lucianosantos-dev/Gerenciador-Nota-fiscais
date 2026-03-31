package com.example.Gerenciador_Nota_fiscal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotaFiscalDto {

    private Long id;

    private String numero;

    private String emissor;

    private BigDecimal valor;

    private LocalDate dataEmissao;

    private LocalDate dataVencimento;

    private Boolean paga;
}
