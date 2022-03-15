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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/classe")
public class ClasseResource {
	
	@Autowired
	private ClasseService classeService;
	
	
	@Operation(summary = "Crea una Classe", description = "La creazione non richiede campi obbligatori", tags = { "Classe Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe creata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClasseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<ClasseDTO> createClasse(@Validated @RequestBody ClasseCreateDTO dto) {
		log.debug("REST request to create Classe: {}", dto);
		return new ResponseEntity<>(classeService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Classi che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Classe Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClasseDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Classe trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<ClasseDTO>> findClasseByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Classe {}", ids);
		List<ClasseDTO> dtos = classeService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Classi che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Classe Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe trovata"),
            @ApiResponse(responseCode = "204", description = "Nessun Classe trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<ClasseDTO>> searchClasse(ClasseCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Classe: {} {}", criteria, pageRequest);
        Page<ClasseDTO> results = classeService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna una Classe", description = "L'aggiornamento richiede obbligatoriamente l'id della Classe da aggiornare", tags = { "Classe Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClasseDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Classe non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<ClasseDTO> updateClasse(@Validated @RequestBody ClasseUpdateDTO dto) {
		log.debug("REST request to update Classe: {}", dto);
        return new ResponseEntity<>(classeService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Classe", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Classe Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Classe non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClasse(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Classe: {}", id);
		classeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
