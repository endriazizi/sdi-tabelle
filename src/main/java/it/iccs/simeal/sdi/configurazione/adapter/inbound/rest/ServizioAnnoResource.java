package it.iccs.simeal.sdi.configurazione.adapter.inbound.rest;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ServizioAnnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/servizio-anno")
public class ServizioAnnoResource {
	
	@Autowired
	private ServizioAnnoService servizioAnnoService;
	
	
	@Operation(summary = "Crea le configurazioni del servizio per l'anno", description = "La creazione richiede obbligatoriamente il servizio, l'anno e la tipologia di rilevazione", tags = { "Servizio Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Configurazione creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ServizioAnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<ServizioAnnoDTO> createServizioAnno(@Valid @RequestBody ServizioAnnoCreateDTO dto) {
		log.debug("REST request to create ServizioANno: {}", dto);
		return new ResponseEntity<>(servizioAnnoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le configurazioni che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Servizio Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Configurazione trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServizioAnnoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessuna configurazione trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<ServizioAnnoDTO>> findServizioAnnoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any ServizioAnno {}", ids);
		List<ServizioAnnoDTO> dtos = servizioAnnoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le configurazioni che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Servizio Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Configurazione trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna configurazione trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<ServizioAnnoDTO>> searchServizioAnno(ServizioAnnoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search ServizioAnno: {} {}", criteria, pageRequest);
        Page<ServizioAnnoDTO> results = servizioAnnoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una configurazione", description = "L'aggiornamento richiede obbligatoriamente l'id della configurazione da aggiornare", tags = { "Servizio Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Configurazione aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ServizioAnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Configurazione non trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<ServizioAnnoDTO> updateServizioAnno(@Validated @RequestBody ServizioAnnoUpdateDTO dto) {
		log.debug("REST request to update ServizioAnno: {}", dto);
        return new ResponseEntity<>(servizioAnnoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una configurazione", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Servizio Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Configurazione eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Configurazione non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteServizioAnno(@PathVariable("id") UUID id) {
		log.debug("REST request to delete ServizioAnno: {}", id);
		servizioAnnoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
