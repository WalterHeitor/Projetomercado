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

        //instaciar();
        buscar();
        
        
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
        manager.persist(e);
        Estado estado = new Estado("goias");
        manager.persist(estado);
        Cidade cidade = new Cidade("itumbiara", estado);
        manager.persist(cidade);
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
