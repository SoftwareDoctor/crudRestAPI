package it.softwaredoctor.webappapirest.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwaredoctor.webappapirest.model.Persona;
import it.softwaredoctor.webappapirest.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public Persona getPersona(Long id) {
		Optional<Persona> op = personaRepository.findById(id);
		if (op.isPresent())
			return op.get();

		return null;
	}

	public List<Persona> getPersone() {
		return personaRepository.findAll();
	}

	public void addPersona(Persona p) {
		personaRepository.save(p);
	}
	
	public void updatePersona(Persona p, Long id) {
		personaRepository.save(p);
	}
	
	public void deletePersona(Long id) {
		Optional<Persona> op = personaRepository.findById(id); 
		if (op.isPresent())
		personaRepository.delete(op.get());
	}

}
