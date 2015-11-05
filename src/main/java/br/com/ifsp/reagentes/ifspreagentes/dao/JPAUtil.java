/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifsp.reagentes.ifspreagentes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
public class JPAUtil {
    private static final EntityManagerFactory EMF;
    private static EntityManager entityManager;
    private static EntityTransaction transaction;
    
    static {
        EMF = Persistence.createEntityManagerFactory("QUIMICA_PU");
    }
    
    public static EntityManager getEntityManager(){
        if(entityManager == null){
            entityManager = EMF.createEntityManager();
        }
        return entityManager;
    }
    
    public static EntityTransaction getTransaction(){
        if(transaction == null){
            transaction = getEntityManager().getTransaction();
        }
        return transaction;
    }
    
    public static void startTransaction(){
        if(!getTransaction().isActive()){
            getTransaction().begin();
        }
    }
    
    public static void endTransaction(boolean commit){
        if(commit){
            getTransaction().commit();
        }else{
            getTransaction().rollback();
        }
    }
    
    public static void clear(){
        getEntityManager().clear();
    }
    
    public static void close(){
        getEntityManager().close();
    }
    
    public static Query createNativeQuery(String query,Class<?> classs){
       return getEntityManager().createNativeQuery(query, classs);
    }
    
    public static Query createQuery(String query,Class<?> classs){
       return getEntityManager().createQuery(query, classs);
    }
}
