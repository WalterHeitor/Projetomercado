/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author walter heitor
 */
@Entity
public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String logadouro;
    @Column
    private String complemeto;
    @Column
    private String bairro;
    @Column
    private String cep;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(String logadouro, String complemeto, String bairro, String cep) {
        this.logadouro = logadouro;
        this.complemeto = complemeto;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Endereco(Integer id, String logadouro, String complemeto, String bairro, String cep) {
        this.id = id;
        this.logadouro = logadouro;
        this.complemeto = complemeto;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Endereco(String logadouro, String complemeto, String bairro, String cep, Cliente cliente) {
        this.logadouro = logadouro;
        this.complemeto = complemeto;
        this.bairro = bairro;
        this.cep = cep;
        this.cliente = cliente;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getComplemeto() {
        return complemeto;
    }

    public void setComplemeto(String complemeto) {
        this.complemeto = complemeto;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", logadouro=" + logadouro + ", complemeto=" + complemeto + ", bairro=" + bairro + ", cep=" + cep + '}';
    }
    
    
    
}
