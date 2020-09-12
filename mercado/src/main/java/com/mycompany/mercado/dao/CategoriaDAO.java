/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class CategoriaDAO {
    
    private static CategoriaDAO instance;
    
    protected EntityManager entityManager;
    
    public static CategoriaDAO getInstance(){
        if(instance == null){
            instance = new CategoriaDAO();
        }
        return instance;
    }
    
    public CategoriaDAO(){
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
    
    
    public Categoria getById(final Integer id){
        return entityManager.find(Categoria.class, id);
    }
    public List<Categoria> findAll(){
        return entityManager.createQuery("FROM "+ Categoria.class.getName())
                .getResultList();
    }
    public void persist(Categoria categoria){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Categoria categoria){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Categoria categoria){
        try {
            entityManager.getTransaction().begin();
            categoria = entityManager.find(Categoria.class, categoria.getId());
            entityManager.remove(categoria);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Categoria categoria = getById(id);
            remove(categoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
