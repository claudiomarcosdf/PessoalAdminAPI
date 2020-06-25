package gov.adminserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.adminserver.document.Policial;
import gov.adminserver.repository.PolicialRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PolicialServiceImpl implements PolicialService {
	
	@Autowired
	PolicialRepository policialRepository;

	@Override
	public Flux<Policial> findAll() {
		return policialRepository.findAll();
	}

	@Override
	public Mono<Policial> findById(String id) {
		return policialRepository.findById(id);
	}

	@Override
	public Mono<Policial> save(Policial policial) {
		
		return policialRepository.save(policial);
	}

	@Override
	public Mono<Void> delete(Policial policial) {
		return policialRepository.delete(policial);
	}

	@Override
	public Flux<Policial> findByTransferido(boolean transferido) {
		return policialRepository.findByTransferido(transferido);
	}

	@Override
	public Mono<Policial> matriculaExiste(Long matricula) {
		return policialRepository.findByMatricula(matricula);
	}


}
