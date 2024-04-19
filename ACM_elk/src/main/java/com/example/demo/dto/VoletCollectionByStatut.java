package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoletCollectionByStatut {
	private long nbdossier;
	private String statutLibelle;
	public VoletCollectionByStatut(long nbdossier, String statutLibelle) {

		super();
		this.nbdossier = nbdossier;
		this.statutLibelle = statutLibelle;
	}

}
