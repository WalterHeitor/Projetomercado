/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado;

import com.mycompany.mercado.dao.ClienteDAO;
import com.mycompany.mercado.doumain.Categoria;
import com.mycompany.mercado.doumain.Cidade;
import com.mycompany.mercado.doumain.Cliente;
import com.mycompany.mercado.doumain.Endereco;
import com.mycompany.mercado.doumain.Estado;
import com.mycompany.mercado.doumain.Produto;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author walter heitor
 */
public class main {
    public static void main(String[] args) {

        instaciar();
        //buscar();
        
        
    }
    public static void instaciar(){
        EntityManager manager = Persistence.createEntityManagerFactory("vendas")
                .createEntityManager();
        manager.getTransaction().begin();
        //##########            Cliente         ##########
        Cliente c = new Cliente("walter", "8475938574", "walter@heitor");
        System.out.println("Cliente ---- "+ c);
        manager.persist(c);
        Endereco e = new Endereco("logadouro", "complemeto", "bairro",
                "79809499191", c);
        Estado estado = new Estado("goias");
        Cidade cidade = new Cidade("itumbiara", estado);
        e.setCidade(cidade);
        manager.persist(e);
        manager.persist(estado);
        manager.persist(cidade);
        //##########            Cliente 1        ##########
        Cliente c1 = new Cliente("maria clara", "12345678911", "maria@clara");
        Cliente c2 = new Cliente("roberta miranda", "12345678911", "robert@miranda");
        Cliente c3 = new Cliente("mario quintana", "12311178911", "mario@quintana");
        Cliente c4 = new Cliente("martagonzales", "11111118911", "marta@gozales");
        Endereco e1 = new Endereco("rua antonio domingos borges", "N° 129", "marolina", "123456-000", c1);
        Endereco e2 = new Endereco("rua olegario aquino ramos", "N° 13", "multirao", "122226-000", c2);
        Endereco e3 = new Endereco("rua mariana tomas borges", "N° 29", "morada dos sonhos", "222256-000", c2);
        Endereco e4 = new Endereco("rua mario domingos alves", "N° 19", "planalto", "990056-000", c3);
        Endereco e5 = new Endereco("rua antonio bbbbbbbb borges", "N° 129", "bbbbbbbbbb", "333333-000", c4);
        Estado est1 = new Estado("MG");
        Cidade cid1 = new Cidade("Uberlandia", est1);
        Estado est2 = new Estado("MT");
        Cidade cid2 = new Cidade("Campo Verde", est2);
        Estado est3 = new Estado("AL");
        Cidade cid3 = new Cidade("Paracatu", est3);
        Estado est4 = new Estado("SP");
        Cidade cid4 = new Cidade("São Paulo", est4);
        Estado est5 = new Estado("PR");
        Cidade cid5 = new Cidade("Fox do Iguaçu", est5);
        e1.setCidade(cid1);
        e2.setCidade(cid2);
        e3.setCidade(cid3);
        e4.setCidade(cid4);
        e5.setCidade(cid5);
        
        manager.persist(c1);
        manager.persist(c2);
        manager.persist(c3);
        manager.persist(c4);
        
        manager.persist(e1);
        manager.persist(e2);
        manager.persist(e3);
        manager.persist(e4);
        manager.persist(e5);
        
        manager.persist(est1);
        manager.persist(est2);
        manager.persist(est3);
        manager.persist(est4);
        manager.persist(est5);
        manager.persist(cid1);
        manager.persist(cid2);
        manager.persist(cid3);
        manager.persist(cid4);
        manager.persist(cid5);


        //#########         Categoria           ##########
        Categoria cat1 = new Categoria("Informática");
	Categoria cat2 = new Categoria("Escritório");
	Categoria cat3 = new Categoria("Eletronicos");
        Categoria cat4 = new Categoria("Cama mesa e banho");
	Categoria cat5 = new Categoria("Mecanica");
	Categoria cat6 = new Categoria("Solda");
        //#########         Produtos            ##########
        Produto p1 = new Produto("12345", "Computador", 2000.00);
	Produto p2 = new Produto("23456", "Impressora", 800.00);
	Produto p3 = new Produto("34567", "Mouse", 80.00);
	Produto p4 = new Produto("45678", "Mesa de escritorio", 300.00);
	Produto p5 = new Produto("54321", "Toalha", 50.00);
	Produto p6 = new Produto("65432", "Colcha", 200.00);
	Produto p7 = new Produto("76543", "TV 50 pol sansung", 2680.00);
	Produto p8 = new Produto("87654", "Roçadeira", 780.00);
	Produto p9 = new Produto("98765", "Abajur", 70.00);
        
        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2,p4));
        cat3.getProdutos().addAll(Arrays.asList(p5,p6));
        
        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
	p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
	p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
	p4.getCategorias().addAll(Arrays.asList(cat2));
	p5.getCategorias().addAll(Arrays.asList(cat3));
	p6.getCategorias().addAll(Arrays.asList(cat3));
	p7.getCategorias().addAll(Arrays.asList(cat4));
	p8.getCategorias().addAll(Arrays.asList(cat5));
	p9.getCategorias().addAll(Arrays.asList(cat6));
        
        manager.persist(p1);
        manager.persist(p2);
        manager.persist(p3);
        manager.persist(p4);
        manager.persist(p5);
        manager.persist(p6);
        manager.persist(p7);
        manager.persist(p8);
        manager.persist(p9);
        manager.persist(cat1);
        manager.persist(cat2);
        manager.persist(cat3);
        manager.persist(cat4);
        manager.persist(cat5);
        manager.persist(cat6);
        
        
        
        manager.getTransaction().commit();
        manager.close();
      
    }
    public static void buscar(){
        List<Cliente> c1 = ClienteDAO.getInstance().findAll();
        System.out.println("CLIENTE---------"+c1);
    }
}
