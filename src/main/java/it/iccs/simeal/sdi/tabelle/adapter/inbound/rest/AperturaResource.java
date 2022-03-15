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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.AperturaService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/apertura")
public class AperturaResource {
	
	@Autowired
	private AperturaService aperturaService;
	
	
	@Operation(summary = "Crea una Apertura", description = "La creazione richiede obbligatoriamente data inizio e data fine", tags = { "Apertura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apertura creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AperturaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<AperturaDTO> createApertura(@Validated @RequestBody AperturaCreateDTO dto) {
		log.debug("REST request to create Apertura: {}", dto);
		return new ResponseEntity<>(aperturaService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Aperture che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Apertura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apertura trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AperturaDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Apertura trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<AperturaDTO>> findAperturaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Apertura {}", ids);
		List<AperturaDTO> dtos = aperturaService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Classi Composizione che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Apertura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apertura trovata"),
            @ApiResponse(responseCode = "204", description = "Nessun Apertura trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<AperturaDTO>> searchApertura(AperturaCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Apertura: {} {}", criteria, pageRequest);
        Page<AperturaDTO> results = aperturaService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Apertura", description = "L'aggiornamento richiede obbligatoriamente l'id della Apertura da aggiornare", tags = { "Apertura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apertura aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AperturaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Apertura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<AperturaDTO> updateApertura(@Validated @RequestBody AperturaUpdateDTO dto) {
		log.debug("REST request to update Apertura: {}", dto);
        return new ResponseEntity<>(aperturaService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Apertura", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Apertura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Apertura eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Apertura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteApertura(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Apertura: {}", id);
		aperturaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
