package com.example.Gerenciador_Nota_fiscal.mappers;

import com.example.Gerenciador_Nota_fiscal.dtos.NotaFiscalDto;
import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalMapper {

    public NotaFiscal toEntity(NotaFiscalDto dto) {
        return new NotaFiscal(
                dto.getId(),
                dto.getNumero(),
                dto.getEmissor(),
                dto.getValor(),
                dto.getDataEmissao(),
                dto.getDataVencimento(),
                dto.getPaga()
        );
    }

    public NotaFiscalDto toDto(NotaFiscal entity) {
        return new NotaFiscalDto(
                entity.getId(),
                entity.getNumero(),
                entity.getEmissor(),
                entity.getValor(),
                entity.getDataEmissao(),
                entity.getDataVencimento(),
                entity.isPaga()
        );
    }
}
