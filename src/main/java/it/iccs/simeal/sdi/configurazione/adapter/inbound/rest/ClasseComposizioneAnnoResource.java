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
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneAnnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/classe-composizione-anno")
public class ClasseComposizioneAnnoResource {
	
	@Autowired
	private ClasseComposizioneAnnoService classeComposizioneAnnoService;
	
	
	@Operation(summary = "Crea una Classe Composizione Anno", description = "La creazione non richiede campi obbligatori", tags = { "Classe Composizione Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Anno creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClasseComposizioneAnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<ClasseComposizioneAnnoDTO> createClasseComposizioneAnno(@Validated @RequestBody ClasseComposizioneAnnoCreateDTO dto) {
		log.debug("REST request to create ClasseComposizioneAnno: {}", dto);
		return new ResponseEntity<>(classeComposizioneAnnoService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutte le Classi Composizione Anno che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Classe Composizione Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe Composizione Anno trovata", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClasseComposizioneAnnoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessuna Classe Composizione Anno trovata", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<ClasseComposizioneAnnoDTO>> findClasseComposizioneAnnoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any ClasseComposizioneAnno {}", ids);
		List<ClasseComposizioneAnnoDTO> dtos = classeComposizioneAnnoService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutte le Classi Composizione Anno che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Classe Composizione Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe Composizione Anno trovata"),
            @ApiResponse(responseCode = "204", description = "Nessuna Classe Composizione Anno trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<ClasseComposizioneAnnoDTO>> searchClasseComposizioneAnno(ClasseComposizioneAnnoCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search ClasseComposizioneAnno: {} {}", criteria, pageRequest);
        Page<ClasseComposizioneAnnoDTO> results = classeComposizioneAnnoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	@Operation(summary = "Aggiorna una Classe Composizione Anno", description = "L'aggiornamento richiede obbligatoriamente l'id dell'Anno da aggiornare", tags = { "Classe Composizione Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe Composizione Anno aggiornata", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClasseComposizioneAnnoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Classe Composizione Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<ClasseComposizioneAnnoDTO> updateClasseComposizioneAnno(@Validated @RequestBody ClasseComposizioneAnnoUpdateDTO dto) {
		log.debug("REST request to update ClasseComposizioneAnno: {}", dto);
        return new ResponseEntity<>(classeComposizioneAnnoService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina una Classe Composizione Anno", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Classe Composizione Anno Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Classe Composizione Anno eliminata", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Classe Composizione Anno non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClasseComposizioneAnno(@PathVariable("id") UUID id) {
		log.debug("REST request to delete ClasseComposizioneAnno: {}", id);
		classeComposizioneAnnoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
