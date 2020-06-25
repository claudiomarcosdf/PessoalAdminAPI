package gov.adminserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gov.adminserver.document.Policial;
import gov.adminserver.exceptions.MatriculaExistenteException;
import gov.adminserver.exceptions.PolicialNotFoundException;
import gov.adminserver.services.PolicialService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pessoal")
public class PolicialController {
	
	@Autowired
	PolicialService policialService;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "A requisição falhou!")
	@PostMapping
	public Mono<ResponseEntity<Policial>> adicionar(@Valid @RequestBody Policial policial){
		System.out.println("Novo policial...");
		
		return policialService.matriculaExiste(policial.getMatricula())
            .hasElement()
            .flatMap(foundPolicial -> {
            	if (foundPolicial)
            	{
            		return Mono.error(new MatriculaExistenteException("Matrícula já cadastrada!"));
            	} else 
            	{
           		  return policialService.save(policial) 
           				 .map(policialSalvo -> ResponseEntity.ok(policialSalvo))
           				 .onErrorReturn(ResponseEntity.badRequest().build());            		
            		
            	}
            });

		/*
		 * return policialService.save(policial) .map(policialSalvo ->
		 * ResponseEntity.ok(policialSalvo))
		 * .onErrorReturn(ResponseEntity.badRequest().build());
		 */
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A requisição falhou!") //ValidationException
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Policial>> atualizar(@Valid @PathVariable String id, @RequestBody Policial policial){

		return policialService.matriculaExiste(policial.getMatricula())
	            .flatMap(foundPolicial -> {
	            	if (foundPolicial.getMatricula().equals(policial.getMatricula()) && !foundPolicial.getId().equals(policial.getId()))
	            	{
	            		return Mono.error(new MatriculaExistenteException("Matrícula já cadastrada!"));
	            	} else 
	            	{
	           		  return policialService.save(policial) 
	           				 .map(policialSalvo -> ResponseEntity.ok(policialSalvo))
	           				 .onErrorReturn(ResponseEntity.badRequest().build());            		
	            		
	            	}
	            });		
		
		/*
		 * return policialService.save(policial) .map(policialSalvo ->
		 * ResponseEntity.ok(policialSalvo))
		 * .onErrorReturn(ResponseEntity.badRequest().build());
		 */
	}
	
	@GetMapping
	public Flux<Policial> getPolicial(){
		System.out.print("lista");
		return policialService.findAll();
	}
	
	@GetMapping(value="/{id}")
    public Mono<ResponseEntity<Policial>> getPolicialId(@PathVariable String id){
		
    	return policialService.findById(id)
    			.map(policial -> ResponseEntity.ok(policial))
    			.switchIfEmpty(Mono.error(new PolicialNotFoundException("Policial não encontrado!")));
//    			.defaultIfEmpty(ResponseEntity.notFound().build());
    }
	
	
	@DeleteMapping(value="/{id}")
	public Mono<ResponseEntity<Void>> deletar(@PathVariable String id){
		return policialService.findById(id)
				.flatMap(policial -> policialService.delete(policial)
				   .then(Mono.just(ResponseEntity.ok().<Void>build()))		
				)
				.switchIfEmpty(Mono.error(new PolicialNotFoundException("Policial não encontrado!")));
				//.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@GetMapping(value = "/transferido")
	public Flux<Policial> getAtivos(){
		
		return policialService.findByTransferido(true);

	}

}
