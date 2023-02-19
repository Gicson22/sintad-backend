package com.challenge.sintad.controller;

import com.challenge.sintad.model.Usuario;
import com.challenge.sintad.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"api/usuario"})
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listadoUsuarios() {return usuarioRepository.findAll();}

    @GetMapping("/{id}")
    public Optional <Usuario> usuario(@PathVariable("id") int id) {return usuarioRepository.findById(id);}


    @PostMapping
    public void createUsuario(@RequestBody Usuario usuario)
    {
        String encodePass = new BCryptPasswordEncoder().encode(usuario.getPassword() );

        usuario.setPassword(encodePass);
        Usuario savedUsuario=usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id") int id)
    {
        usuarioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuarioDetail) {
        Usuario updateUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("TipoContribuyente not exist with id: " + id));

        String encodePass = new BCryptPasswordEncoder().encode(usuarioDetail.getPassword());

        updateUsuario.setNombre(usuarioDetail.getNombre());
        updateUsuario.setApellidos(usuarioDetail.getApellidos());
        updateUsuario.setEmail(usuarioDetail.getEmail());
        updateUsuario.setPassword(encodePass);
        updateUsuario.setEstado(usuarioDetail.isEstado());

        usuarioRepository.save(updateUsuario);

        return ResponseEntity.ok(updateUsuario);
    }

}
