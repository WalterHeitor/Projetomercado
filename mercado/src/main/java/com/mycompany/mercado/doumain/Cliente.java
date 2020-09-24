/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author walter heitor
 */
@PrimaryKeyJoinColumn(name = "id_pessoa")
@Entity

public class Cliente extends Pessoa{

    private static final long serialVersionUID = 1L;

    @Column
    private String cpf;
    

    public Cliente() {
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String cpf, String nome, String email, Calendar dataCadastro) {
        super(nome, email, dataCadastro);
        this.cpf = cpf;
    }

    public Cliente(String cpf, Integer id_pessoa, String nome, String email, Calendar dataCadastro) {
        super(id_pessoa, nome, email, dataCadastro);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + '}';
    }

    
}
