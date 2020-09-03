/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class CidadeDAO {
    
    private static CidadeDAO instance;
    
    protected EntityManager entityManager;
    
    public static CidadeDAO getInstance(){
        if(instance == null){
            instance = new CidadeDAO();
        }
        return instance;
    }
    
    public CidadeDAO(){
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
    
    
    public Cidade getById(final Integer id){
        return entityManager.find(Cidade.class, id);
    }
    public List<Cidade> findAll(){
        return entityManager.createQuery("FROM"+ Cidade.class.getName())
                .getResultList();
    }
    public void persist(Cidade cidade){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Cidade cidade){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Cidade cidade){
        try {
            entityManager.getTransaction().begin();
            cidade = entityManager.find(Cidade.class, cidade.getId());
            entityManager.remove(cidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Cidade cidade = getById(id);
            remove(cidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
