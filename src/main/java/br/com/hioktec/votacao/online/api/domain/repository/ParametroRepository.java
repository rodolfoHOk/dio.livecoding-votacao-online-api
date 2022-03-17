package br.com.hioktec.votacao.online.api.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.hioktec.votacao.online.api.domain.model.ParametroModel;

public interface ParametroRepository extends MongoRepository<ParametroModel, String> {

}
