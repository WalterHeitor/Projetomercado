/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.doumain.enums;

/**
 *
 * @author walter heitor
 */
public enum UnidadeProduto {

    BARRA(1, "BARRA"),
    CX(2, "CAIXA"),
    CX2(3, "CAIXA COM 2 UNIDADES"),
    CX3(4, "CAIXA COM 3 UNIDADES"),
    CX5(5, "CAIXA COM 5 UNIDADES"),
    CX10(6, "CAIXA COM 10 UNIDADES"),
    CX12(6, "CAIXA COM 10 UNIDADES"),
    CX15(8, "CAIXA COM 15 UNIDADES"),
    DUZIA(9, "DUZIA"),
    FARDO(10, "FARDO"),
    FRASCO(11, "FRASCO"),
    GALAO(12, "GALÃO"),
    GF(13, "GARRAFA"),
    GRAMAS(14, "GRAMAS"),
    KG(15, "QUILOGRAMA"),
    KIT(16, "KIT"),
    LATA(17, "LATA"),
    LITRO(18, "LITRO"),
    M(19, "METRO"),
    UNID(20, "UNIDADE");

    private int codigo;
    private String descricao;

    private UnidadeProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
//GETTERS SETTERS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public static UnidadeProduto toEnum(Integer codigo){
        if (codigo == null) {
            return null;
        }
        for (UnidadeProduto x : UnidadeProduto.values()) {
            if (codigo.equals(x.getCodigo())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
