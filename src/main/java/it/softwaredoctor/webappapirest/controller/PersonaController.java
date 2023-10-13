package it.softwaredoctor.webappapirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.softwaredoctor.webappapirest.model.Persona;
import it.softwaredoctor.webappapirest.service.PersonaService;

@RestController
@RequestMapping("/api")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("/persone/{id}")
	public Persona getPersona(@PathVariable Long id) {

		return personaService.getPersona(id);

	}

	@GetMapping("/persone")
	public List<Persona> getPersone() {

		return personaService.getPersone();

	}

	// passo un oggetto persona e lascio che sia spring a fare il parse con
	// l'annotazione @Requestbody
	// Response entity è una classe standard di spring mvc
	@PostMapping("/persone")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona p) {
		personaService.addPersona(p);

		return new ResponseEntity<Persona>(p, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/persone/{id}")
	public ResponseEntity<String> updatePersona(@PathVariable Long id, @RequestBody Persona p) {
		personaService.updatePersona(p, id);

		return new ResponseEntity<String>("Persona aggiornata correttamente", HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/persone/{id}")
	public ResponseEntity<String> deletePersona(@PathVariable Long id) {
		personaService.deletePersona(id);
		return new ResponseEntity<String>("Persona eliminata correttamente", HttpStatus.CREATED);
		
	}

}
