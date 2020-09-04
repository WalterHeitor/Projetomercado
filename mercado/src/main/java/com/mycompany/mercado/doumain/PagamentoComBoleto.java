/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mycompany.mercado.doumain.enums.EstadoPagamento;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author walter heitor
 */
@Entity
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento{

	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataVencimento;
	@JsonFormat(pattern = "dd/MM/yyyy")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date dataPagamento;
        
        public PagamentoComBoleto() {
		super();
	}

    public PagamentoComBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido,
			Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
}
