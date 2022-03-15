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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.DietaService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/dieta")
public class DietaResource {
	
	@Autowired
	private DietaService dietaService;
	
	
	@Operation(summary = "Crea una Dieta", description = "La creazione non richiede campi obbligatori", tags = { "Dieta Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dieta creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DietaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<DietaDTO> createDieta(@Validated @RequestBody DietaCreateDTO dto) {
		log.debug("REST request to create Dieta: {}", dto);
		return new ResponseEntity<>(dietaService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Diete che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Dieta Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dieta trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DietaDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Dieta trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<DietaDTO>> findDietaByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Dieta {}", ids);
		List<DietaDTO> dtos = dietaService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Diete che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Dieta Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dieta trovata"),
            @ApiResponse(responseCode = "204", description = "Nessun Dieta trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<DietaDTO>> searchDieta(DietaCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Dieta: {} {}", criteria, pageRequest);
        Page<DietaDTO> results = dietaService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Dieta", description = "L'aggiornamento richiede obbligatoriamente l'id della Dieta da aggiornare", tags = { "Dieta Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dieta aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = DietaDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Dieta non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<DietaDTO> updateDieta(@Validated @RequestBody DietaUpdateDTO dto) {
		log.debug("REST request to update Dieta: {}", dto);
        return new ResponseEntity<>(dietaService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Dieta", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Dieta Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dieta eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Dieta non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDieta(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Dieta: {}", id);
		dietaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
