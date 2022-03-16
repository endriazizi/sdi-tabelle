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
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.RiduzioneTipoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoUpdateDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/riduzione-tipo")
public class RiduzioneTipoResource {

    @Autowired
    private RiduzioneTipoService riduzioneTipoService;


    @Operation(summary = "Crea un Tipologia Riduzione", description = "La creazione non richiede campi obbligatori", tags = { "Tipologia Riduzione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Riduzione creato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RiduzioneTipoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PostMapping
    public ResponseEntity<RiduzioneTipoDTO> createRiduzioneTipo(@Validated @RequestBody RiduzioneTipoCreateDTO dto) {
        log.debug("REST request to create TipologiaRiduzione: {}", dto);
        return new ResponseEntity<>(riduzioneTipoService.create(dto), HttpStatus.OK);
    }


    @Operation(summary = "Recupera tutti le Tipologie Riduzione che soddisfano gli id inseriti",
            description = "La ricerca richiede obbligatoriamente una lista di id", tags = { "Tipologia Riduzione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Riduzione trovato", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RiduzioneTipoDTO.class)))}),
            @ApiResponse(responseCode = "204", description = "Nessun Tipologia Riduzione trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping(params = {"ids"})
    public ResponseEntity<List<RiduzioneTipoDTO>> findRiduzioneTipoByIds(@NotNull @RequestParam(value = "ids") List<UUID> ids) {
        log.debug("REST request to find any TipologiaRiduzione {}", ids);
        List<RiduzioneTipoDTO> dtos = riduzioneTipoService.findByIds(ids);
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }


    @Operation(summary = "Recupera tutte i Tipologia Riduzione che soddisfano i criteri di ricerca", description = "La ricerca richiede dei criteri validi", tags = { "Tipologia Riduzione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Riduzione trovato"),
            @ApiResponse(responseCode = "204", description = "Nessun Tipo Riduzione trovato", content = {
                    @Content(mediaType = "application/json", schema = @Schema())}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @GetMapping("/ricerca")
    public ResponseEntity<Page<RiduzioneTipoDTO>> searchRiduzioneTipo(RiduzioneTipoCriteria criteria, Pageable pageRequest) {
        log.debug("REST request to search TipologiaRiduzione: {} {}", criteria, pageRequest);
        Page<RiduzioneTipoDTO> results = riduzioneTipoService.search(criteria, pageRequest);
        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }
    }


    @Operation(summary = "Aggiorna un Tipologia Riduzione", description = "L'aggiornamento richiede obbligatoriamente l'id del Tipo Riduzione da aggiornare", tags = { "Tipologia Riduzione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Riduzione aggiornato", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RiduzioneTipoDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Tipo Riduzione non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @PutMapping()
    public ResponseEntity<RiduzioneTipoDTO> updateRiduzioneTipo(@Validated @RequestBody RiduzioneTipoUpdateDTO dto) {
        log.debug("REST request to update TipologiaRiduzione: {}", dto);
        return new ResponseEntity<>(riduzioneTipoService.update(dto), HttpStatus.OK);
    }


    @Operation(summary = "Elimina un Tipologia Riduzione", description = "L'eliminazione richiede obbligatioramente l'id", tags = { "Tipologia Riduzione Resource" } )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipologia Riduzione eliminato", content = {
                    @Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Input non valido", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "401", description = "Azione non consentita", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))}),
            @ApiResponse(responseCode = "404", description = "Tipologia Riduzione non esiste", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Problem.class))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRiduzioneTipo(@PathVariable("id") UUID id) {
        log.debug("REST request to delete TipologiaRiduzione: {}", id);
        riduzioneTipoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}