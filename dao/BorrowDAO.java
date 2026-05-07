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
        EntityManager em=null;
        try{
            em =JPAUtil.getEntityManager();
            return em.createQuery("select b from Borrow b",Borrow.class)
                .getResultList();
        }finally{
            em.close();
        }
        
        
    }
    
    public boolean insertOne(Borrow b){
        EntityManager em=null;
        try{
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;    
        
        }finally{
            em.close();
        }
    }
    
    
    public boolean updateOne(Borrow b){
        EntityManager em=null;
        try{
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(b);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    
    public boolean deleteOne(Borrow b){
        EntityManager em=null;
        try{
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Borrow borrow = em.merge(b);
            em.remove(borrow);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }finally{
            em.close();
        }
    }
}