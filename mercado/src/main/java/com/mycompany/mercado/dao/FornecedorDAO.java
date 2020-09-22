/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class FornecedorDAO {
    
    private static FornecedorDAO instance;
    
    protected EntityManager entityManager;
    
    public static FornecedorDAO getInstance(){
        if(instance == null){
            instance = new FornecedorDAO();
        }
        return instance;
    }
    
    public FornecedorDAO(){
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
    
    
    public Fornecedor getById(final Integer id){
        return entityManager.find(Fornecedor.class, id);
    }
    public List<Fornecedor> findAll(){
        return entityManager.createQuery("FROM "+ Fornecedor.class.getName())
                .getResultList();
    }
    public void persist(Fornecedor fornecedor){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Fornecedor fornecedor){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Fornecedor fornecedor){
        try {
            entityManager.getTransaction().begin();
            fornecedor = entityManager.find(Fornecedor.class, fornecedor.getCnpj());
            entityManager.remove(fornecedor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Fornecedor fornecedor = getById(id);
            remove(fornecedor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
