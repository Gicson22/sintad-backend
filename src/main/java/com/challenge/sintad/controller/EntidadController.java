package com.challenge.sintad.controller;

import com.challenge.sintad.model.Entidad;
import com.challenge.sintad.repository.EntidadRepository;
import com.challenge.sintad.repository.TipoDocumentoRepository;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"api/entidad"})
@AllArgsConstructor
public class EntidadController {

    private final EntidadRepository entidadRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;

    @GetMapping
    public List<Entidad> listadoEntidades() {return entidadRepository.findAll();}

    @GetMapping("/{id}")
    public Optional <Entidad> entidad(@PathVariable("id") int id) {return entidadRepository.findById(id);}


    @PostMapping
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public void createEntidad(@RequestBody Entidad entidad)
    {

        Entidad savedEntidad=entidadRepository.save(entidad);
    }

    @DeleteMapping("/{id}")
    public void deleteEntidad(@PathVariable("id") int id)
    {
        entidadRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entidad> updateEntidad(@PathVariable int id, @RequestBody Entidad entidadDetails) {
        Entidad updateEntidad = entidadRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("TipoContribuyente not exist with id: " + id));

        updateEntidad.setTipo_contribuyente(entidadDetails.getTipo_contribuyente());
        updateEntidad.setDireccion(entidadDetails.getDireccion());
        updateEntidad.setTelefono(entidadDetails.getTelefono());
        updateEntidad.setNombre_comercial(entidadDetails.getNombre_comercial());
        updateEntidad.setNro_documento(entidadDetails.getNro_documento());
        updateEntidad.setRazon_social(entidadDetails.getRazon_social());
        updateEntidad.setTipo_documento(entidadDetails.getTipo_documento());
        updateEntidad.setEstado(entidadDetails.isEstado());

        entidadRepository.save(updateEntidad);

        return ResponseEntity.ok(updateEntidad);
    }

}
