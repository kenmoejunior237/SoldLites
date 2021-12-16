package com.example.soldLites.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "TableLivrer")
public class Livrer {


	@Column(name = "date_Livrer")
	private long dateLivrer;
	
}
