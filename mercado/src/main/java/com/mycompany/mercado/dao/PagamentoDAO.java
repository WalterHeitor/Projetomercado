/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Pagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class PagamentoDAO {
    
    private static PagamentoDAO instance;
    
    protected EntityManager entityManager;
    
    public static PagamentoDAO getInstance(){
        if(instance == null){
            instance = new PagamentoDAO();
        }
        return instance;
    }
    
    public PagamentoDAO(){
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
    
    
    public Pagamento getById(final Integer id){
        return entityManager.find(Pagamento.class, id);
    }
    public List<Pagamento> findAll(){
        return entityManager.createQuery("FROM "+ Pagamento.class.getName())
                .getResultList();
    }
    public void persist(Pagamento pagamento){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Pagamento pagamento){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Pagamento pagamento){
        try {
            entityManager.getTransaction().begin();
            pagamento = entityManager.find(Pagamento.class, pagamento.getClass());
            entityManager.remove(pagamento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Pagamento pagamento = getById(id);
            remove(pagamento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
