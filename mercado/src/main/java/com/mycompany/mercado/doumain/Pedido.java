/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author walter heitor
 */
public class Pedido {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date  instane;
	
	//@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, 
			mappedBy = "pedido")
	private Pagamento pagamento;
	
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
}
