package com.mycompany.mercado.doumain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Integer> qtd;
	public static volatile SingularAttribute<Produto, String> marca;
	public static volatile SetAttribute<Produto, ItemVenda> itens;
	public static volatile SingularAttribute<Produto, Double> precoDeVenda;
	public static volatile SingularAttribute<Produto, Pessoa> pessoa;
	public static volatile SingularAttribute<Produto, Double> precoDeCusto;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
	public static volatile SingularAttribute<Produto, String> unidade;
	public static volatile SingularAttribute<Produto, String> id;
	public static volatile SingularAttribute<Produto, String> descricao;

}

