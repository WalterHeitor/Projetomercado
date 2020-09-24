package com.mycompany.mercado.doumain;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> id_pessoa;
	public static volatile SingularAttribute<Pessoa, Telefone> telefone;
	public static volatile ListAttribute<Pessoa, Endereco> enderecos;
	public static volatile ListAttribute<Pessoa, Produto> produtos;
	public static volatile ListAttribute<Pessoa, Venda> vendas;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, Calendar> dataCadastro;
	public static volatile SingularAttribute<Pessoa, String> email;

}

