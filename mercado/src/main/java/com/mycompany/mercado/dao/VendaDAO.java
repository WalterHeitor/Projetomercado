/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class VendaDAO {
    
    private static VendaDAO instance;
    
    protected EntityManager entityManager;
    
    public static VendaDAO getInstance(){
        if(instance == null){
            instance = new VendaDAO();
        }
        return instance;
    }
    
    public VendaDAO(){
        entityManager = getEntityManager();
    }
    private EntityManager getEntityManager(){
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("vendas");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    
    
    public Venda getById(final Integer id){
        return entityManager.find(Venda.class, id);
    }
    public List<Venda> findAll(){
        return entityManager.createQuery("FROM "+ Venda.class.getName())
                .getResultList();
    }
    public void persist(Venda venda){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(venda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Venda venda){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(venda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Venda venda){
        try {
            entityManager.getTransaction().begin();
            venda = entityManager.find(Venda.class, venda.getId());
            entityManager.remove(venda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Venda venda = getById(id);
            remove(venda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
