/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import config.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import models.Borrow;
/**
 *
 * @author aya
 */
public class BorrowDAO {

    public List<Borrow> findAll(){
        EntityManager em = null;
        try{
            em = JPAUtil.getEntityManager();
            return em.createQuery("select b from Borrow b",Borrow.class).getResultList();
        }finally{
            em.close();
        }
    }
    
    public boolean insertOne(Borrow b){// NEW
         EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             em.persist(b);// NEW STATE -> MANAGED STATE
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close(); // MANAGED STATE -> DETACHED STATE
         }
    }
    
    
    public boolean updateOne(Borrow b){  // DETACHED
        
        EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             em.merge(b);// DETACHED STATE -> MANAGED STATE
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close();// MANAGED STATE -> DETACHED STATE
         }
    }
    
    
    public boolean deleteOne(Borrow b){ // DETACHED
        
         EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             Borrow managedBorrow = em.merge(b);
             em.remove(managedBorrow);
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close();
         }
    }
    
}
