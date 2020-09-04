/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mycompany.mercado.doumain.enums.EstadoPagamento;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 *
 * @author walter heitor
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, 
	include = JsonTypeInfo.As.PROPERTY, property = "@type")

public class Pagamento implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer estado;
	
	//@JsonBackReference
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	private Pedido pedido;
        
        	public Pagamento() {
		super();
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = (estado==null) ? null : estado.getCodigo();
		this.pedido = pedido;
	}


}
