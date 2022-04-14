package br.com.hioktec.votacao.online.api.api.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.votacao.online.api.domain.model.ParticipanteModel;
import br.com.hioktec.votacao.online.api.domain.repository.ParticipanteRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/participantes")
public class ParticipanteController {
	
	private final ParticipanteRepository repository;
	
	@PostMapping("/salvar")
	public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
		ParticipanteModel participanteSalvo = repository.save(participante);
		return ResponseEntity.status(HttpStatus.CREATED).body(participanteSalvo);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParticipanteModel> consulta(@RequestParam String id) {
		Optional<ParticipanteModel> optParticipante = repository.findById(id);
		if (optParticipante.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optParticipante.get());
		}
	}

}
