package br.com.hioktec.votacao.online.api.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("participantes")
public class ParticipanteModel {
	
	@Id
	private String id;
	
	private String nome;
}