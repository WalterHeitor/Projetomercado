package com.mycompany.mercado.doumain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ {

	public static volatile SingularAttribute<Endereco, String> complemeto;
	public static volatile SingularAttribute<Endereco, Cidade> cidade;
	public static volatile SingularAttribute<Endereco, Pessoa> pessoa;
	public static volatile SingularAttribute<Endereco, String> logadouro;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile SingularAttribute<Endereco, Integer> id;
	public static volatile SingularAttribute<Endereco, String> cep;

}

