/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class EnderecoDAO {
    
    private static EnderecoDAO instance;
    
    protected EntityManager entityManager;
    
    public static EnderecoDAO getInstance(){
        if(instance == null){
            instance = new EnderecoDAO();
        }
        return instance;
    }
    
    public EnderecoDAO(){
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
    
    
    public Endereco getById(final Integer id){
        return entityManager.find(Endereco.class, id);
    }
    public List<Endereco> findAll(){
        return entityManager.createQuery("FROM"+ Endereco.class.getName())
                .getResultList();
    }
    public void persist(Endereco endereco){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Endereco endereco){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Endereco endereco){
        try {
            entityManager.getTransaction().begin();
            endereco = entityManager.find(Endereco.class, endereco.getId());
            entityManager.remove(endereco);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Endereco endereco = getById(id);
            remove(endereco);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
