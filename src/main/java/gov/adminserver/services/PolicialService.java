package gov.adminserver.services;

import gov.adminserver.document.Policial;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PolicialService {
	
	Flux<Policial> findAll();
	Mono<Policial> findById(String id);
	Flux<Policial> findByTransferido(boolean transferido);
	Mono<Policial> matriculaExiste(Long matricula);
	
	Mono<Policial> save(Policial policial);
	Mono<Void> delete(Policial policial);

}
