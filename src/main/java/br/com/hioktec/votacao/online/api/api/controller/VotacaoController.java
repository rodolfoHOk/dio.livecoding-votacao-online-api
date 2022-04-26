package br.com.hioktec.votacao.online.api.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.votacao.online.api.domain.model.ParticipanteModel;
import br.com.hioktec.votacao.online.api.domain.service.VotacaoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/votacao")
@CrossOrigin
public class VotacaoController {
	
	private final VotacaoService service;
	
	@PostMapping
	public ResponseEntity<ParticipanteModel> votar(@RequestBody ParticipanteModel participante) {
		service.adicionarEvento(participante);
		return ResponseEntity.ok(participante);
	}

}
