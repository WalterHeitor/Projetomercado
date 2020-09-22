/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mercado.dao;

import com.mycompany.mercado.doumain.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author walter heitor
 */
public class PessoaDAO {
    
    private static PessoaDAO instance;
    
    protected EntityManager entityManager;
    
    public static PessoaDAO getInstance(){
        if(instance == null){
            instance = new PessoaDAO();
        }
        return instance;
    }
    
    public PessoaDAO(){
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
    
    
    public Pessoa getById(final Integer id){
        return entityManager.find(Pessoa.class, id);
    }
    public List<Pessoa> findAll(){
        return entityManager.createQuery("FROM "+ Pessoa.class.getName())
                .getResultList();
    }
    public void persist(Pessoa pessoa){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void merge(Pessoa pessoa){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void remove(Pessoa pessoa){
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getId_pessoa());
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    public void removeById(final Integer id){
        try {
            Pessoa pessoa = getById(id);
            remove(pessoa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
