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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.CentroCotturaIstitutoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/centro-cottura-istituto")
public class CentroCotturaIstitutoResource {
	
	@Autowired
	private CentroCotturaIstitutoService centroCotturaIstitutoService;
	
	@Operation(summary = "Crea un Centro Cottura Istituto", description = "La creazione non richiede campi obbligatori", tags = { "Centro Cottura Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura Istituto creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CentroCotturaIstitutoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<CentroCotturaIstitutoDTO> createCentroCotturaIstituto(@Validated @RequestBody CentroCotturaIstitutoCreateDTO dto) {
		log.debug("REST request to create CentroCotturaIstituto: {}", dto);
		return new ResponseEntity<>(centroCotturaIstitutoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Centro Cottura Istituto che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Centro Cottura Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura Istituto trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CentroCotturaIstitutoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessuna Centro Cottura Istituto trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<CentroCotturaIstitutoDTO>> findCentroCotturaIstitutoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any CentroCotturaIstituto {}", ids);
		List<CentroCotturaIstitutoDTO> dtos = centroCotturaIstitutoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Centro Cottura Istituto che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Centro Cottura Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura Istituto trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Centro Cottura Istituto trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<CentroCotturaIstitutoDTO>> searchCentroCotturaIstituto(CentroCotturaIstitutoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search CentroCotturaIstituto: {} {}", criteria, pageRequest);
        Page<CentroCotturaIstitutoDTO> results = centroCotturaIstitutoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	@Operation(summary = "Aggiorna una Centro Cottura Istituto", description = "L'aggiornamento richiede obbligatoriamente l'id del Centro Cottura Istituto da aggiornare", tags = { "Centro Cottura Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura Istituto aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CentroCotturaIstitutoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Centro Cottura Istituto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<CentroCotturaIstitutoDTO> updateCentroCotturaIstituto(@Validated @RequestBody CentroCotturaIstitutoUpdateDTO dto) {
		log.debug("REST request to update CentroCotturaIstituto: {}", dto);
        return new ResponseEntity<>(centroCotturaIstitutoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina un Centro Cottura Istituto", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Centro Cottura Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Centro Cottura Istituto eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Centro Cottura Istituto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCentroCotturaIstituto(@PathVariable("id") UUID id) {
		log.debug("REST request to delete CentroCotturaIstituto: {}", id);
		centroCotturaIstitutoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
