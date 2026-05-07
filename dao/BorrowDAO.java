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
    
//    public boolean insertOne(Borrow b){
//    
//    
//    }
//    
//    
//    public boolean updateOne(Borrow b){
//    
//    }
//    
//    
//    public boolean deleteOne(Borrow b){
//    
//    
//    
//    
//    }
}