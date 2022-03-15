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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.MenuService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/menu")
public class MenuResource {
	
	@Autowired
	private MenuService menuService;
	
	
	@Operation(summary = "Crea un Menu", description = "La creazione non richiede campi obbligatori", tags = { "Menu Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PostMapping
	public ResponseEntity<MenuDTO> createMenu(@Validated @RequestBody MenuCreateDTO dto) {
		log.debug("REST request to create Menu: {}", dto);
		return new ResponseEntity<>(menuService.create(dto), HttpStatus.OK);
	}
	
	
	@Operation(summary = "Recupera tutti i Menu che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Menu Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MenuDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Menu trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping(params = {"ids"})
	public ResponseEntity<List<MenuDTO>> findMenuByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
		log.debug("REST request to find any Menu {}", ids);
		List<MenuDTO> dtos = menuService.findByIds(ids);
		if (dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Recupera tutti i Menu che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Menu Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Mense Menu trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@GetMapping("/ricerca")
	public ResponseEntity<Page<MenuDTO>> searchMenu(MenuCriteria criteria, Pageable pageRequest) {
		log.debug("REST request to search Menu: {} {}", criteria, pageRequest);
        Page<MenuDTO> results = menuService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
	}
	
	
	@Operation(summary = "Aggiorna un Menu", description = "L'aggiornamento richiede obbligatoriamente l'id del Menu da aggiornare", tags = { "Menu Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu aggiornato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = MenuDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Menu non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@PutMapping()
	public ResponseEntity<MenuDTO> ServizioMenu(@Validated @RequestBody MenuUpdateDTO dto) {
		log.debug("REST request to update Menu: {}", dto);
        return new ResponseEntity<>(menuService.update(dto), HttpStatus.OK);
    }
	
	
	@Operation(summary = "Elimina un Menu", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Menu Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Menu eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Menu non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable("id") UUID id) {
		log.debug("REST request to delete Menu: {}", id);
		menuService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
