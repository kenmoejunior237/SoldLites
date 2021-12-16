package com.example.soldLites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "table_Composer")
public class Composer {

	@Column(name = "qte_Commander")
	private int quantite;
}
