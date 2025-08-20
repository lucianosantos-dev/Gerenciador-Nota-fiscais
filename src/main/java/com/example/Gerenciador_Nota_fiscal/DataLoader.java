package com.example.Gerenciador_Nota_fiscal;

import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import com.example.Gerenciador_Nota_fiscal.services.OrganizadorDeNotas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner commandLineRunner(OrganizadorDeNotas organizador) {
        return args -> {
            NotaFiscal notaAlerta1 = new NotaFiscal(UUID.randomUUID().toString(), "Fornecedor de Café", new BigDecimal("85.50"),
                    LocalDate.now().minusDays(10), LocalDate.now().plusDays(2));

            System.out.println("DEBUG: Vencimento da nota de alerta 1: " + notaAlerta1.getDataVencimento());

            NotaFiscal notaAlerta2 = new NotaFiscal(UUID.randomUUID().toString(), "Serviços de TI", new BigDecimal("1250.00"),
                    LocalDate.now().minusDays(20), LocalDate.now().plusDays(6));

            NotaFiscal notaNormal1 = new NotaFiscal(UUID.randomUUID().toString(), "Aluguel Escritório", new BigDecimal("3500.00"),
                    LocalDate.now(), LocalDate.now().plusDays(30));

            NotaFiscal notaVencida = new NotaFiscal(UUID.randomUUID().toString(), "Conta de Luz", new BigDecimal("375.90"),
                    LocalDate.now().minusDays(40), LocalDate.now().minusDays(10));

            organizador.adicionar(notaAlerta1);
            organizador.adicionar(notaAlerta2);
            organizador.adicionar(notaNormal1);
            organizador.adicionar(notaVencida);
        };
    }
}