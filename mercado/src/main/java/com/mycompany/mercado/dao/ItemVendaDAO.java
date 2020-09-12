/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.ItemVenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class ItemVendaDAO {
    
    private static ItemVendaDAO instance;
    
    protected EntityManager entityManager;
    
    public static ItemVendaDAO getInstance(){
        if(instance == null){
            instance = new ItemVendaDAO();
        }
        return instance;
    }
    
    public ItemVendaDAO(){
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
    
    
    public ItemVenda getById(final Integer id){
        return entityManager.find(ItemVenda.class, id);
    }
    public List<ItemVenda> findAll(){
        return entityManager.createQuery("FROM "+ ItemVenda.class.getName())
                .getResultList();
    }
    public void persist(ItemVenda itemVenda){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(itemVenda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(ItemVenda itemVenda){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(itemVenda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(ItemVenda itemVenda){
        try {
            entityManager.getTransaction().begin();
            itemVenda = entityManager.find(ItemVenda.class, itemVenda.getId());
            entityManager.remove(itemVenda);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            ItemVenda itemVenda = getById(id);
            remove(itemVenda);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
