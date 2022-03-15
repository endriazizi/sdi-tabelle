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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ChiusuraService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/chiusura")
public class ChiusuraResource {
	
	@Autowired
	private ChiusuraService chiusuraService;
	
	
	@Operation(summary = "Crea una Chiusura", description = "La creazione richiede obbligatoriamente data inizio e data fine", tags = { "Chiusura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chiusura creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ChiusuraDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<ChiusuraDTO> createChiusura(@Validated @RequestBody ChiusuraCreateDTO dto) {
		log.debug("REST request to create Chiusura: {}", dto);
		return new ResponseEntity<>(chiusuraService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Aperture che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Chiusura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chiusura trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ChiusuraDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Chiusura trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<ChiusuraDTO>> findChiusuraByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Chiusura {}", ids);
		List<ChiusuraDTO> dtos = chiusuraService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Classi Composizione che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Chiusura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chiusura trovata"),
            @ApiResponse(responseCode = "204", description = "Nessun Chiusura trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<ChiusuraDTO>> searchChiusura(ChiusuraCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Chiusura: {} {}", criteria, pageRequest);
        Page<ChiusuraDTO> results = chiusuraService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Chiusura", description = "L'aggiornamento richiede obbligatoriamente l'id della Chiusura da aggiornare", tags = { "Chiusura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chiusura aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ChiusuraDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Chiusura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<ChiusuraDTO> updateChiusura(@Validated @RequestBody ChiusuraUpdateDTO dto) {
		log.debug("REST request to update Chiusura: {}", dto);
        return new ResponseEntity<>(chiusuraService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Chiusura", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Chiusura Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chiusura eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Chiusura non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteChiusura(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Chiusura: {}", id);
		chiusuraService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
