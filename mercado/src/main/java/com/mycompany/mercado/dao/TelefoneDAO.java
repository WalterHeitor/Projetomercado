/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Telefone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class TelefoneDAO {
    
    private static TelefoneDAO instance;
    
    protected EntityManager entityManager;
    
    public static TelefoneDAO getInstance(){
        if(instance == null){
            instance = new TelefoneDAO();
        }
        return instance;
    }
    
    public TelefoneDAO(){
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
    
    
    public Telefone getById(final Integer id){
        return entityManager.find(Telefone.class, id);
    }
    public List<Telefone> findAll(){
        return entityManager.createQuery("FROM "+ Telefone.class.getName())
                .getResultList();
    }
    public void persist(Telefone telefone){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(telefone);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Telefone telefone){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(telefone);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Telefone telefone){
        try {
            entityManager.getTransaction().begin();
            telefone = entityManager.find(Telefone.class, telefone.getClass());
            entityManager.remove(telefone);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Telefone telefone = getById(id);
            remove(telefone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
