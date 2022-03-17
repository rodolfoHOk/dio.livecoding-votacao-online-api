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

import br.com.hioktec.votacao.online.api.domain.model.ParametroModel;
import br.com.hioktec.votacao.online.api.domain.repository.ParametroRepository;

@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

	private final ParametroRepository repository;

	public ParametroController(ParametroRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametro) {
		ParametroModel parametroSalvo = repository.save(parametro);
		return ResponseEntity.status(HttpStatus.CREATED).body(parametroSalvo);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParametroModel> consulta(@RequestParam String chave) {
		Optional<ParametroModel> optParametro = repository.findById(chave);
		if (optParametro.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optParametro.get());
		}
	}
}
