package it.iccs.simeal.sdi.tabelle.adapter.inbound.rest;

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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.CentroCotturaService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/centro-cottura")
public class CentroCotturaResource {
	
	@Autowired
	private CentroCotturaService centroCotturaService;
	
	
	@Operation(summary = "Crea un Centro Cottura", description = "La creazione non richiede campi obbligatori", tags = { "Centro Cottura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "CentroCottura creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CentroCotturaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<CentroCotturaDTO> createCentroCottura(@Validated @RequestBody CentroCotturaCreateDTO dto) {
		log.debug("REST request to create CentroCottura: {}", dto);
		return new ResponseEntity<>(centroCotturaService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutti i Centri Cottura che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Centro Cottura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CentroCotturaDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Centro Cottura trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<CentroCotturaDTO>> findCentroCotturaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any CentroCottura {}", ids);
		List<CentroCotturaDTO> dtos = centroCotturaService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutti i Centri Cottura che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Centro Cottura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Centro Cottura trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<CentroCotturaDTO>> searchCentroCottura(CentroCotturaCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search CentroCottura: {} {}", criteria, pageRequest);
        Page<CentroCotturaDTO> results = centroCotturaService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna un Centro Cottura", description = "L'aggiornamento richiede obbligatoriamente l'id del Centro Cottura da aggiornare", tags = { "Centro Cottura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura aggiornato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CentroCotturaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Centro Cottura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<CentroCotturaDTO> updateIstituto(@Validated @RequestBody CentroCotturaUpdateDTO dto) {
		log.debug("REST request to update CentroCottura: {}", dto);
        return new ResponseEntity<>(centroCotturaService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Centro Cottura un Istituto", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Centro Cottura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Centro Cottura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCentroCottura(@PathVariable("id") UUID id) {
		log.debug("REST request to delete CentroCottura: {}", id);
		centroCotturaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
