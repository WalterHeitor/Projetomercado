/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class ProdutoDAO {
    
    private static ProdutoDAO instance;
    
    protected EntityManager entityManager;
    
    public static ProdutoDAO getInstance(){
        if(instance == null){
            instance = new ProdutoDAO();
        }
        return instance;
    }
    
    public ProdutoDAO(){
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
    
    
    public Produto getById(final String id){
        return entityManager.find(Produto.class, id);
    }
    public List<Produto> findAll(){
        return entityManager.createQuery("FROM "+ Produto.class.getName())
                .getResultList();
    }
    public void persist(Produto produto){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Produto produto){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Produto produto){
        try {
            entityManager.getTransaction().begin();
            produto = entityManager.find(Produto.class, produto.getId());
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final String id){
        try {
            Produto produto = getById(id);
            remove(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
