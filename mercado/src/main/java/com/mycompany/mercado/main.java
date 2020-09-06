/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado;

import com.mycompany.mercado.dao.ClienteDAO;
import com.mycompany.mercado.doumain.Cidade;
import com.mycompany.mercado.doumain.Cliente;
import com.mycompany.mercado.doumain.Endereco;
import com.mycompany.mercado.doumain.Estado;
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
        manager.persist(e);
        Estado estado = new Estado("goias");
        manager.persist(estado);
        Cidade cidade = new Cidade("itumbiara", estado);
        manager.persist(cidade);
        //#########         Categoria           ##########
        
        manager.getTransaction().commit();
        manager.close();
      
    }
    public static void buscar(){
        Cliente c1 = ClienteDAO.getInstance().getById(1);
        System.out.println("CLIENTE---------"+c1);
    }
}
