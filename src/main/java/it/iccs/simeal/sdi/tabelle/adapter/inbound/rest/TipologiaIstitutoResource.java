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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.TipologiaIstitutoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/tipologia-istituto")
public class TipologiaIstitutoResource {
	
	@Autowired
	private TipologiaIstitutoService tipologiaIstitutoService;
	
	
	@Operation(summary = "Crea una Tipologia Istituto", description = "La creazione non richiede campi obbligatori", tags = { "Tipologia Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Istituto creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TipologiaIstitutoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<TipologiaIstitutoDTO> createTipologiaIstituto(@Validated @RequestBody TipologiaIstitutoCreateDTO dto) {
		log.debug("REST request to create TipologiaIstituto: {}", dto);
		return new ResponseEntity<>(tipologiaIstitutoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Tipologie Istituto che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Tipologia Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Istituto trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TipologiaIstitutoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessuna Tipologia Istituto trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<TipologiaIstitutoDTO>> findTipologiaIstitutoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any TipologiaIstituto {}", ids);
		List<TipologiaIstitutoDTO> dtos = tipologiaIstitutoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Tipologie IStituto che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Tipologia Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Istituto trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna TipologiaIstituto trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<TipologiaIstitutoDTO>> searchTipologiaIstituto(TipologiaIstitutoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search TipologiaIstituto: {} {}", criteria, pageRequest);
        Page<TipologiaIstitutoDTO> results = tipologiaIstitutoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Tipologia Istituto", description = "L'aggiornamento richiede obbligatoriamente l'id della Tipologia Istituto da aggiornare", tags = { "Tipologia Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Istituto aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = TipologiaIstitutoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Tipologia Istituto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<TipologiaIstitutoDTO> updateTipologiaIstituto(@Validated @RequestBody TipologiaIstitutoUpdateDTO dto) {
		log.debug("REST request to update TipologiaIstituto: {}", dto);
        return new ResponseEntity<>(tipologiaIstitutoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Tipologia Istituto", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Tipologia Istituto Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Istituto eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Tipologia Istituto non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTipologiaIstituto(@PathVariable("id") UUID id) {
		log.debug("REST request to delete TipologiaIstituto: {}", id);
		tipologiaIstitutoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
