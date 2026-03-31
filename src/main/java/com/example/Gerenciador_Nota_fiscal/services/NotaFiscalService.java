package com.example.Gerenciador_Nota_fiscal.services;

import com.example.Gerenciador_Nota_fiscal.dtos.NotaFiscalDto;
import com.example.Gerenciador_Nota_fiscal.entities.NotaFiscal;
import com.example.Gerenciador_Nota_fiscal.mappers.NotaFiscalMapper;
import com.example.Gerenciador_Nota_fiscal.repositories.NotaFiscalRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {

    private final NotaFiscalRepository repository;
    private final NotaFiscalMapper mapper;

    public NotaFiscalService(NotaFiscalRepository repository, NotaFiscalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public NotaFiscalDto save(NotaFiscalDto notaFiscalDto) {
        NotaFiscal notaFiscal = mapper.toEntity(notaFiscalDto);
        notaFiscal = repository.save(notaFiscal);
        return mapper.toDto(notaFiscal);
    }

    @Transactional
    public NotaFiscalDto update(String numero, NotaFiscalDto notaFiscalDto) {
        Optional<NotaFiscal> opt = repository.findByNumero(numero);
        if (opt.isPresent()) {
            Long idExistente = opt.get().getId();
            NotaFiscal notaFiscal = mapper.toEntity(notaFiscalDto);
            notaFiscal.setId(idExistente);
            notaFiscal.setNumero(numero);
            NotaFiscal notaAtualizada = repository.save(notaFiscal);
            return mapper.toDto(notaAtualizada);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<NotaFiscalDto> findAll() {
        List<NotaFiscal> notas = repository.findAll(Sort.by(Sort.Direction.ASC, "dataVencimento"));
        return notas.stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public Optional<NotaFiscalDto> findByNumero(String numero) {
        return repository.findByNumero(numero).map(mapper::toDto);
    }

    @Transactional
    public boolean marcarComoPaga(String numero) {
        Optional<NotaFiscal> notaOptional = repository.findByNumero(numero);
        if (notaOptional.isPresent()) {
            NotaFiscal nota = notaOptional.get();
            nota.setPaga(true);
            repository.save(nota);
            return true;
        }
        return false;
    }

    @Transactional
    public void deleteByNumero(String numero) {
        repository.deleteByNumero(numero);
    }

    @Transactional(readOnly = true)
    public List<NotaFiscalDto> listarNotasProximasDoVencimento() {
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimite = hoje.plusDays(7);
        List<NotaFiscal> list = repository.findByDataVencimentoBetween(hoje, dataLimite);
        return list.stream().map(mapper::toDto).toList();
    }
}