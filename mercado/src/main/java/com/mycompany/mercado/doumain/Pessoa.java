/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author walter heitor
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;
    @Column
    private String nome;
    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa")
    private List<Venda> vendas = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(Integer id_pessoa, String nome, String email) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(Integer id_pessoa, String nome, String email, Telefone telefone) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getId_pessoa() {
        return id_pessoa;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
