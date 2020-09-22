/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class ClienteDAO {
    
    private static ClienteDAO instance;
    
    protected EntityManager entityManager;
    
    public static ClienteDAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public ClienteDAO(){
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
    
    
    public Cliente getById(final Integer id){
        return entityManager.find(Cliente.class, id);
    }
    public List<Cliente> findAll(){
        return entityManager.createQuery("FROM "+ Cliente.class.getName())
                .getResultList();
    }
    public void persist(Cliente cliente){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Cliente cliente){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Cliente cliente){
        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Cliente.class, cliente.getCpf());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Cliente cliente = getById(id);
            remove(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
