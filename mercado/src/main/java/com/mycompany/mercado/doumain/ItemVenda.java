/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author walter heitor
 */
@Entity
public class ItemVenda implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @EmbeddedId
    private ItemVendaPK id = new ItemVendaPK();
    
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemVenda() {
    }

    public ItemVenda(Venda venda, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setProduto(produto);
        id.setVenda(venda);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    public double getSubTotal(){
        return (preco - desconto) * quantidade;
    }
    @JsonIgnore
    public Venda getVenda(){
        return id.getVenda();
    }
    public void setVenda(Venda venda){
        id.setVenda(venda);
    }
    public Produto getProduto(){
        return id.getProduto();
    }
    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public ItemVendaPK getId() {
        return id;
    }

    public void setId(ItemVendaPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    
}
