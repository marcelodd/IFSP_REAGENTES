package br.com.ifsp.reagentes.ifspreagentes.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Marcelo
 */
public abstract class GenericDAO<T> extends JPAUtil{
    private final Class<T> entityClass;
      
    public GenericDAO(Class<T> clazz){
        this.entityClass = clazz;
    }
    
    public void persist(T entity){
        try{
            startTransaction();
            getEntityManager().persist(entity);
            endTransaction(true);
        }catch(Exception e){
            endTransaction(false);
            e.printStackTrace();
        }
    }
    
    public void merge(T entity){
         try{
            startTransaction();
            getEntityManager().merge(entity);
            endTransaction(true);
        }catch(Exception e){
            endTransaction(false);
            e.printStackTrace();
        }
    }
    
    public void remove(T entity){
         try{
            startTransaction();
            getEntityManager().remove(getEntityManager().merge(entity));
            endTransaction(true);
        }catch(Exception e){
            endTransaction(false);
            e.printStackTrace();
        }
    }
    
    public T find(Object id){
       return getEntityManager().find(entityClass, id);
    }
    
    public List<T> findAll(){
        CriteriaQuery cq = getEntityManager()
                .getCriteriaBuilder()
                .createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
     public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
