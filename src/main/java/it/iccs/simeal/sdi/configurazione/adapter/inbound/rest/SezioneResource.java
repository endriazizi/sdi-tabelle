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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.SezioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/sezione")
public class SezioneResource {
	
	@Autowired
	private SezioneService sezioneService;
	
	
	@Operation(summary = "Crea una Sezione", description = "La creazione non richiede campi obbligatori", tags = { "Sezione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sezione creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SezioneDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<SezioneDTO> createSezione(@Validated @RequestBody SezioneCreateDTO dto) {
		log.debug("REST request to create Sezione: {}", dto);
		return new ResponseEntity<>(sezioneService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Sezioni che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Sezione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sezione trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SezioneDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Sezione trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<SezioneDTO>> findSezioneByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Sezione {}", ids);
		List<SezioneDTO> dtos = sezioneService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
//	@GetMapping(params = {"ids"})
//	public ResponseEntity<Page<SezioneDTO>> findSezioneByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids, Pageable pageRequest) {
//		log.debug("REST request to find any Sezione {}", ids);
//		SezioneCriteria criteria = new SezioneCriteria();
//		criteria.setId(ids);
//        Page<SezioneDTO> dtos = sezioneService.search(criteria, pageRequest);
//		if (dtos.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(dtos, HttpStatus.OK);
//        }
//	}
	
	
	@Operation(summary = "Recupera tutte le Sezioni che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Sezione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sezione trovata"),
            @ApiResponse(responseCode = "204", description = "Nessun Sezione trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<SezioneDTO>> searchSezione(SezioneCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Sezione: {} {}", criteria, pageRequest);
        Page<SezioneDTO> results = sezioneService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Sezione", description = "L'aggiornamento richiede obbligatoriamente l'id della Sezione da aggiornare", tags = { "Sezione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sezione aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SezioneDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Sezione non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<SezioneDTO> updateSezione(@Validated @RequestBody SezioneUpdateDTO dto) {
		log.debug("REST request to update Sezione: {}", dto);
		return new ResponseEntity<>(sezioneService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Sezione", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Sezione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sezione eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Sezione non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSezione(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Sezione: {}", id);
		sezioneService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

