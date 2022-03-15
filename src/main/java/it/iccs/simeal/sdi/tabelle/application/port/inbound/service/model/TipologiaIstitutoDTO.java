package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class TipologiaIstitutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private String descrizione;

	private Short flagElimina;

}
