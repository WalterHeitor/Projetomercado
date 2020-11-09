package com.mycompany.mercado.doumain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pagamento.class)
public abstract class Pagamento_ {

	public static volatile SingularAttribute<Pagamento, Integer> estado;
	public static volatile SingularAttribute<Pagamento, Venda> venda;
	public static volatile SingularAttribute<Pagamento, Integer> id;

}

