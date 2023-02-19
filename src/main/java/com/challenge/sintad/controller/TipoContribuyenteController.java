package com.challenge.sintad.controller;

import com.challenge.sintad.repository.EntidadRepository;
import lombok.AllArgsConstructor;
import com.challenge.sintad.model.TipoContribuyente;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import com.challenge.sintad.repository.TipoContribuyenteRepository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"api/tipo-contribuyente"})
@AllArgsConstructor
public class TipoContribuyenteController {

    private final TipoContribuyenteRepository tipoContribuyenteRepository;
    private final EntidadRepository entidadRepository;

    @GetMapping
    public List<TipoContribuyente> listadoTipoContribuyente() {return tipoContribuyenteRepository.findAll();}

    @GetMapping("/{id}")
    public Optional <TipoContribuyente> tipoContribuyente(@PathVariable("id") int id) {return tipoContribuyenteRepository.findById(id);}


    @PostMapping
    public void createTipoContribuyente(@RequestBody TipoContribuyente tipoContribuyente)
    {
        TipoContribuyente savedTipoContribuyente=tipoContribuyenteRepository.save(tipoContribuyente);
    }

    @DeleteMapping("/{id}")


    public void deleteTipoContribuyente(@PathVariable("id") int id)
    {
        tipoContribuyenteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoContribuyente> updateTipoContribuyente(@PathVariable int id, @RequestBody TipoContribuyente tipoContribuyenteDetails) {
        TipoContribuyente updateTipoContribuyente = tipoContribuyenteRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("TipoContribuyente not exist with id: " + id));

        updateTipoContribuyente.setNombre(tipoContribuyenteDetails.getNombre());
        updateTipoContribuyente.setEstado(tipoContribuyenteDetails.isEstado());

        tipoContribuyenteRepository.save(updateTipoContribuyente);

        return ResponseEntity.ok(updateTipoContribuyente);
    }

}
