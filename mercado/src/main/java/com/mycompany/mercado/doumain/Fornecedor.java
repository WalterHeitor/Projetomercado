/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author walter heitor
 */
@PrimaryKeyJoinColumn(name="id_pessoa")
@Entity

public class Fornecedor extends Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Column
    private String fantasia;
    @Column
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(String fantasia) {
        this.fantasia = fantasia;
    }

    public Fornecedor(String fantasia, String cnpj) {

        this.fantasia = fantasia;
        this.cnpj = cnpj;

    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    
}
