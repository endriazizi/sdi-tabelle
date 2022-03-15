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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.PastoAlternativoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/pasto-alternativo")
public class PastoAlternativoResource {
	
	@Autowired
	private PastoAlternativoService pastoAlternativoService;
	
	
	@Operation(summary = "Crea un Pasto Alternativo", description = "La creazione non richiede campi obbligatori", tags = { "Pasto Alternativo Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasto Alternativo creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PastoAlternativoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<PastoAlternativoDTO> createPastoAlternativo(@Validated @RequestBody PastoAlternativoCreateDTO dto) {
		log.debug("REST request to create PastoAlternativo: {}", dto);
		return new ResponseEntity<>(pastoAlternativoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutti i Pasti Alternativi che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Pasto Alternativo Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasto Alternativo trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = PastoAlternativoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Pasto Alternativo trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<PastoAlternativoDTO>> findPastoAlternativoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any PastoAlternativo {}", ids);
		List<PastoAlternativoDTO> dtos = pastoAlternativoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutti i Pasti Alternativi che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Pasto Alternativo Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasto Alternativo trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Pasto Alternativo trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<PastoAlternativoDTO>> searchPastoAlternativo(PastoAlternativoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search PastoAlternativo: {} {}", criteria, pageRequest);
        Page<PastoAlternativoDTO> results = pastoAlternativoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna un Pasto Alternativo", description = "L'aggiornamento richiede obbligatoriamente l'id del Pasto Alternativo da aggiornare", tags = { "Pasto Alternativo Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasto Alternativo aggiornato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PastoAlternativoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Mense Pasto Alternativo non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<PastoAlternativoDTO> updatePastoAlternativo(@Validated @RequestBody PastoAlternativoUpdateDTO dto) {
		log.debug("REST request to update PastoAlternativo: {}", dto);
        return new ResponseEntity<>(pastoAlternativoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina un Pasto Alternativo", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Pasto Alternativo Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pasto Alternativo eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Pasto Alternativo non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePastoAlternativo(@PathVariable("id") UUID id) {
		log.debug("REST request to delete PastoAlternativo: {}", id);
		pastoAlternativoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
