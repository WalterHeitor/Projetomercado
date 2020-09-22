package com.mycompany.mercado.doumain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemVenda.class)
public abstract class ItemVenda_ {

	public static volatile SingularAttribute<ItemVenda, Double> preco;
	public static volatile SingularAttribute<ItemVenda, Double> desconto;
	public static volatile SingularAttribute<ItemVenda, ItemVendaPK> id;
	public static volatile SingularAttribute<ItemVenda, Integer> quantidade;

}

