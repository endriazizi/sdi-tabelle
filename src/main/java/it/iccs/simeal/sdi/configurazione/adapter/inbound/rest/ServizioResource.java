package it.iccs.simeal.sdi.configurazione.adapter.inbound.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ServizioService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/servizio")
public class ServizioResource {
	
	@Autowired
	private ServizioService servizioService;
	
	
	@Operation(summary = "Crea un Servizio", description = "La creazione non richiede campi obbligatori", tags = { "Servizio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servizio creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ServizioDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<ServizioDTO> createServizio(@Validated @RequestBody ServizioCreateDTO dto) {
		log.debug("REST request to create Servizio: {}", dto);
		return new ResponseEntity<>(servizioService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutti i Servizi che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Servizio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servizio trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServizioDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Servizio trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<ServizioDTO>> findServizioByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Servizio {}", ids);
		List<ServizioDTO> dtos = servizioService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutti i Servizi che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Servizio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servizio trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Servizio trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<ServizioDTO>> searchServizio(ServizioCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Servizio: {} {}", criteria, pageRequest);
        Page<ServizioDTO> results = servizioService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna un Servizio", description = "L'aggiornamento richiede obbligatoriamente l'id del Servizio da aggiornare", tags = { "Servizio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servizio aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ServizioDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Servizio non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<ServizioDTO> updateServizio(@Validated @RequestBody ServizioUpdateDTO dto) {
		log.debug("REST request to update Servizio: {}", dto);
		return new ResponseEntity<>(servizioService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina un Servizio", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Servizio Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Servizio eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Servizio non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteServizio(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Servizio: {}", id);
		servizioService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

