package com.challenge.sintad.controller;

import com.challenge.sintad.model.TipoDocumento;
import com.challenge.sintad.repository.TipoDocumentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"api/tipo-documento"})
@AllArgsConstructor
public class TipoDocumentoController {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @GetMapping
    public List<TipoDocumento> listadoTipoDocumento() {return tipoDocumentoRepository.findAll();}

    @GetMapping("/{id}")
    public Optional <TipoDocumento> tipoDocumento(@PathVariable("id") int id) {return tipoDocumentoRepository.findById(id);}


    @PostMapping
    public void createTipoDocumento(@RequestBody TipoDocumento tipoDocumento)
    {
        TipoDocumento savedTipoDocumento=tipoDocumentoRepository.save(tipoDocumento);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoDocumento(@PathVariable("id") int id)
    {
        tipoDocumentoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumento> updateTipoDocumento(@PathVariable int id, @RequestBody TipoDocumento tipoDocumentoDetails) {
        TipoDocumento updateTipoDocumento = tipoDocumentoRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("TipoContribuyente not exist with id: " + id));

        updateTipoDocumento.setNombre(tipoDocumentoDetails.getNombre());
        updateTipoDocumento.setCodigo(tipoDocumentoDetails.getCodigo());
        updateTipoDocumento.setDescripcion(tipoDocumentoDetails.getDescripcion());
        updateTipoDocumento.setEstado(tipoDocumentoDetails.isEstado());

        tipoDocumentoRepository.save(updateTipoDocumento);

        return ResponseEntity.ok(updateTipoDocumento);
    }

}
