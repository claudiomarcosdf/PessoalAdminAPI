package gov.adminserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gov.adminserver.document.Afastamento;
import gov.adminserver.document.Policial;
import gov.adminserver.services.PolicialService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pessoal/afastamento")
public class AfastamentoController {
	
	@Autowired
	PolicialService policialService;
		
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Policial inexistente!")
	@PutMapping(value="/{id}")
	public Mono<ResponseEntity<Policial>> adicionarAfastamento(@PathVariable("id") String id, @RequestBody Afastamento afastamento){
		System.out.println("Incluindo afastamento no documento Policial..." + id);
		
		return policialService.findById(id)
          .flatMap(policial -> {
//			  if (policial.getAfastamentos().indexOf(afastamento) != -1) {
//				  return Mono.error(new ArrayIndexOutOfBoundsException("Afastamento já cadastrado!"));
//			  }
//        	  List<Afastamento> afastamentos =  new ArrayList<Afastamento>(policial.getAfastamentos());
//            afastamentos.add(afastamento);        	  
        	  
        	  // Pode ser feito da forma anterior ou da seguinte forma:
        	  
        	  List<Afastamento> afastamentos =  new ArrayList<Afastamento>(policial.getAfastamentos()); 
        	  Optional<Afastamento> afast = afastamentos.stream().filter(af -> af.equals(afastamento)).findFirst();

        	  if (afast.isPresent()) {
        		  return Mono.error(new ArrayIndexOutOfBoundsException("Afastamento já cadastrado!"));
        	  }
     	      afastamentos.add(afastamento);
     	     
        	  policial.setAfastamentos(afastamentos);
        	  return policialService.save(policial);
          })
          .map(policialSalvo -> ResponseEntity.ok(policialSalvo))
		  .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Afastamento inexistente!")
	@DeleteMapping(value="/{id}")
	public Mono<ResponseEntity<Policial>> removerAfastamento(@PathVariable String id, @RequestBody Afastamento afastamento){
		System.out.println("Removendo afastamento do documento Policial..."+afastamento.getMotivo());

		return policialService.findById(id)
		  .flatMap(policial -> {
			  if (policial.getAfastamentos().indexOf(afastamento) == -1) {
				  return Mono.error(new ArrayIndexOutOfBoundsException("Afastamento inexistente para exclusão!"));
			  }
			  
			  List<Afastamento> afastamentos =  new ArrayList<Afastamento>(policial.getAfastamentos());
			  afastamentos.remove(policial.getAfastamentos().indexOf(afastamento));// É necessário hascode e equals

			  policial.setAfastamentos(afastamentos);
			  return policialService.save(policial);
		  })
		  .map(policialSalvo -> ResponseEntity.ok(policialSalvo))
		  .defaultIfEmpty(ResponseEntity.notFound().build());
	}


}
