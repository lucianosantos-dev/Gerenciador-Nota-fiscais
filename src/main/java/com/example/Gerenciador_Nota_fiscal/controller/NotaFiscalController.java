package com.example.Gerenciador_Nota_fiscal.controller;

import com.example.Gerenciador_Nota_fiscal.dtos.NotaFiscalDto;
import com.example.Gerenciador_Nota_fiscal.mappers.NotaFiscalMapper;
import com.example.Gerenciador_Nota_fiscal.services.NotaFiscalService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class NotaFiscalController {

    private final NotaFiscalService service;

    public NotaFiscalController(NotaFiscalService service) {
        this.service = service;
    }


    @PostMapping("/notas")
    public ResponseEntity<NotaFiscalDto> save(@RequestBody NotaFiscalDto notaFiscalDto) {
        NotaFiscalDto dto = service.save(notaFiscalDto);
        if (dto != null) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
            return ResponseEntity.created(uri).body(dto);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/notas/{numero}")
    public ResponseEntity<NotaFiscalDto> update(@PathVariable String numero, @RequestBody NotaFiscalDto notaFiscalDto) {
        NotaFiscalDto notaAtualizada = service.update(numero, notaFiscalDto);
        if (notaAtualizada != null) {
            return ResponseEntity.ok(notaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/notas")
    public ResponseEntity<List<NotaFiscalDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/notas/{numero}")
    public ResponseEntity<Optional<NotaFiscalDto>> findByNumero(@PathVariable String numero) {
        return ResponseEntity.ok(service.findByNumero(numero));
    }

    @PatchMapping("/notas/{numero}/pagamento")
    public ResponseEntity<Void> marcarComoPaga(@PathVariable String numero) {
        boolean atualizado = service.marcarComoPaga(numero);
        if (atualizado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/notas/{numero}")
    public ResponseEntity<Void> deleteByNumero(@PathVariable String numero) {
        Optional<NotaFiscalDto> opt = service.findByNumero(numero);
        if (opt.isPresent()) {
            service.deleteByNumero(numero);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/notas/vencendo")
    public ResponseEntity<List<NotaFiscalDto>> listarProximasVencimento() {
        List<NotaFiscalDto> list = service.listarNotasProximasDoVencimento();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

}