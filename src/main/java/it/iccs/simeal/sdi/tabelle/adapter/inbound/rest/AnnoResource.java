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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.AnnoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/anno")
public class AnnoResource {
	
	@Autowired
	private AnnoService annoService;
	
	
	@Operation(summary = "Crea un Anno", description = "La creazione non richiede campi obbligatori", tags = { "Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<AnnoDTO> createAnno(@Validated @RequestBody AnnoCreateDTO dto) {
		log.debug("REST request to create Anno: {}", dto);
		return new ResponseEntity<>(annoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutti gli Anni che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AnnoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Anno trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<AnnoDTO>> findAnnoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Anno {}", ids);
		List<AnnoDTO> dtos = annoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutti gli Anni che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Anno trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<AnnoDTO>> searchAnno(AnnoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Anno: {} {}", criteria, pageRequest);
        Page<AnnoDTO> results = annoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna un Anno", description = "L'aggiornamento richiede obbligatoriamente l'id dell'Anno da aggiornare", tags = { "Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno aggiornato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<AnnoDTO> updateAnno(@Validated @RequestBody AnnoUpdateDTO dto) {
		log.debug("REST request to update Anno: {}", dto);
        return new ResponseEntity<>(annoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina un Anno", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAnno(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Anno: {}", id);
		annoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
