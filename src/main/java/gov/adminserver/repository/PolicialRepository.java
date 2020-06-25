package gov.adminserver.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import gov.adminserver.document.Policial;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PolicialRepository extends ReactiveMongoRepository<Policial, String> {
	
	Mono<Policial> findByMatricula(Long matricula);
	Flux<Policial> findByTransferido(boolean ativo);
//	Policial deletePolicialByAfastamentosMotivo(String motivo); 
}
