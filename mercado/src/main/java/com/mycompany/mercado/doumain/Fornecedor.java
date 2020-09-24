/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author walter heitor
 */
@PrimaryKeyJoinColumn(name="id_pessoa")
@Entity

public class Fornecedor extends Pessoa {
    
    private static final long serialVersionUID = 1L;

    @Column
    private String fantasia;
    @Column
    private String razaoSociao;
    @Column
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(String fantasia, String razaoSociao, String cnpj) {
        this.fantasia = fantasia;
        this.razaoSociao = razaoSociao;
        this.cnpj = cnpj;
    }

    public Fornecedor(String fantasia, String razaoSociao, String cnpj, String nome, String email, Calendar dataCadastro) {
        super(nome, email, dataCadastro);
        this.fantasia = fantasia;
        this.razaoSociao = razaoSociao;
        this.cnpj = cnpj;
    }

    public Fornecedor(String fantasia, String razaoSociao, String cnpj, Integer id_pessoa, String nome, String email, Calendar dataCadastro) {
        super(id_pessoa, nome, email, dataCadastro);
        this.fantasia = fantasia;
        this.razaoSociao = razaoSociao;
        this.cnpj = cnpj;
    }


    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getRazaoSociao() {
        return razaoSociao;
    }

    public void setRazaoSociao(String razaoSociao) {
        this.razaoSociao = razaoSociao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
    
}
