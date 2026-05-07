/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import config.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;



/**
 *
 * @author aya
 */
public class BookDAO {
    
    public List<Integer> getAllbooksids() {
        EntityManager em=null;
        try{
            em =JPAUtil.getEntityManager();
            return em.createQuery("select b.bookId from Book b")
                .getResultList();
        }finally{
            em.close();
        }
        
    }
}
