/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class EstadoDAO {
    
    private static EstadoDAO instance;
    
    protected EntityManager entityManager;
    
    public static EstadoDAO getInstance(){
        if(instance == null){
            instance = new EstadoDAO();
        }
        return instance;
    }
    
    public EstadoDAO(){
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
    
    
    public Estado getById(final Integer id){
        return entityManager.find(Estado.class, id);
    }
    public Estado getNome(String nome){
        List<Estado> estados = new ArrayList<>();
        Estado e = new Estado();
        estados = findAll();
        for (Estado estado: estados){
            if(nome.equalsIgnoreCase(estado.getNome())){
                e = entityManager.find(Estado.class, estado.getId());
            }
        }
        return e;
    }
    public List<Estado> findAll(){
        return entityManager.createQuery("FROM "+ Estado.class.getName())
                .getResultList();
    }
    public void persist(Estado estado){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(estado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Estado estado){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(estado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Estado estado){
        try {
            entityManager.getTransaction().begin();
            estado = entityManager.find(Estado.class, estado.getId());
            entityManager.remove(estado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Estado estado = getById(id);
            remove(estado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
