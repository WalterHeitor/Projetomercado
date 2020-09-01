/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado;

import com.mycompany.mercado.doumain.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author walter heitor
 */
public class main {
    public static void main(String[] args) {
        Cliente c = new Cliente("walter", "8475938574", "walter@heitor");
        System.out.println("Cliente ---- "+ c);
        EntityManager manager = Persistence.createEntityManagerFactory("vendas").createEntityManager();
        System.out.println("1");
        manager.getTransaction().begin();
        System.out.println("2");
        manager.persist(c);
        System.out.println("3");
        manager.getTransaction().commit();
        manager.close();
    }
}
