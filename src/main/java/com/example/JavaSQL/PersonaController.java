package com.example.JavaSQL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();
    }

    @PostMapping("/persona")
    public String crearPersona(@RequestBody Persona persona) {
        personaRepository.save(persona);
        return "Persona creada";
    }

    @DeleteMapping("/persona/{id}")
    public String borrarPersona(@PathVariable int id) {
        personaRepository.deleteById(id);
        return "Persona " + id + " borrada";
    }
    @PutMapping("/persona/{id}")
    public String modifPersona(@PathVariable int id, @RequestBody Persona persona) {
        personaRepository.save(persona);
    }
}