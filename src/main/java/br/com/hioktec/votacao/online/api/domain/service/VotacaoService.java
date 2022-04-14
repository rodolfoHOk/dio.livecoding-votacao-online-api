package br.com.hioktec.votacao.online.api.domain.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.hioktec.votacao.online.api.domain.model.ParticipanteModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotacaoService {

	private static final String TOPICO_VOTACAO = "votacao";

	private final KafkaTemplate<Object, Object> template;
		
	public void adicionarEvento(ParticipanteModel participante) {
		template.send(TOPICO_VOTACAO, participante);
	}
}
